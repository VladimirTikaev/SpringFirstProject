package com.vladimirt.core.controllers;

import com.vladimirt.core.dto.EnWordDTO;
import com.vladimirt.core.mappers.IEnWordMapper;
import com.vladimirt.core.model.EnWord;
import com.vladimirt.core.services.IEnWordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EnWordController {

    private final IEnWordService enWordService;
    private final IEnWordMapper enWordMapper;

    @GetMapping("/enwords/{id}")
    public EnWordDTO sayHello(@PathVariable Long id){
        EnWord enWord = enWordService.getEnWord(id);
        return enWordMapper.toDTO(enWord);
    }
}
