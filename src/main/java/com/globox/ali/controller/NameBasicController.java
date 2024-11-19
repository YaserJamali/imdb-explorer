package com.globox.ali.controller;


import com.globox.ali.dto.NameBasicsDto;
import com.globox.ali.entities.NameBasicsEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/names-basics")
public class NameBasicController extends
        BaseAbstractController<NameBasicsEntity, NameBasicsDto, String> {
}
