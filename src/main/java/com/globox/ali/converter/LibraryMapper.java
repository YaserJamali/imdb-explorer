package com.globox.ali.converter;

import com.globox.ali.entities.Library;
import com.globox.ali.dto.LibraryDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface LibraryMapper extends BaseConverter<LibraryDto, Library> {

}
