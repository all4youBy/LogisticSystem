package servlets;

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

@WebServlet("/viewtrucks")
public class ShowTrucksServlet extends HttpServlet {

    @EJB
    private DbManagerRemote remote;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Truck> trucks = remote.getAllTrucks();

        if(trucks == null)
            throw new ServletException("Trucks array is null.");

        req.setAttribute("trucks",trucks);
        req.getRequestDispatcher("/jspPages/adminMain.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);
    }
}
