package dev.minhnhat.week05_lab_truongduongminhnhat_21028411.frontend.controllers;

import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models.Company;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.repositories.AddressRepository;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.services.impl.CompanyService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/view-account-company")
    public String directToViewAccount(Model model, HttpServletRequest request) {
        Company company = (Company) request.getServletContext().getAttribute("account");
        model.addAttribute("company", company);
        return "company/view_account_company";
    }

    @GetMapping("/update-account-company")
    public String directToUpdateAccount(Model model, HttpServletRequest request) {
        Company company = (Company) request.getServletContext().getAttribute("account");
        model.addAttribute("company", company);
        return "company/update_account_company";
    }

    @PostMapping("/update-account-company/{companyId}")
    public String updateAccount(@PathVariable("companyId") String id,
                                @RequestParam("companyName") String companyName,
                                @RequestParam("email") String email,
                                @RequestParam("phone") String phone,
                                @RequestParam(value = "webURL", required = false) String webURL,
                                @RequestParam("password") String password,
                                @RequestParam(value = "about", required = false) String about,
                                Model model, HttpServletRequest request) {
        Company company = companyService.findById(Long.parseLong(id)).get();
        company.setCompanyName(companyName);
        company.setEmail(email);
        company.setPhone(phone);
        company.setWebURL(webURL);
        company.setPassword(password);
        company.setAbout(about);

        model.addAttribute("account", company);
        return "company/view_account_company";
    }
}
