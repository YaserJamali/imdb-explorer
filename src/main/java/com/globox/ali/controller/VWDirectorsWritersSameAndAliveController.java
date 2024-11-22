package com.globox.ali.controller;


import com.globox.ali.dto.VWDirectorsWritersSameAndAliveDto;
import com.globox.ali.entities.VWMDirectorsWritersSameAndAliveEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/same-director-and-writer-alive")
public class VWDirectorsWritersSameAndAliveController
        extends BaseAbstractController<VWMDirectorsWritersSameAndAliveEntity, VWDirectorsWritersSameAndAliveDto, String> {
}
