package com.school.library.controller;

import com.school.library.dto.SeetDto;
import com.school.library.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class LibraryController {

    private final LibraryService libraryService;

    @GetMapping("/seet")
    public List<SeetDto> seetList() {
        return libraryService.findAllSeet();
    }
}
