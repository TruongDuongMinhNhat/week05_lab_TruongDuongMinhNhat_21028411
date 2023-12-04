package dev.minhnhat.week05_lab_truongduongminhnhat_21028411.frontend.controllers;

import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models.Address;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models.Candidate;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models.Company;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.repositories.AddressRepository;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.repositories.JobRepository;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.services.impl.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private CandidateService candidateService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private JobService jobService;
    @Autowired
    private SkillService skillService;

    @GetMapping
    public String directToHomePage(HttpServletRequest request) {
        return "home";
    }

    @GetMapping("/login")
    public String directToLogin(HttpServletRequest request) {
        request.getServletContext().setAttribute("account", null);
        return "index";
    }

    @GetMapping("/register")
    public String directToRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String registerAccount(
            @RequestParam("typeCreate") String typeCreate,
            @RequestParam(required = false) String companyName,
            @RequestParam(required = false) String companyPhone,
            @RequestParam(required = false) String companyEmail,
            @RequestParam(required = false) String companyWebURL,
            @RequestParam(required = false) String companyAbout,
            @RequestParam(required = false) String companyPassword,
            @RequestParam(required = false) String canFullName,
            @RequestParam(required = false) String canDob,
            @RequestParam(required = false) String canPhone,
            @RequestParam(required = false) String canEmail,
            @RequestParam(required = false) String canPassword,
            @RequestParam String street,
            @RequestParam String city,
            @RequestParam String country,
            @RequestParam String number,
            @RequestParam String zipCode,
            Model model,
            HttpServletRequest request
    ) {
        if(typeCreate.equalsIgnoreCase("Candidate")) {
            String[] splitDate = canDob.split("-");
            LocalDate dob = LocalDate.of(Integer.parseInt(splitDate[0]), Integer.parseInt(splitDate[1]), Integer.parseInt(splitDate[2]));

            Address address = new Address(street, city, Short.parseShort(country), number, zipCode);
            Candidate candidate = new Candidate(canFullName, dob, canPhone, canEmail, canPassword, address);

            Company company = companyService.findByEmail(canEmail).orElse(null);
            if(company != null) {
                model.addAttribute("registerFailed", "This email has already been registered");
                return "register";
            }

            addressService.save(address);
            candidateService.save(candidate);

        } else {
            Address address = new Address(street, city, Short.parseShort(country), number, zipCode);
            Company company = new Company(companyName, companyPhone, companyEmail, companyWebURL, companyAbout, companyPassword, address);

            Candidate candidate = candidateService.findByEmail(companyEmail).orElse(null);
            if(candidate != null) {
                model.addAttribute("registerFailed", "This email has already been registered");
                return "register";
            }

            addressService.save(address);
            companyService.save(company);
        }

        return "index";
    }

    @PostMapping("/login")
    public String loginAccount(@RequestParam String email, @RequestParam String password, Model model, HttpServletRequest request) {
        Candidate candidate = candidateService.checkLogin(email,password).orElse(null);
        if(candidate != null) {
            model.addAttribute("typeAccount", "candidate");
            model.addAttribute("listSkills", skillService.findAll());
            model.addAttribute("listJobs", jobService.findAll());
            request.getServletContext().setAttribute("account", candidate);
            return "home";
        }

        Company company = companyService.checkLogin(email,password).orElse(null);
        if(company != null) {
            model.addAttribute("typeAccount", "company");
            model.addAttribute("listSkills", skillService.findAll());
            model.addAttribute("listJobs", jobService.findAllByCompany(company));
            request.getServletContext().setAttribute("account", company);
            return "home";
        }

        model.addAttribute("loginFailed", "Your email and password is not correct!");
        return "index";
    }
}
