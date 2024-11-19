package com.globox.ali.controller;


import com.globox.ali.entities.Library;
import com.globox.ali.dto.LibraryDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lib")
public class LibraryController extends BaseAbstractController<Library, LibraryDto> {

}
