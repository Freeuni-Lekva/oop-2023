package students;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        StudentsDao store = new ArrayListStudentsDao();
        servletContextEvent.getServletContext().setAttribute("store", store);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
