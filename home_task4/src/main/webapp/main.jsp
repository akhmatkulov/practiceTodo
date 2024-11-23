<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Admin</title>
</head>
<body>
<div class="container mt-5">
    <div class="row">
        <div class="col-6 offset-3">
            <div class="card">
                <div class="card-header bg-dark text-white text-center">
                    <h2>Choose User Type</h2>
                </div>
                <div class="card-body text-center">
                    <form method="post" action="/login">
                        <button type="submit" class="btn btn-primary w-50 mb-3">Admin</button>
                        <button type="submit" class="btn btn-secondary w-50">User</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
