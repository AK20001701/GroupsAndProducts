<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Groups and products</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">


    <script type="text/javascript">
        function nextProductPage() {
            window.location.href = '${pageContext.request.contextPath}?groupId=${groupId}&groupPage=${groupPage}&productPage=${productPage + 1}';
        }

        function prevProductPage() {
            var currPage = '${productPage}';
            if (currPage > 1) {
                window.location.href = '${pageContext.request.contextPath}?groupId=${groupId}&groupPage=${groupPage}&productPage=${productPage - 1}';
            }
        }

        function nextGroupPage() {
            window.location.href = '${pageContext.request.contextPath}?groupId=${groupId}&groupPage=${groupPage + 1}&productPage=${productPage}';
        }

        function prevGroupPage() {
            var currPage = '${groupPage}';
            if (currPage > 1) {
                window.location.href = '${pageContext.request.contextPath}?groupId=${groupId}&groupPage=${groupPage - 1}&productPage=${productPage}';
            }
        }

        function sortByName() {
            var currSort = '${sortByName}';
            if (currSort == 1){
                window.location.href = '${pageContext.request.contextPath}?groupId=${groupId}&groupPage=${groupPage}&productPage=${productPage}&sortByName=0';
            } else {
                window.location.href = '${pageContext.request.contextPath}?groupId=${groupId}&groupPage=${groupPage}&productPage=${productPage}&sortByName=1';
            }
        }

        function sortByPrice() {
            var currSort = '${sortByPrice}';
            if (currSort == 1){
                window.location.href = '${pageContext.request.contextPath}?groupId=${groupId}&groupPage=${groupPage}&productPage=${productPage}&sortByPrice=0';
            } else {
                window.location.href = '${pageContext.request.contextPath}?groupId=${groupId}&groupPage=${groupPage}&productPage=${productPage}&sortByPrice=1';
            }
        }
    </script>
</head>
<body>


<div class="container">

    <div class="row mt-3">
        <div class="table-responsive col-md-6">
            <h2 onclick="handleClick()">Groups</h2>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Number of products</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="curr" items="${groupElementCount}">
                    <tr>
                        <td>${curr.key.getGroupName()}</td>
                        <td>${curr.value}</td>
                        <input type="hidden" value="${curr.key.getId()}" name="GROUP_ID">
                        <td>
                            <a class="btn btn-outline-secondary"
                               href="${pageContext.request.contextPath}?groupId=${curr.key.getId()}&groupPage=${groupPage}&productPage=1">Show</a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>

            <div class="row">
                <div class="col d-flex justify-content-center text-center" onclick="prevGroupPage()">
                    <div class="col d-flex justify-content-center text-center ">
                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor"
                             class="bi bi-chevron-left" viewBox="0 0 16 16">
                            <path fill-rule="evenodd"
                                  d="M11.354 1.646a.5.5 0 0 1 0 .708L5.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z"></path>
                        </svg>
                    </div>
                </div>
                <div class="col d-flex justify-content-center text-center">
                    <h5>${groupPage}</h5>
                </div>
                <div class="col d-flex justify-content-center text-center " onclick="nextGroupPage()">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor"
                         class="bi bi-chevron-right" viewBox="0 0 16 16">
                        <path fill-rule="evenodd"
                              d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z"></path>
                    </svg>
                </div>
            </div>

        </div>

        <div class="table-responsive col-md-6">
            <h2>Products</h2>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col" onclick="sortByName()">Name</th>
                    <th scope="col" onclick="sortByPrice()">Price</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="product" items="${products}">
                    <tr>
                        <td>${product.getProductName()}</td>
                        <td>${product.getPrice()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="row">
                <div class="col d-flex justify-content-center text-center" onclick="prevProductPage()">
                    <div class="col d-flex justify-content-center text-center ">
                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor"
                             class="bi bi-chevron-left" viewBox="0 0 16 16">
                            <path fill-rule="evenodd"
                                  d="M11.354 1.646a.5.5 0 0 1 0 .708L5.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z"/>
                        </svg>
                    </div>
                </div>
                <div class="col d-flex justify-content-center text-center">
                    <h5>${productPage}</h5>
                </div>
                <div class="col d-flex justify-content-center text-center " onclick="nextProductPage()">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor"
                         class="bi bi-chevron-right" viewBox="0 0 16 16">
                        <path fill-rule="evenodd"
                              d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z"/>
                    </svg>
                </div>
            </div>
        </div>
    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
