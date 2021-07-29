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
            if (currSort == 1) {
                window.location.href = '${pageContext.request.contextPath}?groupId=${groupId}&groupPage=${groupPage}&productPage=${productPage}&sortByName=0';
            } else {
                window.location.href = '${pageContext.request.contextPath}?groupId=${groupId}&groupPage=${groupPage}&productPage=${productPage}&sortByName=1';
            }
        }

        function sortByPrice() {
            var currSort = '${sortByPrice}';
            if (currSort == 1) {
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
                    <th scope="col" onclick="sortByName()">
                        Name

                        <c:choose>
                            <c:when test="${sortByName == 0}">
                                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-sort-alpha-down" viewBox="0 0 16 16">
                                    <path fill-rule="evenodd" d="M10.082 5.629 9.664 7H8.598l1.789-5.332h1.234L13.402 7h-1.12l-.419-1.371h-1.781zm1.57-.785L11 2.687h-.047l-.652 2.157h1.351z"/>
                                    <path d="M12.96 14H9.028v-.691l2.579-3.72v-.054H9.098v-.867h3.785v.691l-2.567 3.72v.054h2.645V14zM4.5 2.5a.5.5 0 0 0-1 0v9.793l-1.146-1.147a.5.5 0 0 0-.708.708l2 1.999.007.007a.497.497 0 0 0 .7-.006l2-2a.5.5 0 0 0-.707-.708L4.5 12.293V2.5z"/>
                                </svg>
                            </c:when>
                            <c:when test="${sortByName == 1}">
                                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-sort-alpha-down-alt" viewBox="0 0 16 16">
                                    <path d="M12.96 7H9.028v-.691l2.579-3.72v-.054H9.098v-.867h3.785v.691l-2.567 3.72v.054h2.645V7z"/>
                                    <path fill-rule="evenodd" d="M10.082 12.629 9.664 14H8.598l1.789-5.332h1.234L13.402 14h-1.12l-.419-1.371h-1.781zm1.57-.785L11 9.688h-.047l-.652 2.156h1.351z"/>
                                    <path d="M4.5 2.5a.5.5 0 0 0-1 0v9.793l-1.146-1.147a.5.5 0 0 0-.708.708l2 1.999.007.007a.497.497 0 0 0 .7-.006l2-2a.5.5 0 0 0-.707-.708L4.5 12.293V2.5z"/>
                                </svg>
                            </c:when>
                            <c:otherwise></c:otherwise>
                        </c:choose>

                    </th>
                    <th scope="col" onclick="sortByPrice()">
                        Price

                        <c:choose>
                            <c:when test="${sortByPrice == 0}">
                                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-sort-numeric-down" viewBox="0 0 16 16">
                                    <path d="M12.438 1.668V7H11.39V2.684h-.051l-1.211.859v-.969l1.262-.906h1.046z"/>
                                    <path fill-rule="evenodd" d="M11.36 14.098c-1.137 0-1.708-.657-1.762-1.278h1.004c.058.223.343.45.773.45.824 0 1.164-.829 1.133-1.856h-.059c-.148.39-.57.742-1.261.742-.91 0-1.72-.613-1.72-1.758 0-1.148.848-1.835 1.973-1.835 1.09 0 2.063.636 2.063 2.687 0 1.867-.723 2.848-2.145 2.848zm.062-2.735c.504 0 .933-.336.933-.972 0-.633-.398-1.008-.94-1.008-.52 0-.927.375-.927 1 0 .64.418.98.934.98z"/>
                                    <path d="M4.5 2.5a.5.5 0 0 0-1 0v9.793l-1.146-1.147a.5.5 0 0 0-.708.708l2 1.999.007.007a.497.497 0 0 0 .7-.006l2-2a.5.5 0 0 0-.707-.708L4.5 12.293V2.5z"/>
                                </svg>
                            </c:when>
                            <c:when test="${sortByPrice == 1}">
                                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor"
                                     class="bi bi-sort-numeric-down-alt" viewBox="0 0 16 16">
                                    <path fill-rule="evenodd"
                                          d="M11.36 7.098c-1.137 0-1.708-.657-1.762-1.278h1.004c.058.223.343.45.773.45.824 0 1.164-.829 1.133-1.856h-.059c-.148.39-.57.742-1.261.742-.91 0-1.72-.613-1.72-1.758 0-1.148.848-1.836 1.973-1.836 1.09 0 2.063.637 2.063 2.688 0 1.867-.723 2.848-2.145 2.848zm.062-2.735c.504 0 .933-.336.933-.972 0-.633-.398-1.008-.94-1.008-.52 0-.927.375-.927 1 0 .64.418.98.934.98z"/>
                                    <path d="M12.438 8.668V14H11.39V9.684h-.051l-1.211.859v-.969l1.262-.906h1.046zM4.5 2.5a.5.5 0 0 0-1 0v9.793l-1.146-1.147a.5.5 0 0 0-.708.708l2 1.999.007.007a.497.497 0 0 0 .7-.006l2-2a.5.5 0 0 0-.707-.708L4.5 12.293V2.5z"/>
                                </svg>
                            </c:when>
                            <c:otherwise></c:otherwise>
                        </c:choose>



                    </th>
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
