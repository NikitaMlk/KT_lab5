<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Додати співробітника</title>
</head>
<body>
    <h2>Додати співробітника</h2>
    <form action="AddEmployeeServlet" method="post">
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" required><br><br>
        
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" required><br><br>
        
        <label for="designation">Designation:</label>
        <input type="text" id="designation" name="designation" required><br><br>
        
        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="phone" required><br><br>
        
        <input type="submit" value="Додати співробітника">
    </form>
    <br>
    <a href="index.jsp">Повернутися до списку співробітників</a>
</body>
</html>
