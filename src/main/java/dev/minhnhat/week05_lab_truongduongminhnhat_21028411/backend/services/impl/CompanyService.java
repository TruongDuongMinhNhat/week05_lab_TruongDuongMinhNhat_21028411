package dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.services.impl;

import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models.Company;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.repositories.CompanyRepository;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.services.IServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements IServices<Company, Long> {
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public boolean save(Company company) {
        try {
            companyRepository.save(company);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            companyRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Company company) {
        try {
            companyRepository.delete(company);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }
    public Optional<Company> findByEmail(String email) {
        return companyRepository.findCompanyByEmail(email);
    }

    public Optional<Company> checkLogin(String email, String password) {
        return companyRepository.findCompanyByEmailAndPassword(email, password);
    }
}
