<%--
  Created by IntelliJ IDEA.
  User: yunhosang
  Date: 3/8/24
  Time: 5:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up Page</title>
</head>
<body>
<form action="/member/addMember.do" method="post">
    <h1>회원 가입</h1>
    <div>
        <label>아이디</label><input type="text" name="mid">
        <label>비밀번호</label><input type="password" name="mpw">
        <label>이름</label><input type="text" name="mname">
        <label>이메일</label><input type="text" name="memail">
    </div>
    <div>
        <button type="submit">가입하기</button>
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
    input[type=text], input[type=password] {
        width: 100%;
        padding: 8px;
        border: 1px solid #ddd;
        border-radius: 4px;
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