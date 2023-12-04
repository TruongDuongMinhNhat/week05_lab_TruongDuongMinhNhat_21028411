package dev.minhnhat.week05_lab_truongduongminhnhat_21028411.frontend.controllers;

import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.enums.SkillLevel;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models.Company;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models.Job;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models.JobSkill;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models.Skill;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.services.impl.CompanyService;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.services.impl.JobService;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.services.impl.JobSkillService;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.services.impl.SkillService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobService jobService;
    @Autowired
    private SkillService skillService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private JobSkillService jobSkillService;

    @GetMapping("/create-job")
    public String directToCreateJob(Model model, HttpServletRequest request) {
        return "job/add_job";
    }

    @PostMapping("/create-job")
    public String addJob(@RequestParam String jobName, @RequestParam String jobDescription,
                         Model model, HttpServletRequest request) {
        Company company = (Company) request.getServletContext().getAttribute("account");
        Job job = new Job(jobName, jobDescription, company);
        jobService.save(job);

        model.addAttribute("addJobSkillFailed", null);
        model.addAttribute("listSkills", skillService.findAll());
        model.addAttribute("jobDetail", job);
        return "job/add_skill_job";
    }

    @GetMapping("/stop-add-skill")
    public String stopAddSkill(Model model, HttpServletRequest request) {
        Company company = (Company) request.getServletContext().getAttribute("account");

        model.addAttribute("typeAccount", "company");
        model.addAttribute("listSkills", skillService.findAll());
        model.addAttribute("listJobs", jobService.findAllByCompany(company));
        return "home";
    }

    @PostMapping("/add-skill-job/{jobId}")
    public String addSkillJob(@PathVariable("jobId") String jobId, @RequestParam String skillId,
                              @RequestParam String skillLevel, @RequestParam(required = false) String moreInfo,
                              Model model, HttpServletRequest request) {

        Job job = jobService.findById(Long.parseLong(jobId)).get();
        Skill skill = skillService.findById(Long.parseLong(skillId)).get();
        JobSkill jobSkill = new JobSkill(job, skill, SkillLevel.getValue(Integer.parseInt(skillLevel)), moreInfo);


        JobSkill target = jobSkillService.checkJobSkill(job, skill).orElse(null);
        if(target == null) {
            model.addAttribute("addJobSkillFailed", "Add success!");
            jobSkillService.save(jobSkill);
        } else {
            model.addAttribute("addJobSkillFailed", "The skill for this job has already been added!");
        }

        model.addAttribute("addJobSkillFailed", null);
        model.addAttribute("listSkills", skillService.findAll());
        model.addAttribute("jobDetail", job);
        return "job/add_skill_job";
    }

    @GetMapping("/view_job_detail/{jobId}")
    public String viewJob(@PathVariable("jobId") String id, Model model, HttpServletRequest request) {
        Job job = jobService.findById(Long.parseLong(id)).get();

        model.addAttribute("jobDetail", job);
        return "job/view_job";
    }

    @GetMapping("/delete_job/{jobId}")
    public String deleteJob(@PathVariable("jobId") String id, Model model, HttpServletRequest request) {
        Company company = (Company) request.getServletContext().getAttribute("account");
        Job job = jobService.findById(Long.parseLong(id)).get();

        jobService.delete(job);

        model.addAttribute("typeAccount", "company");
        model.addAttribute("listSkills", skillService.findAll());
        model.addAttribute("listJobs", jobService.findAllByCompany(company));

        return "home";
    }
}
