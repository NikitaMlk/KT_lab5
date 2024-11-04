package ua.znu.edu.javaEElabs;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet(name = "AddEmployeeServlet", urlPatterns = {"/AddEmployeeServlet"})
public class AddEmployeeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String designation = request.getParameter("designation");
            String phone = request.getParameter("phone");

            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Lab5Database;create=true;user=Nikita;password=111111");

            String query = "INSERT INTO employee (first_name, last_name, designation, phone) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, firstName);
            pst.setString(2, lastName);
            pst.setString(3, designation);
            pst.setString(4, phone);
            pst.executeUpdate();

            pst.close();
            con.close();

            response.sendRedirect("EmployeeServlet");

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ServletException(ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet to add a new employee.";
    }
}
