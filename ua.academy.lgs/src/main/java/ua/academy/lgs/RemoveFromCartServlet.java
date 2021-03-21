package ua.academy.lgs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RemoveFromCartServlet", value = "/RemoveFromCartServlet")
public class RemoveFromCartServlet extends HttpServlet {
    JournalService journalService=JournalService.getJournalService();
    UserService userService=UserService.getUserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     Journal mySubscription = journalService.getJournal(request.getParameter("name"));
     journalService.addToCart(mySubscription);
     User user = userService.getUserByLogged(true);
    journalService.setToPay(journalService.getToPay()-mySubscription.getPrice());

        response.getWriter().print(  "<!DOCTYPE html>");
        response.getWriter().print(  "<html>");
        response.getWriter().print(  "<head>");
        response.getWriter().print(  "<title>JournalAdded</title>");
        response.getWriter().print(  "</head>");
        response.getWriter().print(  "<body>");
        response.getWriter().print(  user.getFirstName());
        response.getWriter().print(" you removed "+ mySubscription.getName() +" from list of your subsription.");
        response.getWriter().print("<br>");
        response.getWriter().print("You need to pay now ");
        response.getWriter().print(journalService.getToPay());
        response.getWriter().print("<br>");
        response.getWriter().print("Return to" );
        response.getWriter().print(" <a href=");
        response.getWriter().print(" index.jsp>");
        response.getWriter().print(" homepage</a>");
        response.getWriter().print(  "</body>");
        response.getWriter().print(  "</html>");
    }
}

