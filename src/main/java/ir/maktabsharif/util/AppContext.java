package ir.maktabsharif.util;

import ir.maktabsharif.repository.BookRepo;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public final class AppContext implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        BookRepo bookRepo = new BookRepo();

        ServletContext context = sce.getServletContext();

        context.setAttribute("bookRepo", bookRepo);
    }
}
