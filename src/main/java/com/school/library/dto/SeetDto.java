package com.school.library.dto;

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

}
