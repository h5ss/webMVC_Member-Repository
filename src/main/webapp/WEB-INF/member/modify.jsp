<%--
  Created by IntelliJ IDEA.
  User: yunhosang
  Date: 3/9/24
  Time: 8:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modify Page</title>
</head>
<body>
    <h1>회원 정보 수정</h1>
    <form action="/member/modMember.do" method="post">
        <div>
            <label>아이디(아이디는 변경 불가)</label>
            <input type="text" name="mid" value="${dto.mid}" readonly>
        </div>
        <div>
            <label>비밀번호</label>
            <input type="text" name="mpw" value="${dto.mpw}">
        </div>
        <div>
            <label>이름</label>
            <input type="text" name="mname" value="${dto.mname}">
        </div>
        <div>
            <label>이메일</label>
            <input type="text" name="memail" value="${dto.memail}">
        </div>
        <div>
            <button type="submit">수정하기</button>
            <button type="reset">다시입력</button>
        </div>
    </form>

</body>
</html>
<style>
    body {
        font-family: 'Arial', sans-serif;
        margin: 0;
        padding: 0;
        background: #f4f4f4;
    }
    h1 {
        color: #333;
        text-align: center;
    }
    form {
        max-width: 300px;
        margin: 20px auto;
        padding: 20px;
        background: #fff;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    div {
        margin-bottom: 10px;
    }
    label {
        display: block;
        margin-bottom: 5px;
        color: #666;
    }
    input[type=text] {
        width: 100%;
        padding: 8px;
        border: 1px solid #ddd;
        border-radius: 4px;
    }
    input[type=date]{
        margin-top: 10px;
    }
    button {
        width: 100%;
        margin-bottom: 10px;
        padding: 10px;
        border: none;
        border-radius: 4px;
        background: dodgerblue;
        color: white;
        cursor: pointer;
    }
    button:hover {
        background: royalblue;
    }
</style>