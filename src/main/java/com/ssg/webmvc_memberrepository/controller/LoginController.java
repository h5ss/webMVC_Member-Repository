package com.ssg.webmvc_memberrepository.controller;

import com.ssg.webmvc_memberrepository.dto.MemberDTO;
import com.ssg.webmvc_memberrepository.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/member/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            MemberDTO dto = MemberService.INSTANCE.login(req.getParameter("mid"),req.getParameter("mpw"));
            HttpSession session = req.getSession();
            session.setAttribute("loginInfo",dto);
            resp.sendRedirect("/member/listMembers.do");
        } catch (Exception e) {
            resp.sendRedirect("/login?result=error");
        }
    }
}
