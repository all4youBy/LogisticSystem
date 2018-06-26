package servlets;

import entities.Order;
import remote.DbManagerRemote;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/route")
public class ShowOrdersServlet extends HttpServlet {

    @EJB
    private DbManagerRemote remote;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            List<Order> orders = remote.getAllOrders();
            if (orders == null)
                throw new ServletException("Order list is null");

            req.setAttribute("orders", orders);
        req.getRequestDispatcher("/jspPages/adminMain.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}