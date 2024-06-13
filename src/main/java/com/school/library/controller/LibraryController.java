package com.school.library.controller;

import com.school.library.dto.ResponseDto;
import com.school.library.dto.SeetDto;
import com.school.library.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class LibraryController {

    private final LibraryService libraryService;

    /**
     * 자리 조회
     */
    @GetMapping("/seet")
    public List<SeetDto> seetList() {
        return libraryService.findAllSeet();
    }

    /**
     * 자리 예약
     */
    @PostMapping("/seet")
    public ResponseDto seetAdd(@RequestBody SeetDto seetDto) {
        return libraryService.addSeet(seetDto);
    }
}
