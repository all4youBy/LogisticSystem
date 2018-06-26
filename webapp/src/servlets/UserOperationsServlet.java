package servlets;

import entities.Account;
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
import java.util.List;

@WebServlet("/authentication")
public class UserOperationsServlet extends HttpServlet {

    @EJB
    private DbManagerRemote remote;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String method = req.getParameter("method");
        String accountType = "";
        if(method == null)
            throw new ServletException("Method is null.");

        if(method.equals("auth")) {

        String login = req.getParameter("login");
        String password = req.getParameter("pass");

        if(login == null || password == null)
            throw new ServletException("Login or password is null.");

        Account account = remote.getAccountByLoginAndPassword(login,password);
        if(account == null){
            req.setAttribute("no_such_user",true);
            req.getRequestDispatcher("/jspPages/authentication.jsp").forward(req,resp);
        }

        switch (account.getAccounttype()){
            case 0:  accountType = "admin"; break;
            case 1:  Customer customer = remote.getCustomerByAccount(login,password);
                     List<Order> customerOrders = remote.getCustomerOrders(customer);
                     req.getSession().setAttribute("user",customer);
                     req.getSession().setAttribute("orders",customerOrders);
                     accountType = "customer"; break;

        }

        req.getSession().setAttribute("accountType",accountType);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
        else if(method.equals("registrate")) {

            String userName = req.getParameter("userName");
            String password = req.getParameter("pass");
            String customerName = req.getParameter("name");

            int accountId = remote.createAccount(userName, password, 1);
            int custId = remote.createCustomer(customerName, accountId);

                req.setAttribute("new_user",remote.getCustomerById(custId));
                req.getRequestDispatcher("/jspPages/successRegistration.jsp").forward(req,resp);

        }
    }
}
