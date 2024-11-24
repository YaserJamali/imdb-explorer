package com.globox.ali.service;

import com.globox.ali.dto.VWSameDirectorWriterDto;
import com.globox.ali.entities.VWSameDirectorWriterEntity;
import com.globox.ali.exceptions.ThereIsNoAliveSameDirectorAndWriterOnMovieException;
import com.globox.ali.repository.VWSameDirectorWriterImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VWSameDirectorWriterService
        extends BaseImmutableAbstractService<VWSameDirectorWriterEntity, VWSameDirectorWriterDto, String, VWSameDirectorWriterImpl> {

    @Cacheable(value = "moviesByGenre")
    public List<VWSameDirectorWriterDto> findAliveDirectorAndWriterForSameMovie(Integer pageNumber, Integer pageSize) throws ThereIsNoAliveSameDirectorAndWriterOnMovieException {
        List<VWSameDirectorWriterEntity> entityList = repository.findAllByDeathYearIsNull(
                Pageable.ofSize(pageSize).withPage(pageNumber));
        if (entityList.isEmpty()){
            throw new ThereIsNoAliveSameDirectorAndWriterOnMovieException();
        }
        return converter.convertEntity(entityList);
    }
}