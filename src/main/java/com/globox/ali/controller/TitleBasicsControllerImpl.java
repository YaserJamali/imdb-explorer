package com.globox.ali.controller;

import com.globox.ali.dto.TitleBasicsDto;
import com.globox.ali.entities.TitleBasicsEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/title-basics")
public class TitleBasicsControllerImpl extends BaseAbstractController<TitleBasicsEntity, TitleBasicsDto, String> {

}
