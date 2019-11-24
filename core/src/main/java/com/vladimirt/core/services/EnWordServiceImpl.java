package com.vladimirt.core.services;

import com.vladimirt.core.model.EnWord;
import com.vladimirt.core.repositories.IEnWordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnWordServiceImpl implements IEnWordService {

    private final IEnWordRepository enWordRepository;

    @Override
    public EnWord getEnWord(Long id) {
        return enWordRepository.getById(id);
    }
}
