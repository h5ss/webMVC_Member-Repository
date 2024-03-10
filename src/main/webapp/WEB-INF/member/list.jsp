<%--
  Created by IntelliJ IDEA.
  User: yunhosang
  Date: 3/8/24
  Time: 5:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Member List</title>
</head>
<body>
<form action="/member/listMembers.do" method="get">
    <h1>회원정보</h1>
    <table >
        <tr>
            <th>아이디</th>
            <th>비밀번호</th>
            <th>이름</th>
            <th>이메일</th>
            <th>가입일</th>
            <th>수정</th>
            <th>삭제</th>
        </tr>
        <c:forEach var="dto" items="${dtoList}">
            <tr align="center">
                <td>${dto.mid}</td>
                <td>${dto.mpw}</td>
                <td>${dto.mname}</td>
                <td>${dto.memail}</td>
                <td>${dto.joindate}</td>
                <td><a href="/member/modMember.do?mid=${dto.mid}">수정</a></td>
                <td><a href="/member/delMember.do?mid=${dto.mid}">삭제</a></td>
            </tr>
        </c:forEach>
    </table>
    <div>
        <br>
        <span><a href="/member/addMember.do">회원 가입하기</a></span>
    </div>
</form>

</body>
</html>

<style>
    h1 {
        text-align: center;
        color: dodgerblue;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 40px;
        font-family: 'Noto Sans KR', sans-serif;
    }
    th {
        background-color: dodgerblue;
        color: white;
        padding: 15px;
    }
    td {
        text-align: center;
        padding: 8px;
        border-bottom: 1px solid #ddd;
        color: #666;
    }
    tr:hover {
        background-color: #f5f5f5;
    }
    a {
        text-decoration: none;
        color: #333;
    }
    a:hover {
        font-weight: bold;
        color: dodgerblue;
    }
    span {
        display: block;
        text-align: center;
    }
    span a {
        display: inline-block;
        margin-top: 20px;
        padding: 10px 15px;
        background-color: dodgerblue;
        color: white;
        border-radius: 5px;
    }
    span a:hover {
        background-color: royalblue;
    }
</style>