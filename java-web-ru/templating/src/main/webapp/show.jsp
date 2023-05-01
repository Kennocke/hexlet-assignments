<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- BEGIN -->
<html>
    <head>
        <meta charset="UTF-8">
        <title>Users</title>
    </head>
    <body>
        <table>
            <tr>
                <td>Id</td>
                <td>${user.get("id")}</td>
            </tr>
            <tr>
                <td>FIO</td>
                <td>${user.get("firstName")} ${user.get("lastName")}</td>
            </tr>
            <tr>
                <td>Email</td>
                <td>${user.get("email")}</td>
            </tr>
            <tr>
                <td>Delete</td>
                <td><a href='delete?id=${user.get("id")}'>Delete</a></td>
            </tr>
        </table>
    </body>
</html>
<!-- END -->
