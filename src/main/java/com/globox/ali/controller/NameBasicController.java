package com.globox.ali.controller;


import com.globox.ali.dto.NameBasicsDto;
import com.globox.ali.entities.NameBasicsEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/names-basics")
@Tag(name = "NameBasicController", description = "APIs related to Name Basics")
public class NameBasicController extends BaseAbstractController<NameBasicsEntity, NameBasicsDto, String> {
}