package com.globox.ali.controller;


import com.globox.ali.dto.VWViewDirectorsWritersSameAndAliveWithNoPresentBirthDayDto;
import com.globox.ali.entities.VWViewDirectorsWritersSameAndAliveWithNoPresentBirthDayEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/same-director-and-writer-alive-without-birthday")
public class VWViewDirectorsWritersSameAndAliveWithNoPresentBirthDayController
        extends BaseAbstractController<VWViewDirectorsWritersSameAndAliveWithNoPresentBirthDayEntity, VWViewDirectorsWritersSameAndAliveWithNoPresentBirthDayDto, String> {
}
