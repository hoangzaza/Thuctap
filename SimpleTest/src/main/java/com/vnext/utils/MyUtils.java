package com.vnext.utils;

import com.vnext.entity.UserAccount;
import com.vnext.model.UserAccountDAO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;

public class MyUtils {
    public static final String ATT_SESSION_LOGIN_USER = "loginedUser";
    public static final String ATT_COOKIE_USER_NAME = "store_in_cookie";
    public static void storeLoginUser(HttpSession session, UserAccount userAccount) {
        session.setAttribute(ATT_SESSION_LOGIN_USER, userAccount);
    }

    public static UserAccount getLoginedUser(HttpSession session) {
        UserAccount userAccount = (UserAccount) session.getAttribute(ATT_SESSION_LOGIN_USER);
        return userAccount;
    }

    public static void storeUserCookie(HttpServletResponse response, UserAccount userAccount) {
        Cookie cookie = new Cookie(ATT_COOKIE_USER_NAME, userAccount.getUserName());
        cookie.setMaxAge(24*60*60);
        response.addCookie(cookie);
    }

    public static String getUserLoginFromCookie(HttpServletRequest request) {
        Cookie [] cks = request.getCookies();
        if(cks != null) {
            for(Cookie ck:cks) {
                if(ck.getName().equals(ATT_COOKIE_USER_NAME)) {
                    return ck.getValue();
                }
            }
        }
        return null;
    }

    public static void deleteUserCookie(HttpServletResponse response) {
        Cookie ck = new Cookie(ATT_COOKIE_USER_NAME, null);
        ck.setMaxAge(0);
        response.addCookie(ck);
    }

    public static void storeConnection(HttpServletRequest request, Connection con) {
        request.setAttribute("connection", con);
    }

    public static Connection getStoredConnection (HttpServletRequest request) {
        Connection connection = (Connection) request.getAttribute("connection");
        return connection;
    }

    public static boolean checkLogin(HttpServletRequest request, HttpServletResponse response,Connection connection){
        HttpSession session = request.getSession();
        UserAccount userAccount = MyUtils.getLoginedUser(session);
        if(userAccount != null){
            return true;
        } else {

            String userName = MyUtils.getUserLoginFromCookie(request);
            UserAccount acc = UserAccountDAO.findUserAccount(connection,userName);
            if(acc !=null){
                return true;
            }
        }
        return false;

    }
}
