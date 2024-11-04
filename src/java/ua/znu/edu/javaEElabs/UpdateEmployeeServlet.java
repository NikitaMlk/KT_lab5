package ua.znu.edu.javaEElabs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UpdateEmployeeServlet", urlPatterns = {"/UpdateEmployeeServlet"})
public class UpdateEmployeeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            long id = Long.parseLong(request.getParameter("id"));
            String firstName = request.getParameter("first_name");
            String lastName = request.getParameter("last_name");
            String designation = request.getParameter("designation");
            String phone = request.getParameter("phone");

            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Lab5Database;create=true;user=Nikita;password=111111");

            PreparedStatement stmt = con.prepareStatement("UPDATE employee SET first_name = ?, last_name = ?, designation = ?, phone = ? WHERE id = ?");
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, designation);
            stmt.setString(4, phone);
            stmt.setLong(5, id);
            stmt.executeUpdate();

            stmt.close();
            con.close();

            response.sendRedirect("EmployeeServlet");

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ServletException(ex);
        }
    }
}
