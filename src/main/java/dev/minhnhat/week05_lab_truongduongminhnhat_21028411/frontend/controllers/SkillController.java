package dev.minhnhat.week05_lab_truongduongminhnhat_21028411.frontend.controllers;

import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.services.impl.CandidateSkillService;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.services.impl.SkillService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/skill")
public class SkillController {

    @Autowired
    private SkillService skillService;
    @Autowired
    private CandidateSkillService candidateSkillService;

    @GetMapping("/learn-skill")
    public String directToLearnSkill(Model model, HttpServletRequest request) {

        model.addAttribute("listSkills", skillService.findAll());
        return "skill/learn_skill_candidate";
    }
}
