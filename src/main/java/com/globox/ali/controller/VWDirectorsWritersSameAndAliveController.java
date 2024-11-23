package com.globox.ali.controller;


import com.globox.ali.dto.VWDirectorsWritersSameAndAliveDto;
import com.globox.ali.entities.VWDirectorsWritersSameAndAliveEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/same-director-and-writer-alive")
public class VWDirectorsWritersSameAndAliveController
        extends BaseAbstractViewsController<VWDirectorsWritersSameAndAliveEntity, VWDirectorsWritersSameAndAliveDto, String> {
}
