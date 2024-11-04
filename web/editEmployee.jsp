<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="ua.znu.edu.javaEElabs.Employee" %>
<%
    String idStr = request.getParameter("id");
    long id = Long.parseLong(idStr);
    Employee emp = null;

    Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Lab5Database;create=true;user=Nikita;password=111111");
    
    PreparedStatement stmt = con.prepareStatement("SELECT * FROM employee WHERE id = ?");
    stmt.setLong(1, id);
    ResultSet rs = stmt.executeQuery();

    if (rs.next()) {
        emp = new Employee(
            rs.getLong("id"),
            rs.getString("first_name"),
            rs.getString("last_name"),
            rs.getString("designation"),
            rs.getString("phone")
        );
    }

    rs.close();
    stmt.close();
    con.close();
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Редагувати співробітника</title>
</head>
<body>
    <h1>Редагувати співробітника</h1>
    <form action="UpdateEmployeeServlet" method="post">
        <input type="hidden" name="id" value="<%= emp.getId() %>">
        Ім’я: <input type="text" name="first_name" value="<%= emp.getFirstName() %>"><br>
        Прізвище: <input type="text" name="last_name" value="<%= emp.getLastName() %>"><br>
        Посада: <input type="text" name="designation" value="<%= emp.getDesignation() %>"><br>
        Телефон: <input type="text" name="phone" value="<%= emp.getPhone() %>"><br>
        <input type="submit" value="Оновити">
    </form>
    <a href="EmployeeServlet">Назад до списку співробітників</a>
</body>
</html>
