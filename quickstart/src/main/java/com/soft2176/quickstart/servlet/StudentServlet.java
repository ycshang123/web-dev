package com.soft2176.quickstart.servlet;

import com.soft2176.quickstart.entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @program: java-web-dev
 * @description:
 * @author: ycshang
 * @create: 2022-02-24 21:55
 **/
@WebServlet(urlPatterns = "/students")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student[] students = {
                new Student(1, "能能", "男", 21),
                new Student(2, "拉拉", "女", 22),
                new Student(3, "舜舜", "女", 23),
                new Student(4, "楠楠", "男", 24)
        };
        List<Student> studentList = Arrays.asList(students);
        req.setAttribute("studentList", studentList);
        req.getRequestDispatcher("/student.jsp").forward(req, resp);
    }
}