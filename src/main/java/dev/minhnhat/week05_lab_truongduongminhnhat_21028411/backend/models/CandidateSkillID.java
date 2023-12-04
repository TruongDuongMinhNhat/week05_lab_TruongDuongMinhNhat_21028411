package dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter @Setter @NoArgsConstructor
public class CandidateSkillID implements Serializable {
    @ManyToOne
    @JoinColumn(name = "can_id", nullable = false)
    private Candidate candidate;
    @ManyToOne
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    public CandidateSkillID(Candidate candidate, Skill skill) {
        this.candidate = candidate;
        this.skill = skill;
    }
}
