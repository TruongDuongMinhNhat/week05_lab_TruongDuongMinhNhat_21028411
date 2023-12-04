package dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.services.impl;

import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models.Address;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.repositories.AddressRepository;
import dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.services.IServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements IServices<Address, Long> {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public boolean save(Address address) {
        try {
            addressRepository.save(address);
            return true;
        } catch (Exception exception){
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            addressRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Address address) {
        try {
            addressRepository.delete(address);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<Address> findById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }
}
