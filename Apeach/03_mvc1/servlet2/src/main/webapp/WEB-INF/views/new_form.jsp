<!--WAS 서버 룰 : WEB-INF 아래에 있는 자원들은 외부에서 호출해도 호출되지 않음.-->
<!-- 항상 컨트롤러를 통해서 호출되어야 함. -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<!-- 상대경로 사용, [현재 URL이 속한 계층 경로 + /save] -->
<form action="save" method="post">
    username: <input type="text" name="username" />
    age: <input type="text" name="age" />
    <button type="submit">전송</button>
</form>

</body>
</html>