package com.globox.ali.controller;

import com.globox.ali.dto.TitleBasicsDto;
import com.globox.ali.entities.TitleBasicsEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/title-basics")
@Tag(name = "TitleBasicsController", description = "APIs related to Title Basics")
public class TitleBasicsControllerImpl extends BaseAbstractController<TitleBasicsEntity, TitleBasicsDto, String> {
}