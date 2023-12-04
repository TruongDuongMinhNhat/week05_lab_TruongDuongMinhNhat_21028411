package dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.services.impl;

import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models.Company;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models.Job;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.repositories.JobRepository;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.services.IServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService implements IServices<Job, Long> {
    private final JobRepository jobRepository;

    @Autowired
    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public boolean save(Job job) {
        try {
            jobRepository.save(job);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Job job) {
        try {
            jobRepository.delete(job);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<Job> findById(Long id) {
        return jobRepository.findById(id);
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    public List<Job> findAllByCompany(Company company) {
        return jobRepository.findAllByCompany(company);
    }
}
