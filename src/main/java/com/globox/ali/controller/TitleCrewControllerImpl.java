package com.globox.ali.controller;

import com.globox.ali.dto.TitleBasicsDto;
import com.globox.ali.dto.TitleCrewDto;
import com.globox.ali.entities.TitleBasicsEntity;
import com.globox.ali.entities.TitleCrewEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/title-crew")
public class TitleCrewControllerImpl  extends BaseAbstractController<TitleCrewEntity, TitleCrewDto>{

    @GetMapping
    public String test() {
        return "hello";
    }
}
