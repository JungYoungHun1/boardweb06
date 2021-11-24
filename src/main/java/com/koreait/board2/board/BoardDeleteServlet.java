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

@WebServlet("/board/delete")
public class BoardDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserVO loginUser = (UserVO)session.getAttribute("loginUser");
        BoardVO vo = new BoardVO();
        vo.setIboard(Integer.parseInt(req.getParameter("iboard")));
        vo.setWriter(loginUser.getIuser());
        int result = BoardDAO.delboard(vo);
        switch (result){
            case 1:
                res.sendRedirect("/board/list");
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
