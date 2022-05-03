<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <title>StudentRegister</title>
</head>
<body>
    <form method="post" action="/student/register">
        이름: <input type="text" name="name" /><br />
        이메일: <input type="text" name="email" /><br />
        성적: <input type="text" name="score" /><br />
        평가: <textarea name="comment" rows="5" cols="50"></textarea><br />
        <br />
        <input type="submit" />
    </form>
</body>
</html>
