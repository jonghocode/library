import axios from "axios";

const server = "http://localhost:8080"
// 아이디 중복 체크
export async function idCheck(id) {
    await axios.get(server + "/check/${id}")
    .then((res) => {
        console.log(res.data)
    })
    .catch((error) => {
        console.log(error)
    })
}

// 회원 가입
export async function memberCreate(id, pw, nick) {
    await axios.post(server + "/member", {
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

// 로그인
export async function loginCheck(id, pw) {
    await axios.post(server + "/login", {
        id : id,
        pw : pw
    })
    .then((res) => {
        console.log(res.data)
    })
    .catch((error) => {
        console.log(error)
    })
}