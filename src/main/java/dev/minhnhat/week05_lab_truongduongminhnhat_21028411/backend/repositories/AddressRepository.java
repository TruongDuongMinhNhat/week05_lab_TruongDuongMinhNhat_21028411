package dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.repositories;

import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
