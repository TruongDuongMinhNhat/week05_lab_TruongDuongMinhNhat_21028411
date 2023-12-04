package dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models;

import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.enums.SkillType;
import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity @Table(name = "skill")
@Getter @Setter @NoArgsConstructor
public class Skill {
    @Id
    @Column(name = "skill_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "skill_name", nullable = false)
    private String skillName;

    @Column(name = "skill_description", nullable = false)
    private String skillDescription;

    @Enumerated(EnumType.ORDINAL)
    @Column(columnDefinition = "TINYINT(4)", nullable = false)
    private SkillType type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobSkillID.skill")
    private List<JobSkill> jobSkills;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidateSkillID.skill")
    private List<CandidateSkill> candidateSkills;

    public Skill(String skillName, String skillDescription, SkillType type) {
        this.skillName = skillName;
        this.skillDescription = skillDescription;
        this.type = type;
    }
}
