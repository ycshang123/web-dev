package com.soft2176.bookonline.servlet;

import com.soft2176.bookonline.entity.Book;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * @program: java-web-dev
 * @description:拦截/idnex请求，获取所有图书数据，并通过服务器端转发跳转到主页
 * @author: ycshang
 * @create: 2022-02-24 13:54
 **/
@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  获得各个Servlet共享对象
        ServletContext sc = this.getServletContext();
        //   取得全局应用对象的变量
        List<Book> bookList = (List<Book>) sc.getAttribute("bookList");
        //    存入request
        req.setAttribute("bookList", bookList);
        //    通过服务器端转发，将数据带过去，保持地址栏不变
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}