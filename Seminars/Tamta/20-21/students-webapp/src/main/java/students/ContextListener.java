package students;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setUrl("jdbc:mysql://localhost:3306/test_4");
        dataSource.setUsername("root");
        dataSource.setPassword("Tamtapass");

        StudentsDao store = new DbStudentsDao(dataSource);
        servletContextEvent.getServletContext().setAttribute("store", store);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
