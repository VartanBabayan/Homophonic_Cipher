<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<String> messages = (List<String>) request.getAttribute("messages"); %>
<% List<String> EncryptedMessages = (List<String>) request.getAttribute("EncryptedMessages"); %>

<!DOCTYPE html>
<html>
<head>
  <title>Cipher History</title>
</head>
<body>
<h1><p align="center">History of performed operations</p></h1>
  <table align="center" cols=2 cellspacing=50>
    <tr>
      <th>Messages</th>
      <th>Encrypted Messages</th>
    </tr>

    <c:forEach items="${messages}" var="item">
      <tr>
        <td><c:out value="${item}" /></td>
      </tr>
    </c:forEach>

    <c:forEach items="${EncryptedMessages}" var="item">
      <tr>
        <td><c:out value="${item}" /></td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>
