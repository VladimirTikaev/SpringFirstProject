package com.vladimirt.core.repositories;

import com.vladimirt.core.model.EnWord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnWordRepository extends CrudRepository<EnWord, Long> {
    EnWord getById(Long id);
}
