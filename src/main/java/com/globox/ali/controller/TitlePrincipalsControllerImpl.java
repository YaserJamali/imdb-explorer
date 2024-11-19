package com.globox.ali.controller;//package com.globox.ali.imdb.explorer.controller;

import com.globox.ali.dto.TitlePrincipalsDto;
import com.globox.ali.entities.TitlePrincipalsEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/title-principals")
public class TitlePrincipalsControllerImpl extends BaseAbstractController<TitlePrincipalsEntity, TitlePrincipalsDto> {

//    @GetMapping
//    public String test() {
//        return "hello";
//    }
}
