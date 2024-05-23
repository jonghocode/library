package com.school.library.controller;

import com.school.library.dto.LoginDto;
import com.school.library.dto.MemberDto;
import com.school.library.dto.ResponseDto;
import com.school.library.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class MemberController {

    private final MemberService memberService;

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
    public void memberAdd(@RequestBody MemberDto memberDto) {
        memberService.addMember(memberDto);
    }


    /**
     * 회원 조회
     * @param id
     * @return
     */
    @GetMapping("/member")
    public MemberDto memberFind(String id) {
        return memberService.findMember(id);
    }

    /**
     * 로그인
     * @param loginDto
     * @return
     */
    @PostMapping("/login")
    public ResponseDto login(@RequestBody LoginDto loginDto) {
        return memberService.login(loginDto);
    }
}
