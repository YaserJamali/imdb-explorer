package com.globox.ali.controller;


import com.globox.ali.dto.VWBestMoviesPerYearBasedOnImdbRankingDto;
import com.globox.ali.entities.VWBestMoviesPerYearBasedOnImdbRankingEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/best-movies-of-the-year")
public class VWBestMoviesPerYearBasedOnImdbRankingController
        extends BaseAbstractViewsController<VWBestMoviesPerYearBasedOnImdbRankingEntity, VWBestMoviesPerYearBasedOnImdbRankingDto, String> {
}
