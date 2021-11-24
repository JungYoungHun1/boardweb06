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

@WebServlet("/board/write")
public class BoardWriteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserVO loginUser = (UserVO)session.getAttribute("loginUser");
        if(loginUser == null){
            res.sendRedirect("/user/login");
            return;
        }
        String path = "/WEB-INF/view/board/write.jsp";
        req.getRequestDispatcher(path).forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserVO loginUser = (UserVO) session.getAttribute("loginUser");
        BoardVO vo = new BoardVO();
        vo.setTitle(req.getParameter("title"));
        vo.setCtnt(req.getParameter("ctnt"));
        vo.setWriter(loginUser.getIuser());
        int result = BoardDAO.writeboard(vo);
        switch (result){
            case 1:
                res.sendRedirect("/board/list");
                break;
            case 0 :
                req.setAttribute("data",vo);
                req.setAttribute("err","등록 실패");
                doGet(req, res);
        }

    }
}
