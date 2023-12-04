package dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity @Table(name = "job")
@Getter @Setter @NoArgsConstructor
public class Job {
    @Id
    @Column(name = "job_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String jobName;
    @Column(length = 2000)
    private String jobDesc;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Company company;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobSkillID.job")
    private List<JobSkill> jobSkills;

    public Job(String jobName, String jobDesc, Company company) {
        this.jobName = jobName;
        this.jobDesc = jobDesc;
        this.company = company;
    }
}
