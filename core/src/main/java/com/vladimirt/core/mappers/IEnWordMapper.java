package com.vladimirt.core.mappers;

import com.vladimirt.core.dto.EnWordDTO;
import com.vladimirt.core.model.EnWord;
import org.mapstruct.Mapper;

@Mapper
public interface IEnWordMapper {

    EnWordDTO toDTO(EnWord enWord);
}
