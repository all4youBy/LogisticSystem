package servlets;

import entities.Order;
import entities.Truck;
import remote.DbManagerRemote;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/singleorder")
public class SingleOrderServlet extends HttpServlet {

    @EJB
    private DbManagerRemote remote;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String method = req.getParameter("method");

        if(method.equals("show_order")) {
            int id = Integer.parseInt(req.getParameter("order_id"));
            Order order = remote.getOrderById(id);
            List<Truck> trucks = remote.getFreeTrucks();

            if (order == null || trucks == null)
                throw new ServletException("Entity is null.");

            req.setAttribute("order", order);
            req.setAttribute("trucks", trucks);

            req.getRequestDispatcher("/jspPages/adminMain.jsp").forward(req, resp);
        }else if(method.equals("set_truck")){

            String truckIdS = req.getParameter("truck_id");
            String orderIdS = req.getParameter("order_id");

            if(truckIdS == null || orderIdS == null)
                throw new ServletException("Parameters are null.");

            Integer truckId = Integer.parseInt(truckIdS);
            Integer orderId = Integer.parseInt(orderIdS);

            Order order = remote.getOrderById(orderId);

            boolean checkSetTruck =  remote.setTruckToOrder(orderId,truckId,order.getCargoQuantity());

           req.setAttribute("check_set_truck",checkSetTruck);
           req.getRequestDispatcher("/singleorder?order_id="+orderIdS+"&method=show_order").forward(req,resp);
        }else if(method.equals("complete_order")){

            String orderIdS = req.getParameter("order_id");

            if(orderIdS == null)
                throw new ServletException("Parameters are null.");

            Integer orderId = Integer.parseInt(orderIdS);
            remote.completeOrder(orderId);
            req.setAttribute("check_order_complete",true);
            req.getRequestDispatcher("/singleorder?order_id="+orderIdS+"&method=show_order").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
