package com.koreait.board2.user;

import com.koreait.board2.model.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String jsp = "/WEB-INF/view/user/login.jsp";
        req.getRequestDispatcher(jsp).forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        UserVO vo = new UserVO();
        vo.setUid(req.getParameter("uid"));
        vo.setUpw(req.getParameter("upw"));
        int result = UserDAO.login(vo);
        if(result == 1){
            vo.setUpw(null);
            HttpSession session = req.getSession();
            session.setAttribute("loginUser",vo);
            res.sendRedirect("/board/list");
            return;
        }
        String err = null;
        switch (result){
            case 0 :
                err="로그인 실패";
                break;
            case 2:
                err = "비밀번호를 확인하세요";
                break;
            case 3:
                err="아이디를 확인하세요";
                break;
        }
        req.setAttribute("err", err);
        doGet(req, res);
    }
}
