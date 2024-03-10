package com.ssg.webmvc_memberrepository.controller;

import com.ssg.webmvc_memberrepository.dto.MemberDTO;
import com.ssg.webmvc_memberrepository.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addMemberController", urlPatterns = "/member/addMember.do")
public class AddMemberController extends HttpServlet {
    private MemberService memberService = MemberService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/member/memberForm.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberDTO dto = MemberDTO.builder()
                .mid(req.getParameter("mid"))
                .mpw(req.getParameter("mpw"))
                .mname(req.getParameter("mname"))
                .memail(req.getParameter("memail"))
                .build();
        try {
            memberService.insertMember(dto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
            resp.sendRedirect("/member/listMembers.do");
    }
}
