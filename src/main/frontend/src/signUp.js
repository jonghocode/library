import React, { useState,useEffect } from 'react';
import {idCheck, memberCreate} from "./api";

function SignUp() {

    const [id, setId] = useState("");
    const [pw, setPw] = useState("");
    const [nick, setNick] = useState("");

    function check() {
        idCheck(id);
    }

    function create() {
        memberCreate(id, pw, nick);
    }

    return (
        <>
            <div>
                아이디<input placeholder="아이디를 입력해주세요" value={id} onChange={(e) => setId(e.target.value)} />
                <button onClick={check}>아이디 중복체크</button><br/>
                비밀번호<input type="password" placeholder="비밀번호를 입력해주세요." value={pw} onChange={(e) => setPw(e.target.value)} /><br/>
                닉네임<input placeholder="닉네임을 입력해주세요" value={nick} onChange={(e) => setNick(e.target.value)} /><br/>
                <button onClick={create}>회원 가입</button>
            </div>
        </>
    );
}

export default SignUp;