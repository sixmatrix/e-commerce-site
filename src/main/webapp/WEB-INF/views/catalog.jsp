<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    
    <title>Catalog</title>
</head>
<body>

  <nav class="navbar navbar-expand-lg navbar-light" style="background-color:#E5F6DF;">
    <div class="container-fluid">
        <a href="/" class="navbar-brand">The Tree House</a>
        <div class="navbar-nav">
            <a href="/" class="nav-item nav-link">Home</a>
            <a th:if="${isAuthorised}" href="/catalog" class="nav-item nav-link active">Catalog</a>
            <form th:if="${isAuthorised}" action="/search" class="container-fluid">
              <input type="text" name="searchInput" style="width: 500px;" placeholder="Item 1... Item 2... Item 3...">
              <button type="submit"></button>
            </form>
        </div>

        <div class="navbar-nav ms-auto">
            <div th:if="${isAuthorised}" class="navbar-nav ms-auto">

                <div class="container-fluid dropdown">
                    <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton2" data-bs-toggle="dropdown" aria-expanded="true">
                      Cart
                    </button>
                    <ul class="dropdown-menu dropdown-menu-light" aria-labelledby="dropdownMenuButton2">
                        <tr th:each="item: ${shoppingCart}">
                            <li><p th:text="${item.itemTitle}"></p></li>
                            <li><p th:text="${item.itemPrice}"></p></li>
                        <hr>
                        </tr>
                        <li><p th:text="'Total: ' + ${Total}"></p></li>
                        <li><a href="clearItems">Clear</a></li>
                        <li><a href="/checkout">Checkout</a></li>
                    </ul>
                </div>

                <div class="dropdown">
                  <button th:text="${userName}" class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton2" data-bs-toggle="dropdown" aria-expanded="false">
                      Username
                  </button>
                  <ul class="dropdown-menu dropdown-menu-light" aria-labelledby="dropdownMenuButton2">
                      <li><a href="logout">Logout</a></li>
                  </ul>
              </div>
            </div>

            <div th:unless="${isAuthorised}" class="navbar-nav ms-auto">
                <a href="/login" class="nav-item nav-link">Login</a>
                <a href="/register" class="nav-item nav-link">Register</a>
            </div>
        </div>
    </div>
    <br></br>
</nav>
<br></br>

    <div class="container-fluid">
        <div class="row align-items-center">
          <tr th:each="item: ${Items}">
            <div class="col-sm">
              <br>
              <span class="border-top">
                <h4 th:text="${item.itemTitle}"></h4>
                <h4 th:text="${item.itemPrice}"></h4>
                <img th:src="${item.itemImage}" style="width:300px;"></img>
                <h4 th:text="${item.itemDescription}"></h4>
                <a th:href="@{'/add?itemTitle=' + ${item.itemTitle}}"> 
                  <buttontype="button" class="btn btn-primary">Add To Cart</button>
                </a>
              </span>
          </div>
        </div>
      </tr>
    </div>

        <br>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>