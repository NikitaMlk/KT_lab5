<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ua.znu.edu.javaEElabs.Employee"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Пошук співробітників</title>
</head>
<body>
    <a href='addEmployee.jsp'>Додати співробітника</a>
    <form action="EmployeeServlet">
        Прізвище співробітника
        <input type="text" name="lastname"> 
        <input type=submit value="пошук"> 
    </form> 

    <%
        ArrayList<Employee> employees = (ArrayList<Employee>) request.getAttribute("employeesFound");
        if (employees != null) {
            if (employees.size() == 0) {
                out.print("Співробітники не знайдено");
            } else {
                out.print("<TABLE border=\"1\">");
                out.print("<TR><TD>Id</TD><TD>Ім’я</TD><TD>Прізвище</TD><TD>Посада</TD><TD>Телефон</TD></TR>");
                for (Employee emp : employees) {
                    out.print("<TR>");
                    out.print("<TD>" + emp.getId() + "</TD>");
                    out.print("<TD>" + emp.getFirstName() + "</TD>");
                    out.print("<TD><a href='editEmployee.jsp?id=" + emp.getId() + "'>" + emp.getLastName() + "</a></TD>");
                    out.print("<TD>" + emp.getDesignation() + "</TD>");
                    out.print("<TD>" + emp.getPhone() + "</TD>");
                    out.print("</TR>");
                }
                out.print("</TABLE>");
            }
        }
    %>
</body>
</html>
