package ir.maktabsharif.servlet;

import ir.maktabsharif.exception.CountLimitException;
import ir.maktabsharif.repository.BookRepo;
import ir.maktabsharif.service.BookService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

public class AddBookServlet extends HttpServlet {
    private BookService service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        System.out.println("Max Books: " + config.getInitParameter("maxBooks"));

        service = new BookService((BookRepo) config.getServletContext().getAttribute("bookRepo"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        out.println("""
                <html>
                <head>
                    <title>add book</title>
                </head>
                <body>
                <h1>
                    Adding Book
                </h1>
                <form method="post" action="./add">
                    <label>Title:
                        <input type="text" name="title" required>
                    </label><br>
                    <label>Author:
                        <input type="text" name="author" required>
                    </label><br>
                    <label>Category:
                        <input type="text" name="category" required>
                    </label><br>
                    <label>Price:
                        <input type="text" name="price" required>
                    </label><br>
                    <br>
                    <button type="submit">Add</button>
                
                </form>
                
                <br>
                
                <a href="./books">All Books</a>
                </body>
                </html>
                """);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String category = req.getParameter("category");
        String price = req.getParameter("price");

        try {
            service.register(title, author, category, new BigDecimal(price), Integer.parseInt(getServletConfig().getInitParameter("maxBooks")));
            resp.sendRedirect(req.getContextPath() + "/books");
        }
        catch (CountLimitException e) {
            PrintWriter out = resp.getWriter();

            out.println("""
                    <html>
                    <body>
                    <p>
                    """);
            out.println(e.getMessage());
            out.println("""
                    </p>
                    <a href="./books">All Books</a>
                    </body>
                    </html>
                    """);
        }
    }
}
