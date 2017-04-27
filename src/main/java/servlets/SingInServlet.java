package servlets;

import accounts.AccountService;
import accounts.UserProfile;
import dbService.dataSets.UsersDataSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SingInServlet  extends HttpServlet {

    private AccountService accountService;

    public SingInServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        if (login == null || pass == null || login.equals("") || pass.equals("")) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

//        UserProfile profile = accountService.getUserByLogin(login);
//        if (profile == null || !profile.getLogin().equals(login)) {
//            response.setContentType("text/html;charset=utf-8");
//            response.getWriter().println("Unauthorized");
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            return;
//        }
        UsersDataSet usersDataSet = accountService.getUserByLogin(login);
        if (usersDataSet == null || !usersDataSet.getLogin().equals(login)) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("Unauthorized");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

//
//        accountService.addSession(request.getSession().getId(), profile);

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("Authorized: " + login);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
