<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="uz.pdp.home_task4.DB" %>
<%@ page import="uz.pdp.home_task4.entity.Category" %>
<%@ page import="java.util.List" %>
<%
    // Kategoriyalarni DB'dan olib kelamiz
    List<Category> categories = DB.CATEGORIES;
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        /* Sidebar stili */
        .sidebar {
            border: 1px solid;
            height: 100vh;
            margin-top: 10px;
            border-radius: 10px;
        }
        .sidebar button {
            display: block;
            width: 80%;
            margin: 10px auto;
            padding: 10px;
            border-radius: 5px;
        }
        .container {
            display: flex;
        }
        .sidebar {
            flex: 1;
        }
        .main-content {
            flex: 4;
        }
    </style>
</head>
<body>
<div class="container mt-4">
    <!-- Sidebar -->
    <div class="sidebar p-3">
        <form action="/addCategory" method="post">
            <button class="btn btn-outline-dark w-100">Category</button>
        </form>
        <form action="/addProduct.jsp" method="post">
            <button class="btn btn-outline-dark w-100">Product</button>
        </form>
    </div>

    <!-- Main Content -->
    <div class="main-content">
        <div class="card">
            <div class="card-header">
                <h3>Add Product</h3>
            </div>
            <div class="card-body">
                <form action="/addProduct" method="post" enctype="multipart/form-data">
                    <div class="mb-3">
                        <label for="productName" class="form-label">Product Name</label>
                        <input type="text" id="productName" name="name" class="form-control" placeholder="Enter product name" required>
                    </div>
                    <div class="mb-3">
                        <label for="productPrice" class="form-label">Price</label>
                        <input type="text" id="productPrice" name="price" class="form-control" placeholder="Enter price" required>
                    </div>
                    <div class="mb-3">
                        <label for="productCategory" class="form-label">Category</label>
                        <select id="productCategory" name="category" class="form-control" required>
                            <option value="">Select a category</option>
                            <% for (Category category : categories) { %>
                            <option value="<%= category.getId() %>"><%= category.getCategoryName() %></option>
                            <% } %>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="productImage" class="form-label">Upload Image</label>
                        <input type="file" id="productImage" name="image" class="form-control-file" required>
                    </div>
                    <button class="btn btn-outline-success" type="submit">Save</button>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS (needed for modal functionality) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
