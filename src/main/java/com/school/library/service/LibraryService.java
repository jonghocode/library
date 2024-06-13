package com.school.library.service;

import com.school.library.domain.Library;
import com.school.library.domain.Member;
import com.school.library.dto.ResponseDto;
import com.school.library.dto.SeetDto;
import com.school.library.repository.LibraryRepository;
import com.school.library.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LibraryService {

    private final LibraryRepository libraryRepository;
    private final MemberRepository memberRepository;

    public List<SeetDto> findAllSeet() {
        return libraryRepository.findAll().stream()
                .map(seet -> {
                    String memberId = seet.getMember() != null ? seet.getMember().getMemberId() : null;
                    return
                    SeetDto.builder().id(seet.getLibraryId())
                        .time(seet.getTime()).
                            memberId(memberId).build();
                })
                .collect(Collectors.toList());
    }

    public ResponseDto addSeet(SeetDto seetDto) {
        Library library = seetDto.toEntity(seetDto);
        Member member = memberRepository.findById(seetDto.getMemberId()).orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
        library.setMember(member);
        libraryRepository.save(library);
        return ResponseDto.builder().msg("성공").status(HttpStatus.OK).build();
    }
}
