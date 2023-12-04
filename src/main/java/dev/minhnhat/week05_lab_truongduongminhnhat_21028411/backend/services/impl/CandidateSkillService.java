package dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.services.impl;

import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models.CandidateSkill;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models.CandidateSkillID;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.repositories.CandidateSkillRepository;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.services.IServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateSkillService implements IServices<CandidateSkill, CandidateSkillID> {
    private final CandidateSkillRepository candidateSkillRepository;

    @Autowired
    public CandidateSkillService(CandidateSkillRepository candidateSkillRepository) {
        this.candidateSkillRepository = candidateSkillRepository;
    }

    @Override
    public boolean save(CandidateSkill candidateSkill) {
        try {
            candidateSkillRepository.save(candidateSkill);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteById(CandidateSkillID candidateSkillID) {
        try {
            candidateSkillRepository.deleteById(candidateSkillID);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(CandidateSkill candidateSkill) {
        try {
            candidateSkillRepository.delete(candidateSkill);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<CandidateSkill> findById(CandidateSkillID candidateSkillID) {
        return candidateSkillRepository.findById(candidateSkillID);
    }

    @Override
    public List<CandidateSkill> findAll() {
        return candidateSkillRepository.findAll();
    }
}
