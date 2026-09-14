package ir.maktabsharif.servlet;

import ir.maktabsharif.model.Book;
import ir.maktabsharif.repository.BookRepo;
import ir.maktabsharif.service.BookService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AllBooksServlet extends HttpServlet {
    private BookService service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        service = new BookService((BookRepo) config.getServletContext().getAttribute("bookRepo"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books;

        String category = req.getParameter("category");

        if (category == null || category.isBlank()) books = service.getAll();
        else books = service.getByCategory(category);

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        out.println("""
                <html>
                <head>
                <title>Books</title>
                <style>
                        table {
                            border: 4px double #0004ff;
                            background-color: #c6e5ff;
                            border-collapse: collapse;
                            text-align: center;
                        }
                        th {
                                    border: 3px solid darkgreen;
                                    padding: 10px;
                        }
                        td {
                                    border: 2px dotted darkolivegreen;
                                    padding: 15px;
                        }
                    </style>
                </head>
                <body>
                <h2>Books</h2>
                <table>
                <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Category</th>
                        <th>Price($)</th>
                    </tr>
                """);

        for (Book book : books) {
            out.println("<tr>");

            out.println("<td>");
            out.println(book.getId());
            out.println("</td>");

            out.println("<td>");
            out.println(book.getTitle());
            out.println("</td>");

            out.println("<td>");
            out.println(book.getAuthor());
            out.println("</td>");

            out.println("<td>");
            out.println(book.getCategory());
            out.println("</td>");

            out.println("<td>");
            out.println(book.getPrice());
            out.println("</td>");

            out.println("</tr>");
        }

        out.println("""
                </table>
                
                <br>
                
                <form>
                    <label>Search By Category
                        <input type="text" placeholder="Enter a Category" name="category" required>
                    </label>
                    <br>
                    <button type="submit">Search</button>
                </form>
                
                <br>
                
                <a href="./books">All Book</a>
                <br>
                <a href="./add">Add Book</a>
                
                </body>
                </html>
                """);
    }
}
