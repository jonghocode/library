package com.school.library.service;

import com.school.library.domain.Member;
import com.school.library.dto.LoginDto;
import com.school.library.dto.MemberDto;
import com.school.library.dto.ResponseDto;
import com.school.library.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private MemberRepository memberRepository;

    /**
     * 아이디 중복 체크
     * @param id
     * @return
     */
    public ResponseDto checkId(String id) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member != null) {
            return ResponseDto.builder().msg("NO").status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseDto.builder().msg("OK").status(HttpStatus.OK).build();
    }

    /**
     * 회원 가입
     * @param memberDto
     */
    public void addMember(MemberDto memberDto) {
        Member member = new Member(memberDto.getId(), memberDto.getPw(), memberDto.getNick());
        memberRepository.save(member);
    }


    /**
     * 회원 조회
     * @param id
     */
    public MemberDto findMember(String id) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member != null) {
            return MemberDto.builder().id(member.getMemberId()).pw(member.getPw()).nick(member.getNick()).build();
        }
        return MemberDto.builder().build();
    }


    /**
     * 로그인
     * @param loginDto
     * @return
     */
    public ResponseDto login(LoginDto loginDto) {
        Member member = memberRepository.findById(loginDto.getId()).orElse(null);
        if (member == null) {
            return ResponseDto.builder().msg("아이디가 존재하지 않습니다.").status(HttpStatus.BAD_REQUEST).build();
        }
        if (!member.pwCheck(loginDto.getPw())) {
            return ResponseDto.builder().msg("비밀번호가 틀렸습니다.").status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseDto.builder().msg("로그인 성공").status(HttpStatus.OK).build();
    }
}
