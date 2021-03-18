//package ua.academy.lgs;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
//import java.io.IOException;
//
//@WebServlet(name = "AddToCartServlet", value = "/AddToCartServlet")
//public class AddToCartServlet extends HttpServlet {
//    JournalService journalService=JournalService.getJournalService();
//    UserService userService=UserService.getUserService();
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//     Journal mySubscription = journalService.getJournal("Nature");
//     journalService.addToCart(mySubscription);
//        response.getWriter().print(mySubscription.getName()  );
//     User user = userService.getUserByName(request.getParameter("userName"));
//     double newToPay = mySubscription.getPrice() + user.getToPay();
//        user.setToPay( newToPay);
//        response.getWriter().print(  "<!DOCTYPE html>");
//        response.getWriter().print(  "<html>");
//        response.getWriter().print(  "<head>");
//        response.getWriter().print(  "<title>JournalAdded</title>");
//        response.getWriter().print(  "</head>");
//        response.getWriter().print(  "<body>");
//
//        response.getWriter().print("You need to pay now" + user.getToPay());
//        response.getWriter().print("Return to" );
//        response.getWriter().print(" <a href=");
//        response.getWriter().print(" index.jsp>");
//        response.getWriter().print(" homepage</a>");
//        response.getWriter().print(  "</body>");
//        response.getWriter().print(  "</html>");
//    }
//}
//