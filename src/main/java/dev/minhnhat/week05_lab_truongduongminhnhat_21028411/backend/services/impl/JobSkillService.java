package dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.services.impl;

import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models.Job;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models.JobSkill;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models.JobSkillID;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models.Skill;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.repositories.JobSkillRepository;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.services.IServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobSkillService implements IServices<JobSkill, JobSkillID> {
    private final JobSkillRepository jobSkillRepository;

    @Autowired
    public JobSkillService(JobSkillRepository jobSkillRepository) {
        this.jobSkillRepository = jobSkillRepository;
    }

    @Override
    public boolean save(JobSkill jobSkill) {
        try {
            jobSkillRepository.save(jobSkill);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteById(JobSkillID jobSkillID) {
        try {
            jobSkillRepository.deleteById(jobSkillID);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(JobSkill jobSkill) {
        try {
            jobSkillRepository.delete(jobSkill);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<JobSkill> findById(JobSkillID jobSkillID) {
        return jobSkillRepository.findById(jobSkillID);
    }

    @Override
    public List<JobSkill> findAll() {
        return jobSkillRepository.findAll();
    }

    public Optional<JobSkill> checkJobSkill(Job job, Skill skill) {
        return jobSkillRepository.findJobSkillByJobSkillID_JobAndJobSkillID_Skill(job, skill);
    }
}