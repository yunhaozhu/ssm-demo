<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ page contentType="text/html;charset=UTF-8" language="java" %> <html>
<head>
    <title>Add A Book</title>
    <meta name="viewport" content="width=device-width, initial- scale=1.0">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>Edit</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/editBook" method="post">
        <input type="hidden" name="bookID" value="${Book.bookID}">
        <div class="from-group">
            <label for="bookName">Book Name:</label>
            <input type="text" class="form-control" name="bookName" id="bookName" value="${Book.bookName}" required>
        </div>
        <div class="from-group">
            <label for="stuck">Stuck:</label>
            <input type="text" class="form-control" name="bookCounts" id="stuck" value="${Book.bookCounts}" required>
        </div>
        <div class="from-group">
            <label for="description">Description:</label>
            <input type="text" class="form-control" name="detail" id="description" value="${Book.detail}" required>
        </div>
        <div class="from-group">
            <input type="submit" class="form-control" value="Submit">
        </div>

    </form>

</div>
