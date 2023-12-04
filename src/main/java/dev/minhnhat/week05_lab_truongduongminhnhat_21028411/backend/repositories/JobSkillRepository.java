package dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.repositories;

import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models.Job;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models.JobSkill;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models.JobSkillID;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobSkillRepository extends JpaRepository<JobSkill, JobSkillID> {
    Optional<JobSkill> findJobSkillByJobSkillID_JobAndJobSkillID_Skill(Job job, Skill skill);
}
