<%@ page import="students.StudentsDao" %>
<%@ page import="students.Student" %>
<%@ page import="students.AndFilter" %><%--
  Created by IntelliJ IDEA.
  User: tamta
  Date: 19.05.23
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students' List</title>
</head>
<body>
    <div class="container">
        <form id="filter" method="get" action="student">
            <input type="text" placeholder="First Name Filter" name="first-name-filter">
            <input type="text" placeholder="Last Name Filter" name="last-name-filter">
            <input type="text" placeholder="Year Filter" name="year-filter">
            <input type="submit" value="Filter" id="Filter button">
        </form>
        <form id="form" method="post" action="student">
            <input type="text" placeholder="First Name" name="first-name">
            <input type="text" placeholder="Last Name" name="last-name">
            <input type="text" placeholder="Year" name="year">
            <input type="submit" value="Add Student" id="Add button">
        </form>

        <table class="student-table">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Year</th>
            </tr>
            <%
                for (Student student: ((StudentsDao)application.getAttribute("store")).getFiltered((AndFilter)request.getAttribute("filter"))) {
            %>
            <tr>
                <td> <%= student.getFirstName() %> </td>
                <td> <%= student.getLastName() %> </td>
                <td> <%= student.getEnrollmentYear() %> </td>
            </tr>
            <% } %>
        </table>
    </div>
</body>
</html>
