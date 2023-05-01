<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- BEGIN -->
<html>
<head>
    <meta charset="UTF-8">
    <title>Users</title>
</head>
<body>
    <form action='delete?id=${user.get("id")}' method="POST">
        <h1>Do you want to delete ${user.get("firstName")} ${user.get("lastName")}?</h1>
        <button type="submit" class="btn btn-danger">Delete</button>
    </form>
</body>
</html>
<!-- END -->
