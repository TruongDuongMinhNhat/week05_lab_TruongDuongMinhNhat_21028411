package dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.repositories;

import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models.Company;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findAllByCompany(Company company);
}
