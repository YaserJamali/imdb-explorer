package com.globox.ali.controller;//package com.globox.ali.imdb.explorer.controller;

import com.globox.ali.dto.TitlePrincipalsDto;
import com.globox.ali.entities.TitlePrincipalsEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/title-principals")
@Tag(name = "TitlePrincipalsController", description = "APIs related to Title Principals")
public class TitlePrincipalsControllerImpl extends BaseAbstractController<TitlePrincipalsEntity, TitlePrincipalsDto, Long> {
}
