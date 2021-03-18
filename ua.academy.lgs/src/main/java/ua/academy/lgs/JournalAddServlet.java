package ua.academy.lgs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "JournalAddServlet", value = "/JournalAddServlet")
public class JournalAddServlet extends HttpServlet {
    JournalService journalService=JournalService.getJournalService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name =request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
       journalService.saveJournal(new Journal(name,price));
        response.getWriter().print(  "<!DOCTYPE html>");
        response.getWriter().print(  "<html>");
        response.getWriter().print(  "<head>");
        response.getWriter().print(  "<title>JournalAdded</title>");
        response.getWriter().print(  "</head>");
        response.getWriter().print(  "<body>");
        response.getWriter().print("You added "+ journalService.getJournal(name).getName()+  " to our shop.");
        response.getWriter().print(  "<br>");
        response.getWriter().print("Return to" );
        response.getWriter().print(" <a href=");
        response.getWriter().print(" adminPersonalArea.jsp>");
        response.getWriter().print(" adding</a>");
        response.getWriter().print(  "<br>");
        response.getWriter().print("Return to" );
        response.getWriter().print(" <a href=");
        response.getWriter().print(" index.jsp>");
        response.getWriter().print(" homepage</a>");

        response.getWriter().print(  "</body>");
        response.getWriter().print(  "</html>");

    }
}
