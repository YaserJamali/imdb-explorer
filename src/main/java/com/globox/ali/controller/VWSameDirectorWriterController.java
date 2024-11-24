package com.globox.ali.controller;


import com.globox.ali.dto.VWSameDirectorWriterDto;
import com.globox.ali.entities.VWSameDirectorWriterEntity;
import com.globox.ali.service.VWSameDirectorWriterService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/same-director-and-writer-alive-without-birthday")
@Tag(name = "VWDirectorsWritersSameAndAliveWithNoPresentBirthDayController", description = "APIs related to Directors and Writers who are the Same and Alive without Present Birthday")
public class VWSameDirectorWriterController
        extends BaseAbstractViewsController<VWSameDirectorWriterEntity, VWSameDirectorWriterDto, VWSameDirectorWriterService, String> {
}

