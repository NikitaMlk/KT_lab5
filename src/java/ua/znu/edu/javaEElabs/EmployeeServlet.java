package ua.znu.edu.javaEElabs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EmployeeServlet", urlPatterns = {"/EmployeeServlet"})
public class EmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            String lastname = request.getParameter("lastname");
            ArrayList<Employee> employees = new ArrayList<Employee>();

            // Load the Derby DB driver
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            // Get a connection to the database
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Lab5Database;create=true;user=Nikita;password=111111");
            
            // Build the SQL query
            String sql = "SELECT id, first_name, last_name, designation, phone FROM employee";
            if (lastname != null && !lastname.isEmpty()) {
                sql += " WHERE last_name LIKE '%" + lastname + "%'";
            }
            
            // Execute the query
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Process the result set
            while (rs.next()) {
                Employee emp = new Employee(
                    rs.getLong("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("designation"),
                    rs.getString("phone")
                );
                employees.add(emp);
            }
            
            // Clean up
            rs.close();
            stmt.close();
            con.close();

            // Set the employee list as a request attribute
            request.setAttribute("employeesFound", employees);

            // Forward the request to the JSP page
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response); // Handle POST requests as GET
    }

    @Override
    public String getServletInfo() {
        return "Servlet that manages employee data.";
    }
}
