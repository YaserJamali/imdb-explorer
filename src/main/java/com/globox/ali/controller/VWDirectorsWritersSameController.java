package com.globox.ali.controller;


import com.globox.ali.dto.VWDirectorsWritersSameDto;
import com.globox.ali.entities.VWDirectorsWritersSameEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/same-director-and-writer")
public class VWDirectorsWritersSameController
        extends BaseAbstractViewsController<VWDirectorsWritersSameEntity, VWDirectorsWritersSameDto, String> {
}
