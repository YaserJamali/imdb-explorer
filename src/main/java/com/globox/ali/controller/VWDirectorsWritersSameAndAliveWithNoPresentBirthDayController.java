package com.globox.ali.controller;


import com.globox.ali.dto.VWDirectorsWritersSameAndAliveWithNoPresentBirthDayDto;
import com.globox.ali.entities.VWDirectorsWritersSameAndAliveWithNoPresentBirthDayEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/same-director-and-writer-alive-without-birthday")
public class VWDirectorsWritersSameAndAliveWithNoPresentBirthDayController
        extends BaseAbstractViewsController<VWDirectorsWritersSameAndAliveWithNoPresentBirthDayEntity, VWDirectorsWritersSameAndAliveWithNoPresentBirthDayDto, String> {
}
