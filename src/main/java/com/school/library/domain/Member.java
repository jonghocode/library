package com.school.library.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    private String memberId;
    private String pw;
    private String nick;

    public boolean pwCheck(String pw) {
        if (this.pw.equals(pw)) {
            return true;
        } else {
            return false;
        }
    }
}