package ua.academy.lgs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login =request.getParameter("email");
        String password = request.getParameter("password");

        UserService userService = UserService.getUserService();
        User user =userService.getUser(login);
        if(login.equals("admin@admin")&&password.equals("admin")){
            request.getRequestDispatcher("adminPersonalArea.jsp").forward(request,response);
        }
        if(user == null){
            request.getRequestDispatcher("login.jsp").forward(request,response);
            response.getWriter().print("Login error");
        }
        if (user.getEmail().equals(login)&&user.getPassword().equals(password)){
            request.setAttribute("userName",user.getFirstName());
            request.getRequestDispatcher("personalArea.jsp").forward(request,response);
            user.setLogged(true);
        }
        request.getRequestDispatcher("login.jsp").forward(request,response);


    }
}
