package com.globox.ali.service;

import com.globox.ali.dto.TitleBasicsDto;
import com.globox.ali.entities.TitleBasicsEntity;
import com.globox.ali.repository.TitleBasicsRepositoryImplI;
import org.springframework.stereotype.Service;

@Service
public class TitleBasicsService
        extends BaseAbstractService<TitleBasicsEntity, TitleBasicsDto, String, TitleBasicsRepositoryImplI> {
}
//        {
//    public List<TitleBasicsEntity> getTitlesWithSameDirectorAndWriterAlive() {
//        return repository.findAll().stream()
//                .filter(title -> title.getCrew().stream()
//                        .anyMatch(crew -> crew.getDirector().equals(crew.getWriter()) && crew.getDirector().getDeathYear() == null))
//                .collect(Collectors.toList());
//    }
//
//
//    public List<TitleBasicsEntity> getTitlesWithTwoActors(String actor1Id, String actor2Id) {
//        return repository.findAll().stream()
//                .filter(title -> title.getPrincipals().stream()
//                        .anyMatch(principal -> principal.getActor().getNconst().equals(actor1Id)) &&
//                        title.getPrincipals().stream()
//                                .anyMatch(principal -> principal.getActor().getNconst().equals(actor2Id)))
//                .collect(Collectors.toList());
//    }
//
//    public List<TitleBasicsEntity> getBestTitlesByGenre(String genre) {
//        return repository.findAll().stream()
//                .filter(title -> title.getGenres().contains(genre))
//                .collect(Collectors.groupingBy(TitleBasicsEntity::getStartYear))
//                .values().stream()
//                .map(titleBasicsEntities -> titleBasicsEntities.stream()
//                        .max(Comparator.comparingDouble(title -> title.getRatings().stream()
//                                .mapToDouble(TitleRatingsEntity::getAverageRating)
//                                .average().orElse(0)))
//                        .orElse(null))
//                .collect(Collectors.toList());
//    }
//}