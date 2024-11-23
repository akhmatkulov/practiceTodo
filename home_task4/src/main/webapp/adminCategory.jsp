<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Category</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <style>
    .box{
      border: 1px solid;
      height: 550px;
      margin-top: 10px;
      margin-left: 10px;
      margin-right: 10px;
      border-radius: 10px;
    }
    .box button {
      display: block;
      width: 80%;
      margin: 10px auto;
      padding: 10px;
      border-radius: 5px;
    }

  </style>
</head>
<body>
<div class="row">
  <div class="col-2">
    <div class="box">
      <form action="/addCategory" method="post">
        <button class="btn btn-outline-dark">Category</button>
      </form>
      <form action="/addProduct" method="post">
        <button class="btn btn-outline-dark">Product</button>
      </form>
    </div>
  </div>
  <div class="col-7">
    <div class="box">

    </div>
  </div>
</div>
</body>
</html>
