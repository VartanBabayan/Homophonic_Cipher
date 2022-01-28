<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:set var="result" value="res"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Homophonic Cipher</title>
</head>
<body>
<h1><p align="center">Homophonic Cipher</p></h1>
<h3><p align="center">Note that you can use only letters of English alphabet</p></h3>
<br/>
<div align="center">
    <form action="/app" method="POST">
        <textarea name="message" placeholder="Message" cols=50 rows=5 required></textarea>
        <p><input type=radio name=flag value=E required>Encode</p>
        <p><input type=radio name=flag value=D required>Decode</p>
        <p><input type="submit" value="Submit"/></p>
    </form>
</div>
<div align="center">
        <textarea name="result" cols=50 rows=5 readonly>${result}</textarea>
</div>
<p><a href="/history">history</a></p>
</body>
</html>