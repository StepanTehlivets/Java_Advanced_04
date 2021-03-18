package ua.academy.lgs;

        import javax.servlet.*;
        import javax.servlet.http.*;
        import javax.servlet.annotation.*;
        import java.io.IOException;
        import java.util.Iterator;

@WebServlet(name = "ShowJournalsServlet", value = "/ShowJournalsServlet")
public class ShowJournalsServlet extends HttpServlet {
    JournalService journalService=JournalService.getJournalService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().print(  "<!DOCTYPE html>");
        response.getWriter().print(  "<html>");
        response.getWriter().print(  "<head>");
        response.getWriter().print(  "<title>JournalAdded</title>");
        response.getWriter().print(  "</head>");
        response.getWriter().print(  "<body>");
        Iterator iterator = journalService.getListOfJournals().iterator();
        while(iterator.hasNext()){


            Journal journal= (Journal) iterator.next();

            response.getWriter().print("<p name="+":"+"journalName"+">"+journal.getName() +" with price "+ journal.getPrice());
            response.getWriter().print("<form action=");
            response.getWriter().print("AddToCartServlet");
            response.getWriter().print(" method=");
            response.getWriter().print("post");
            response.getWriter().print("><input type=");
            response.getWriter().print("submit " );
            response.getWriter().print("value=");
            response.getWriter().print("Add to Cart");
            response.getWriter().print("> </form>");

        }
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
