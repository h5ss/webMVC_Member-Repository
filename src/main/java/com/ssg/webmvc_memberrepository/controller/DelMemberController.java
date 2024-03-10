package com.ssg.webmvc_memberrepository.controller;

import com.ssg.webmvc_memberrepository.dto.MemberDTO;
import com.ssg.webmvc_memberrepository.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "delMemberController", urlPatterns = "/member/delMember.do")
public class DelMemberController extends HttpServlet {
    private MemberService memberService = MemberService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mid = req.getParameter("mid");
        try {
            memberService.deleteMember(mid);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("/member/listMembers.do");
    }
}
