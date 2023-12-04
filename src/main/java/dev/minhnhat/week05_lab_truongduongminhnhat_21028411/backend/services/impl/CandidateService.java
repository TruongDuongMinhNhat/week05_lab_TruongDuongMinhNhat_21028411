package dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.services.impl;

import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models.Candidate;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.repositories.CandidateRepository;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.services.IServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService implements IServices<Candidate, Long> {
    private final CandidateRepository candidateRepository;

    @Autowired
    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public boolean save(Candidate candidate) {
        try {
            candidateRepository.save(candidate);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            candidateRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Candidate candidate) {
        try {
            candidateRepository.delete(candidate);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<Candidate> findById(Long id) {
        return candidateRepository.findById(id);
    }

    @Override
    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }

    public Optional<Candidate> findByEmail(String email) {
        return candidateRepository.findCandidateByEmail(email);
    }

    public Optional<Candidate> checkLogin(String email, String password) {
        return candidateRepository.findCandidateByEmailAndPassword(email, password);
    }
}
