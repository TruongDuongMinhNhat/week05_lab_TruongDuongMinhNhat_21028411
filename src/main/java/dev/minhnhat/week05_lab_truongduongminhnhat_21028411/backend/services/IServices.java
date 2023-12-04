package dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.services;

import java.util.List;
import java.util.Optional;

public interface IServices<T, ID>{
    boolean save(T t);
    boolean deleteById(ID id);
    boolean delete(T t);
    Optional<T> findById(ID id);
    List<T> findAll();
}
