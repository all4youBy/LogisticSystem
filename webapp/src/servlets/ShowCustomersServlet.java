package servlets;

import entities.Customer;
import remote.DbManagerRemote;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewcustomers")
public class ShowCustomersServlet extends HttpServlet {

    @EJB
    private DbManagerRemote remote;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{

        List<Customer> customers = remote.getCustomers();

        if(customers == null)
            throw new ServletException("Customers array is null.");

        req.setAttribute("customers",customers);
        req.getRequestDispatcher("/jspPages/adminMain.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
