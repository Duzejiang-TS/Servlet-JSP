package servlet;

import domain.Student;
import service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "servlet.StudentAddServlet" , urlPatterns = {"/add"})
public class StudentAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Student student = new Student();
        student.setId(request.getParameter("id"));
        student.setName(request.getParameter("name"));
        student.setSex(request.getParameter("sex"));
        student.setSchool(request.getParameter("school"));
        StudentServiceImpl studentService = new StudentServiceImpl();
        try {
            studentService.addStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /*try {
            BeanUtils.populate(student,request.getParameterMap());
       } catch (Exception e) {
           e.printStackTrace();
        }
        service.StudentServiceImpl studentService = new service.StudentServiceImpl();
        try {
            studentService.addStudent(student);
       } catch (SQLException e) {
            e.printStackTrace();
        }*/
        request.getRequestDispatcher("/list").forward(request , response);

    }
}
