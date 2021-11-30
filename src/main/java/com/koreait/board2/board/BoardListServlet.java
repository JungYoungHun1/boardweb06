package com.koreait.board2.board;

import com.koreait.board2.model.BoardParamVO;
import com.koreait.board2.model.BoardVO;
import com.koreait.board2.utils.MyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int recordCnt = 5;
        BoardParamVO param = new BoardParamVO();
        param.setRecordCnt(recordCnt);
        req.setAttribute("maxPage", BoardDAO.selMaxpage(param));

        int page = MyUtils.getParameterInt(req, "page", 1);
        param.setPage(page);

        req.setAttribute("list", BoardDAO.listboard(param));
        //disForward는 항상 가장 아래
        MyUtils.disForward(req, res, "board/list");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
