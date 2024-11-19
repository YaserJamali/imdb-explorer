package com.globox.ali.controller;


import com.globox.ali.dto.TitleRatingsDto;
import com.globox.ali.entities.TitleRatingsEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/title-ratings")
public class TitleRatingsController extends BaseAbstractController<TitleRatingsEntity, TitleRatingsDto, String> {
}
