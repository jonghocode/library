package com.school.library.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int libraryId;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    private LocalDateTime time;
}