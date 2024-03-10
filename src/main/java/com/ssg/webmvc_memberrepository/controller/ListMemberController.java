package com.ssg.webmvc_memberrepository.controller;

import com.ssg.webmvc_memberrepository.dto.MemberDTO;
import com.ssg.webmvc_memberrepository.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "memberController", urlPatterns = "/member/listMembers.do")
public class ListMemberController extends HttpServlet {
    private MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<MemberDTO> dtoList = memberService.listAllMembers();
            req.setAttribute("dtoList", dtoList);

            req.getRequestDispatcher("/WEB-INF/member/list.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
