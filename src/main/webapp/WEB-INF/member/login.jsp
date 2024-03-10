<%--
  Created by IntelliJ IDEA.
  User: yunhosang
  Date: 3/10/24
  Time: 4:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <c:if test="${param.result == 'error'}">
        <span style="color: red"><h1>로그인 에러입니다. 다시 시도하세요.</h1></span>
    </c:if>
<form action="/login" method="post">
    <h2>로그인</h2>
    <label>아이디
        <input type="text" name="mid"><br>
    </label>
    <label>비밀번호
        <input type="password" name="mpw"><br>
    </label>
    <button type="submit">로그인</button>
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
    h2 {
        color: dodgerblue;
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
    input[type=text], input[type=password] {
        width: 100%;
        margin-bottom: 10px;
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
    label{
        color: #666;
    }
</style>