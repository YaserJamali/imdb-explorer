package com.globox.ali.controller;


import com.globox.ali.dto.VWCastTitleDto;
import com.globox.ali.entities.VWCastTitleEntity;
import com.globox.ali.service.VWCastTitleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/titles-of-casts")
@Tag(name = "VWTitleWithTwoOrMoreSameActorsController", description = "APIs related to Movies with Two or More Same Actors")
public class VWCastTitleController
        extends BaseAbstractViewsController<VWCastTitleEntity, VWCastTitleDto, VWCastTitleService, String> {

}