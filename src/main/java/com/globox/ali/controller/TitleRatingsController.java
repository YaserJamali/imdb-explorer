package com.globox.ali.controller;


import com.globox.ali.dto.TitleRatingsDto;
import com.globox.ali.entities.TitleRatingsEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/title-ratings")
@Tag(name = "TitleRatingsController", description = "APIs related to Title Ratings")
public class TitleRatingsController extends BaseAbstractController<TitleRatingsEntity, TitleRatingsDto, String> {
}