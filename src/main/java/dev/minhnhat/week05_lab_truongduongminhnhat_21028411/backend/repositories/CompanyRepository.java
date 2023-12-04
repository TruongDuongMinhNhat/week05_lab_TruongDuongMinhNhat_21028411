package dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.repositories;

import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findCompanyByEmail(String email);
    Optional<Company> findCompanyByEmailAndPassword(String email, String password);
}
