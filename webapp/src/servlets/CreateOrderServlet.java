package servlets;

import entities.Customer;
import entities.Order;
import remote.DbManagerRemote;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/order")
public class CreateOrderServlet extends HttpServlet{

    private static Logger log = Logger.getLogger(CreateOrderServlet.class.getName());

    @EJB
    private DbManagerRemote dbManagerRemote;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String cargoQuantity = req.getParameter("quantity");
        String dateS = req.getParameter("date");
        String city = req.getParameter("city");
        String street = req.getParameter("street");
        Customer customer = (Customer)req.getSession().getAttribute("user");

        if(cargoQuantity == null || dateS == null || city == null || street == null || customer == null)
            throw new ServletException("Get null parameters from order form");

        try {

            String address = String.format("г.%s , %s",city,street);
            Date dateDelivery = sqlDateConvector(dateS);
            Date dateOrder = new Date(System.currentTimeMillis());
            int cargoCapacity = Integer.parseInt(cargoQuantity);

            dbManagerRemote.createOrder(cargoCapacity,dateOrder,dateDelivery,address,customer.getId());

        } catch (ParseException e) {
            log.log(Level.SEVERE,e.getMessage(),e);
        }
        dbManagerRemote.updateCustomer(customer);
        List<Order> orders = dbManagerRemote.getCustomerOrders(customer);
        req.getSession().setAttribute("orders",orders);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    private Date sqlDateConvector(String dateS) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        java.util.Date parse = format.parse(dateS);
        return new Date(parse.getTime());
    }
}
