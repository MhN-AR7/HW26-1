## Library Book Manager

Scenario
You are building a small web application for a library to manage book information. The library has a
predefined set of books. Each book has: Id, Title, Author, Category, Price.
Requirements
1. Book entity with proper encapsulation.
2. Shared repository with at l east 5 books from different categories and prices.
3. Layered architecture: Repository, Service, Servlet.
4. Views:
   o /books → all books (id, title, author, category,
   o /books?category=Programming → only books matching the query parameter
   o /books/add (GET) → f orm to add a book (POST to same URL to save)
5. ServletConfig: init param maxBooks=50 for AddBookServlet; read and print in init().
6. All output generated from Java code. No HTML files.
7. Use simple for loops (no streams).
8. Form fields: label, input type="text" na me="title" required, name="author" required,
   name="category" required, name="price" required, button type="submit".