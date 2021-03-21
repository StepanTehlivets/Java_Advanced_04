package ua.academy.lgs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddToCartServlet", value = "/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
    JournalService journalService=JournalService.getJournalService();
    UserService userService=UserService.getUserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        User user = userService.getUserByLogged(true);
        if(user==null){
            response.getWriter().print(  "<!DOCTYPE html>");
            response.getWriter().print(  "<html>");
            response.getWriter().print(  "<head>");
            response.getWriter().print(  "<title>JournalAdded</title>");
            response.getWriter().print(  "</head>");
            response.getWriter().print(  "<body>");
            response.getWriter().print(" <a href=");
            response.getWriter().print(" registration.jsp>");
            response.getWriter().print(" You need to register first</a>");

            response.getWriter().print(  "</body>");
            response.getWriter().print(  "</html>");
        }else{
        Journal mySubscription = journalService.getJournal(request.getParameter("name"));
        journalService.addToCart(mySubscription);
        journalService.setToPay(journalService.getToPay()+mySubscription.getPrice());

        response.getWriter().print(  "<!DOCTYPE html>");
        response.getWriter().print(  "<html>");
        response.getWriter().print(  "<head>");
        response.getWriter().print(  "<title>JournalAdded</title>");
        response.getWriter().print(  "</head>");
        response.getWriter().print(  "<body>");
        response.getWriter().print(  user.getFirstName());
        response.getWriter().println(" you added "+ mySubscription.getName() +" with price " + mySubscription.getPrice()+" ");
        response.getWriter().print("<br>");
        response.getWriter().print("You need to pay now ");
        response.getWriter().print(journalService.getToPay());
        response.getWriter().print("<br>");
        response.getWriter().print("Return to" );
        response.getWriter().print(" <a href=");
        response.getWriter().print(" index.jsp>");
        response.getWriter().print(" homepage</a>");
        response.getWriter().print("<br>");
        response.getWriter().print("Return to" );
        response.getWriter().print(" <a href=");
        response.getWriter().print(" personalArea.jsp>");
        response.getWriter().print(" personal area</a>");
        response.getWriter().print(  "</body>");
        response.getWriter().print(  "</html>");
        }
    }
}

