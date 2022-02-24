<%@ page import="com.soft2176.bookonline.entity.Book" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
<!DOCTYPE html>
<html>
<head>
    <title>主页</title>
    <style>
        h2, h3 {
            color: rgb(73, 73, 73);
        }

        #search {
            height: 80px;
            background-color: rgb(246, 246, 241);
            display: flex;
            align-items: center;
            padding-left: 8%;
            margin-bottom: 10px;
        }

        .search-input {
            flex: 0 0 40%;
            height: 35px;
            background-color: #fff;
            border: none;
            border-radius: 3px;
            margin-left: 50px;
        }

        .search-btn {
            width: 35px;
            height: 35px;
            background-color: rgb(155, 154, 143);
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .search-btn img {
            width: 50%;
            height: 50%;
        }

        .card {
            display: flex;
            flex-direction: column;
            width: 100%;
            height: 140px;
            margin: 20px 5px 20px 5px;
        }

        .card img {
            width: 100%;
            height: 90%;
        }

        .card p {
            font-size: 13px;
            color: #9b9b9b;
        }

        .col-4 img {
            margin: 10px 5px 20px 5px;
            width: 80%;
        }

        hr {
            width: 90%;
            color: #eee;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<%
    List<Book> bookList = (List<Book>) request.getAttribute("bookList");
%>
<%--使用jsp的include动作，将top.jsp页面包含进来，顶部导航可以给各个页面共享--%>
<div id="top">
    <jsp:include page="top.jsp"/>
</div>
<%--搜索区--%>
<div id="search">
    <h2>读书时刻</h2>
    <input type="text" placeholder="书名、作者、ISBN" class="search-input">
    <div class="search-btn">
        <img src="images/search.png">
    </div>
</div>
<%--主体内容--%>
<div class="container">
    <div class="row">
        <div class="col-8">
            <h3>新书速递</h3>
            <hr>
            <div class="row">
                <%-- 遍历图书数据集合，将每个图书对象放入页面对象里面--%>
                <%
                    for (Book book : bookList) {
                        pageContext.setAttribute("book", book);

                %>
                    <div class="col-12 card">
                        <a href="${pageContext.request.contextPath}/detail/${book.id}">
                        <p style="font-size: 16px;font-weight: bold;color: #232525;margin-left: 45px">${book.name}</p>
                        <div style="display: flex;height: 140px;width: 100%;justify-content: space-around">
                            <div class="col-8" style="margin: 15px;display:flex;flex-direction: column">
                                <p style="color: #9b9b9b;font-size: 16px;text-indent:2em">${book.describe.substring(0,140)}……</p>
                           <div style="display:flex;width: 240px;justify-content: space-around;height: 40px;align-items: center;margin-top: 10px">
                               <img src="images/icon_love_hover.png" style="width: 25px;height: 25px">
                               <p style="font-size: 10px;color: #9b9b9b">123</p>
                               <img src="images/money.png" style="width: 25px;height: 25px">
                               <p style="font-size: 10px;color: #9b9b9b">2.3w</p>
                               <img src="images/Message.png" style="width: 25px;height: 25px">
                               <p style="font-size: 10px;color: #9b9b9b">3456k</p>
                           </div>
                            </div>
                            <div class="col-2">
                                <img src="images/${book.cover}" alt="图书封面">
                            </div>
                        </div>
                            <div style="border:#e0e0e0 solid 0.5px"></div>
                        </a>

                    </div>
                <%
                    }
                %>
            </div>
        </div>
        <div class="col-4">
            <h3>热门标签</h3>
            <hr>
            <img src="images/right.jpg" alt="左侧图片">
        </div>
    </div>
    <footer>
        <ul>
            <li>@2020-@2022</li>
            <li>niit.edu.cn</li>
            <li>all rights reserved</li>
            <li>计算机与软件学院</li>
        </ul>
        <ul>
            <li>联系我们</li>
            <li>帮助中心</li>
            <li>法律声明</li>
            <li>移动合作</li>
        </ul>
    </footer>
</div>


</body>
</html>