package com.globox.ali.controller;


import com.globox.ali.dto.VWTitleWithTwoOrMoreSameCategoryDto;
import com.globox.ali.entities.VWTitleWithTwoOrMoreSameCategoryEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-with-two-same-category")
public class VWTitleWithTwoOrMoreSameCategoryController
        extends BaseAbstractController<VWTitleWithTwoOrMoreSameCategoryEntity, VWTitleWithTwoOrMoreSameCategoryDto, String> {
}
