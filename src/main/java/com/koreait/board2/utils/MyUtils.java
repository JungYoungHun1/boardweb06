package com.koreait.board2.utils;

import com.koreait.board2.model.UserVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyUtils {
    public static void disForward(HttpServletRequest req, HttpServletResponse res, String jsp) throws ServletException, IOException {
        String path = "/WEB-INF/view/" + jsp + ".jsp";
        req.getRequestDispatcher(path).forward(req, res);
    }
    public static int parseStringToInt(String str, int defVal){
        try {
            return Integer.parseInt(str);
        }catch (Exception e){}
        return defVal;
    }
    public static int parseStringToInt(String str){
        return parseStringToInt(str, 0);
    }

    public static int getParameterInt(HttpServletRequest req, String str){
//        try {
//            return parseStringToInt(req.getParameter(str));
//        }catch (Exception e){}
//        return 0;

        String strVal = req.getParameter(str);
        int intVal = parseStringToInt(strVal);
        return intVal;
    }
    public static int getParameterInt(HttpServletRequest req, String key, int defVal){
        return parseStringToInt(req.getParameter(key), defVal);
    }
    //로그인 했으면 return pk값, 로그아웃 상태면 return 0;
    public static int getLoginUserPk(HttpServletRequest req) {
        UserVO loginUser = getLoginUser(req);
        return loginUser == null ? 0 : loginUser.getIuser();
    }

    //로그인 했으면 return true, 로그아웃 상태면 return false;
    public static boolean isLogin(HttpServletRequest req) {
        return getLoginUser(req) != null;
    }

    public static boolean isLogout(HttpServletRequest req) {
        return getLoginUser(req) == null;
    }

    //로그인이 안 되어 있으면 return null; 되어 있으면 UserVO 객체 주소값
    public static UserVO getLoginUser(HttpServletRequest req) {
        HttpSession session = req.getSession();
        return (UserVO)session.getAttribute("loginUser");
    }

}
