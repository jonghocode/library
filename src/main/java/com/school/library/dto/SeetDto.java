package com.school.library.dto;

import com.school.library.domain.Library;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class SeetDto {

    private Integer id;
    private LocalDateTime time;
    private String memberId;

    public Library toEntity(SeetDto seetDto) {
        Library library = new Library();
        library.setLibraryId(seetDto.getId());
        library.setTime(seetDto.getTime());
        return library;
    }

}
