package dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models;

import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.enums.SkillLevel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table(name = "candidate_skill")
@Getter @Setter @NoArgsConstructor
public class CandidateSkill {
    @EmbeddedId
    private CandidateSkillID candidateSkillID;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "skill_level", nullable = false, columnDefinition = "TINYINT(4)")
    private SkillLevel skillLevel;
    @Column(name = "more_infos", nullable = false, length = 1000)
    private String moreInfos;

    public CandidateSkill(Candidate candidate, Skill skill, SkillLevel skillLevel, String moreInfos) {
        this.candidateSkillID = new CandidateSkillID(candidate, skill);
        this.skillLevel = skillLevel;
        this.moreInfos = moreInfos;
    }
}
