package com.globox.ali.controller;

import com.globox.ali.dto.TitleCrewDto;
import com.globox.ali.entities.TitleCrewEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/title-crew")
@Tag(name = "TitleCrewController", description = "APIs related to Title Crew")
public class TitleCrewControllerImpl extends BaseAbstractController<TitleCrewEntity, TitleCrewDto, Long> {
}
