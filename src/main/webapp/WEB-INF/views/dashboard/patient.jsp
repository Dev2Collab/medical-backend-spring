<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ar" dir="rtl">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> Home </title>
        <link rel="stylesheet" href="./css/bootstrap.min.css">
        <link rel="stylesheet" href="./style.css">
    </head>
    <body>
        <div class="container">
            <%@ include file="../shared/header.jsp" %>
        </div>

            <h1>مرحبا بك في لوحة التحكم الخاصة بك ${user.fullName}</h1>


            <%@ include file="../shared/footer.jsp" %>
            <script src="./js/bootstrap.min.js"></script>
        </body>
    </html>
