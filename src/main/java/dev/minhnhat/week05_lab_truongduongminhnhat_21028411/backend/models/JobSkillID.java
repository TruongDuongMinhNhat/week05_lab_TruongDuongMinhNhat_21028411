package dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter @Setter @NoArgsConstructor
public class JobSkillID implements Serializable {
    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;
    @ManyToOne
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    public JobSkillID(Job job, Skill skill) {
        this.job = job;
        this.skill = skill;
    }
}
