package com.ssg.webmvc_memberrepository.controller;

import com.ssg.webmvc_memberrepository.dto.MemberDTO;
import com.ssg.webmvc_memberrepository.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "modeMemberController", urlPatterns = "/member/modMember.do")
public class ModMemberController extends HttpServlet {
    private MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String mid = req.getParameter("mid");
            MemberDTO dto = memberService.getMember(mid);
            req.setAttribute("dto", dto);
            req.getRequestDispatcher("/WEB-INF/member/modify.jsp").forward(req, resp);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
            memberService.modifyMember(dto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("/member/listMembers.do");
    }
}
