package dev.minhnhat.week05_lab_truongduongminhnhat_21028411.frontend.controllers;

import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models.Candidate;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.services.impl.CandidateService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @GetMapping("/view-account-candidate")
    public ModelAndView directToViewAccount(HttpServletRequest request) {
        ModelAndView model = new ModelAndView("candidate/view_account_candidate");
        Candidate candidate = (Candidate) request.getServletContext().getAttribute("account");

        model.addObject("candidate", candidate);
        return model;
    }

    @GetMapping("/update-account-candidate")
    public String directToUpdateAccount(Model model, HttpServletRequest request) {
        Candidate candidate = (Candidate) request.getServletContext().getAttribute("account");
        model.addAttribute("account", candidate);

        return "candidate/update_account_candidate";
    }

    @PostMapping("/update-account-candidate/{candidateId}")
    public String updateAccount(@PathVariable("candidateId") String id,
                                @RequestParam String dob,
                                @RequestParam String phone,
                                @RequestParam String fullName,
                                @RequestParam String email,
                                @RequestParam String password,
                                @RequestParam String street,
                                @RequestParam String city,
                                @RequestParam String country,
                                @RequestParam String number,
                                @RequestParam String zipCode,
                                Model model, HttpServletRequest request) {
        Candidate candidate = candidateService.findById(Long.parseLong(id)).orElse(null);
        if(candidate == null) {
            return "/home";
        }
        String[] splitDate = dob.split("-");

        candidate.setFullName(fullName);
        candidate.setDob(LocalDate.of(
                Integer.parseInt(splitDate[0]),
                Integer.parseInt(splitDate[1]),
                Integer.parseInt(splitDate[2])
        ));
        candidate.setPhone(phone);
        candidate.setEmail(email);
        candidate.setPassword(password);
        candidate.getAddress().setStreet(street);
        candidate.getAddress().setCity(city);
        candidate.getAddress().setCountry(Short.parseShort(country));
        candidate.getAddress().setNumber(number);
        candidate.getAddress().setZipCode(zipCode);

        candidateService.save(candidate);
        model.addAttribute("candidate", candidate);
        return "candidate/view_account_candidate";
    }
}
