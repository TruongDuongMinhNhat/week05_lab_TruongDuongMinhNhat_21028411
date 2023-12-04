package dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models;

import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.enums.SkillLevel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table(name = "job_skill")
@Getter @Setter @NoArgsConstructor
public class JobSkill {
    @EmbeddedId
    private JobSkillID jobSkillID;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "skill_level", nullable = false, columnDefinition = "TINYINT(4)")
    private SkillLevel skillLevel;
    @Column(name = "more_infos", nullable = false, length = 1000)
    private String moreInfos;

    public JobSkill(Job job, Skill skill, SkillLevel skillLevel, String moreInfos) {
        this.jobSkillID = new JobSkillID(job, skill);
        this.skillLevel = skillLevel;
        this.moreInfos = moreInfos;
    }
}
