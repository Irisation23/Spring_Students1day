<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <title>StudentRead</title>
</head>
<body>
    name :  ${student.name}<br />
    email :  ${student.email}<br />
    score :  ${student.score}<br />
    comment :  ${student.comment}<br />
    <br />
    <a href="/student/${student.id}/modify">정보 수정</a><br />
</body>
</html>
