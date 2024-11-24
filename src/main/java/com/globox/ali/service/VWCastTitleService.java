package com.globox.ali.service;

import com.globox.ali.dto.VWCastTitleDto;
import com.globox.ali.entities.VWCastTitleEntity;
import com.globox.ali.exceptions.NoMovieExistsForTheesActors;
import com.globox.ali.exceptions.NoTitleHasBeenRegisteredException;
import com.globox.ali.repository.VWCastTitleRepositoryImplI;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VWCastTitleService
        extends BaseImmutableAbstractService<VWCastTitleEntity, VWCastTitleDto, String, VWCastTitleRepositoryImplI> {

    @Cacheable(value = "moviesByGenre")
    public List<VWCastTitleDto> findAllByCategoryAndPrimaryName
            (String firstPrimaryName, String secondPrimaryName) throws NoTitleHasBeenRegisteredException, NoMovieExistsForTheesActors {
        List<VWCastTitleDto> listOfFirstInput = findByPrimaryName(firstPrimaryName);
        if (listOfFirstInput.isEmpty()) {
            //TODO  DO SOMTENIGS
            throw new NoTitleHasBeenRegisteredException();
        }
        List<VWCastTitleDto> listOfSecondInput = findByPrimaryName(secondPrimaryName);
        if (listOfSecondInput.isEmpty()) {
            //TODO  DO SOMTENIGS
            throw new NoTitleHasBeenRegisteredException();
        }
        List<VWCastTitleDto> commonMoviesForActors = getCommonMoviesForActors(listOfFirstInput, listOfSecondInput);
        if (commonMoviesForActors.isEmpty()) {
            //TODO  DO SOMTENIGS
            throw new NoMovieExistsForTheesActors();
        }
        return commonMoviesForActors;
    }


    private List<VWCastTitleDto> findByPrimaryName(String primaryName) {
        return converter.convertEntity(repository.findAllByPrimaryNameLike(primaryName));

    }


    private List<VWCastTitleDto> getCommonMoviesForActors(List<VWCastTitleDto> firstList, List<VWCastTitleDto> secondList) {
        Set<String> movieSet = new HashSet<>();
        for (VWCastTitleDto dto : firstList) {
            movieSet.add(dto.getTconst());
        }

        return secondList.stream()
                .filter(dto -> movieSet.contains(dto.getTconst()))
                .collect(Collectors.toList());
    }
}