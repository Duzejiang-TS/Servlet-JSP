package servlet;

import domain.Student;
import service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "servlet.FindByIdServlet" , urlPatterns = {"/findid"})
public class FindByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        StudentServiceImpl studentService = new StudentServiceImpl();
        Student student = studentService.findId(id);
        request.setAttribute("student",student);
        request.getRequestDispatcher("find.jsp").forward(request,response);


    }
}
