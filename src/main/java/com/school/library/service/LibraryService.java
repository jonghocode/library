package com.school.library.service;

import com.school.library.dto.SeetDto;
import com.school.library.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LibraryService {

    private final LibraryRepository libraryRepository;

    public List<SeetDto> findAllSeet() {
        return libraryRepository.findAll().stream()
                .map(seet -> SeetDto.builder().id(seet.getLibraryId())
                        .time(seet.getTime()).memberId(seet.getMember().getMemberId()).build())
                .collect(Collectors.toList());
    }
}
