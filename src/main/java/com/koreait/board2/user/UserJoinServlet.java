package com.koreait.board2.user;

import com.koreait.board2.model.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/join")
public class UserJoinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String path = "/WEB-INF/view/user/join.jsp";
        req.getRequestDispatcher(path).forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        UserVO vo = new UserVO();
        vo.setUid(req.getParameter("uid"));
        vo.setUpw(req.getParameter("upw"));
        vo.setNm(req.getParameter("nm"));
        vo.setGender(Integer.parseInt(req.getParameter("gender")));
        int result = UserDAO.join(vo);
        switch (result){
            case 0:
                req.setAttribute("err","회원가입 실패");
                doGet(req, res);
                break;
            case 1:
                res.sendRedirect("/user/login");
                break;
        }

    }
}
