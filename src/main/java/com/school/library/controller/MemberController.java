package com.school.library.controller;

import com.school.library.dto.LoginDto;
import com.school.library.dto.MemberDto;
import com.school.library.dto.ResponseDto;
import com.school.library.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private MemberService memberService;

    /**
     * 아이디 중복 체크
     * @param id
     * @return
     */
    @GetMapping("/check/{id}")
    public ResponseDto idCheck(@PathVariable(name = "id") String id) {
        return memberService.checkId(id);
    }

    /**
     * 회원 가입
     * @param memberDto
     */
    @PostMapping("/member")
    public void memberAdd(MemberDto memberDto) {
        memberService.addMember(memberDto);
    }


    /**
     * 회원 조회
     * @param id
     * @return
     */
    public MemberDto memberFind(String id) {
        return memberService.findMember(id);
    }

    /**
     * 로그인
     * @param loginDto
     * @return
     */
    public ResponseDto login(LoginDto loginDto) {
        return memberService.login(loginDto);
    }
}
