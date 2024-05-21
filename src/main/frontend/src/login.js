import React, { useState,useEffect } from 'react';

function Login() {
    const [id, setId] = useState("");
    const [pw, setPw] = useState("");
    return (
        <>
        <div>
            <input placeholder="아이디를 입력해주세요" value={id} onChange={(e) => setId(e.target.value)} />
            <input type="password" placeholder="비밀번호를 입력해주세요." value={pw} onChange={(e) => setPw(e.target.value)} />
        </div>
        </>
    );
}

export default Login;