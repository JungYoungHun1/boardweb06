package com.koreait.board2.board;

import com.koreait.board2.model.BoardVO;
import com.koreait.board2.model.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/board/mod")
public class BoardModServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserVO loginUser = (UserVO)session.getAttribute("loginUser");
        if(loginUser == null){
            res.sendRedirect("/user/login");
            return;
        }
        if(req.getAttribute("detail")==null) {
            BoardVO vo = new BoardVO();
            vo.setIboard(Integer.parseInt(req.getParameter("iboard")));
            BoardVO result = BoardDAO.detailboard(vo);
            req.setAttribute("detail", result);
        }
        String path = "/WEB-INF/view/board/mod.jsp";
        req.getRequestDispatcher(path).forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserVO loginUser = (UserVO) session.getAttribute("loginUser");
        BoardVO vo = new BoardVO();
        vo.setIboard(Integer.parseInt(req.getParameter("iboard")));
        vo.setTitle(req.getParameter("title"));
        vo.setCtnt(req.getParameter("ctnt"));
        vo.setWriter(loginUser.getIuser());
        int result = BoardDAO.modboard(vo);
        switch (result){
            case 1:
                res.sendRedirect("/board/detail?iboard="+vo.getIboard());
                break;
            case 0 :
                req.setAttribute("detail",vo);
                req.setAttribute("err","수정 실패");
                doGet(req, res);
        }
    }
}
