package com.globox.ali.controller;


import com.globox.ali.dto.VMDirectorsWritersSameAndAliveDto;
import com.globox.ali.entities.VMDirectorsWritersSameAndAliveEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/same-director-and-writer-alive")
public class VMDirectorsWritersSameAndAliveController
        extends BaseAbstractController<VMDirectorsWritersSameAndAliveEntity, VMDirectorsWritersSameAndAliveDto, String> {
}
