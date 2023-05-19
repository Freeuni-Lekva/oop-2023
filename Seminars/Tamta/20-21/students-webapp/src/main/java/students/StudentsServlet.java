package students;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("student.jsp").forward(httpServletRequest, httpServletResponse);

    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        Student newStudent = new Student(
                httpServletRequest.getParameter("first-name"),
                httpServletRequest.getParameter("last-name"),
                Integer.parseInt(httpServletRequest.getParameter("year"))
        );

        getStore(httpServletRequest).add(newStudent);
        httpServletResponse.sendRedirect("/student");
    }

    private StudentsDao getStore(HttpServletRequest request){
        return (StudentsDao) request.getServletContext().getAttribute("store");
    }
}
