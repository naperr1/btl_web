<%-- 
    Document   : manageOrders
    Created on : Dec 31, 2023, 6:43:55 PM
    Author     : Mr.Thai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Manage Orders</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
        integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"
            integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w=="
            crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

        <link rel="stylesheet" href="assets/css/adminDashboard.css">
        <link rel="stylesheet" href="assets/css/manageOrders.css">
    </head>
    <body>
        <!-- header -->
    <div class="header">
        <div class="header__logo">
            <img src="assets/image/logo.png" alt="">
            <span>Furnish</span>
        </div>
        <div class="header__nav">
            <ul class="header__icon">
                <li>
                    <i class="fa-solid fa-magnifying-glass"></i>
                </li>
                <li>
                    <i class="fa-regular fa-bell"></i>
                </li>
                <li>
                    <i class="fa-regular fa-envelope"></i>
                </li>
            </ul>
            <div class="header__manager">
                <div class="header__avatar">
                    <img src="assets/image/ava1.jpg" alt="">
                </div>
                <div class="header__info">
                    <div class="header__name">
                        Nguyen An Phat
                    </div>
                    <span>Manager</span>
                </div>
            </div>
        </div>
    </div>
    <!-- End header -->

    <!-- main -->
    <div class="main">
        <div class="main__sidebar">
            <ul>
                <li>
                    <a href="admin.html">
                        <span><i class='bx bx-home'></i></span>
                        <h3>Dashboard</h3>
                    </a>
                </li>
                <li>
                    <a href="listItemManager">
                        <span><i class='bx bx-shopping-bag'></i></span>
                        <h3>Product</h3>
                    </a>
                </li>
                <li>
                    <a href="categoryManager">
                        <span><i class='bx bx-category'></i></span>
                        <h3>Category</h3>
                    </a>
                </li>
                <li>
                    <a href="userManager">
                        <span><i class='bx bx-user'></i></span>
                        <h3>Customers</h3>
                    </a>
                </li>
                <li>
                    <a href="listOrdersManager">
                        <span><i class='bx bx-cart'></i></span>
                        <h3>Orders</h3>
                    </a>
                </li>
            </ul>
            <div class="main__logout">
                <a href="#">
                    <span>
                        <i class="fa-solid fa-arrow-right-to-bracket"></i>
                    </span>
                    <h3>Logout</h3>
                </a>
            </div>
        </div>
        <div class="orders">
            <h1>Manage Orders</h1>
            <form class="orders__form" action="">
                <div class="orders__function">
                    <div class="orders__search">
                        <input type="text" name="username" placeholder="Search by username..." id="orderSearchInput" oninput="searchOrder()">
                        <a href="#">
                            <i class="fa-solid fa-magnifying-glass"></i>
                        </a>
                    </div>
                    <div class="orders__filter">
                        <div class="orders__sort">
                            <span>Sort By</span>
                            <select name="sortType" id="sort">
                                <option value="0">Default</option>
                                <option value="1">Total: Low to High</option>
                                <option value="2">Total: High to Low</option>
                                <option value="3">Date: Outdated to Latest</option>
                                <option value="4">Date: Latest to Outdated</option>
                            </select>
                        </div>
                        <div class="orders__status">
                            <span>Status</span>
                            <select name="status" id="status">
                                <option value="1">Processing</option>
                                <option value="2">Shipping</option>
                                <option value="3">Completed</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="orders__table">
                    <table>
                        <tr>
                            <th>Order ID</th>
                            <th>Username</th>
                            <th>Date</th>
                            <th>Total</th>
                            <th>Status</th>
                            <th>Action</th>
                        </tr>
                        <c:forEach items="${requestScope.data}" var="c">
                            <tr>
                                <td class="orders__id">${c.orderID}</td>
                                <td class="orders__name">${c.username}</td>
                                <td class="orders__date">${c.orderDate}</td>
                                <td class="orders__total">${c.totalMoney}</td>
                                <td class="orders__status">${c.status}</td>
                                <td class="orders__action">
                                    <ul>
                                        <li>
                                            <a href="viewOrder.html">
                                                <i class="fa-regular fa-eye"></i>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="updateOrder.html">
                                                <i class="fa-solid fa-pencil"></i>
                                            </a>
                                        </li>
                                    </ul>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="orders__pagination">
                    <ul>
                        <li>
                            <a href="#">1</a>
                        </li>
                        <li>
                            <a href="#">2</a>
                        </li>
                        <li>
                            <a href="#">3</a>
                        </li>
                        <li>
                            <a href="#">4</a>
                        </li>
                        <li>
                            <a href="#">5</a>
                        </li>
                        <li>
                            <a href="#">6</a>
                        </li>
                    </ul>
                </div>
            </form>
        </div>
    </div>
    <!-- End main -->
    </body>
    <script>
        function searchOrder() {
            var searchInput = document.getElementById('orderSearchInput').value.toLowerCase();

            var rows = document.querySelectorAll('.orders__table table tr');
            for (var i = 1; i < rows.length; i++) { 
                var userName = rows[i].querySelector('.orders__name').innerText.toLowerCase();
                if (userName.includes(searchInput)) {
                    rows[i].style.display = '';
                } else {
                    rows[i].style.display = 'none';
                }
            }
        }
    </script>
</html>
