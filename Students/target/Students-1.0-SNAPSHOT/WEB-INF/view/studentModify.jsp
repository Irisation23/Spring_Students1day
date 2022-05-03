<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <title>StudentModify</title>
</head>
<body>
<form method="post" action="/student/${student.id}/modify">
    name : <input type="text" name="name" value="${student.name}" /><br />
    email : <input type="text" name="email" value="${student.email}" /><br />
    score : <input type="text" name="score" value="${student.score}" /><br />
    comment : <textarea name="comment" rows="10" cols="80">${student.comment}</textarea><br />
    <br />
    <input type="submit" />
</form>

</body>
</html>
