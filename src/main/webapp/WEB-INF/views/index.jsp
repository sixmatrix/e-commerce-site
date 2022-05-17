<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    
    <title>Home</title>
</head>
<body>

    <nav class="navbar navbar-expand-lg navbar-light" style="background-color:#E5F6DF;">
        <div class="container-fluid">
            <a href="/" class="navbar-brand">The Tree House</a>
            <div class="navbar-nav">
                <a href="/" class="nav-item nav-link active">Home</a>
                <a th:if="${isAuthorised}" href="/catalog" class="nav-item nav-link">Catalog</a>
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
        <p>This website is used to supply its users with the equipment required for gardening, as well as the purchasing of plants and other appliances.
        Feel free to register your details and login using your details to access other sections of the site.
        From there, you will be able to add items to your shopping cart which will calculate the total for you.
        If the total reaches a price of £50.00 or above, a 10% discount will be applied.
        This discount does not go away, if the user continues to pay for items and the price reaches its 10% discount, it will be applied to the user automatically.
        The availability of these items are tracked, and the item will become unavailable if the item reaches 0.
        Enjoy!
        </p>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>