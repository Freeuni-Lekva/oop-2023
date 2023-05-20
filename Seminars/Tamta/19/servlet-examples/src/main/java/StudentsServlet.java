import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class StudentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html");
        PrintWriter writer = httpServletResponse.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<link rel=\"icon\" href=\"https://love2dev.com/img/2000px-instagram_logo_2016svg-2000x2000.png\"");
        writer.println("<meta charset=\"utf-8\" />");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<div class=\"container\">");
        writer.println("<form id='form' action=\"/student\" method=\"post\">\n");
        writer.println("<input type=\"text\" placeholder=\"First Name\" name=\"first-name\" />");
        writer.println("<input type=\"text\" placeholder=\"Last Name\" name=\"last-name\" />");
        writer.println("<input type=\"text\" placeholder=\"Year\" name=\"year\" />");
        writer.println("<input type=\"submit\" value=\"Add student\" id=\"add-student\" />");
        writer.println("</form>");
        writer.println("<table class=\"table\" id=\"student-table\">");
        writer.println("<tr>");
        writer.println("<th>First name</th>");
        writer.println("<th>Last name</th>");
        writer.println("<th>Year</th>");
        writer.println("</tr>");

        List<Student> students = getStore(httpServletRequest).getAll();

        for (Student student: students){
            writer.println("<tr>");
            writer.println("<td>" + student.getFirstName() +"</td>");
            writer.println("<td>" + student.getLastName() +"</td>");
            writer.println("<td>" + student.getEnrollmentYear() +"</td>");
            writer.println("</tr>");
        }

        writer.println("</table>");
        writer.println("</div>");
        writer.println("</body>");
        writer.println("</html>");
        writer.close();

    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        Student newStudent = new Student(
                httpServletRequest.getParameter("first-name"),
                httpServletRequest.getParameter("last-name"),
                Integer.parseInt(httpServletRequest.getParameter("year"))
        );

        getStore(httpServletRequest).add(newStudent);
        httpServletResponse.sendRedirect("/student");
    }

    private StudentsDao getStore(HttpServletRequest request){
        StudentsDao store = (StudentsDao) request.getServletContext().getAttribute("store");

        if (store == null) {
            store = new ArrayListStudentsDao();
            request.getServletContext().setAttribute("store", store);
            System.out.println("here");
        }

        return store;
    }
}
