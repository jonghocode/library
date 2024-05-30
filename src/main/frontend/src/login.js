import React, { useState,useEffect } from 'react';
import {loginCheck} from "./api";
import { Link } from "react-router-dom";

function Login() {
    const [id, setId] = useState("");
    const [pw, setPw] = useState("");

    function goLogin() {
        loginCheck(id, pw);
    }



    return (
        <>
        <div>
            <input placeholder="아이디를 입력해주세요" value={id} onChange={(e) => setId(e.target.value)} />
            <input type="password" placeholder="비밀번호를 입력해주세요." value={pw} onChange={(e) => setPw(e.target.value)} />
            <button onClick={goLogin}>로그인</button>
            <Link to ={'/signUp'}>회원가입</Link>
        </div>
        </>
    );
}

export default Login;