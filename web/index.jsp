<%@ page import="entities.Category" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Stefan-PC
  Date: 07.02.2018
  Time: 1:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <%
    List<Category> categories = (List<Category>) session.getAttribute("categories");
  %>
  <body>
  $END$
  </body>
</html>
