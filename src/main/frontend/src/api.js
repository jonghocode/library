import axios from "axios";


// 아이디 중복 체크
export async function idCheck(id) {
    await axios.get("/check/${id}")
    .then((res) => {
        console.log(res.data)
    })
    .catch((error) => {
        console.log(error)
    })
}

// 회원 가입
export async function memberCreate(id, pw, nick) {
    await axios.post("/member", {
        id : id,
        pw : pw,
        nick : nick
    })
    .then((res) => {
        console.log(res.data)
    })
    .catch((error) => {
        console.log(error)
    })
}