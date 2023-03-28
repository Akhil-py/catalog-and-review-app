import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            // Establish a connection to MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", 
                    "root", 
                    "root");
            Statement stmt = con.createStatement();

            // Execute query
            ResultSet bookList = stmt.executeQuery("SELECT * FROM book_list;"); 
            //System.out.println(bookList.toString());

            while (bookList.next()) {
                String recommended;
                if (bookList.getString("recommend?").equals("1")) {
                    recommended = "This book is a good read and is recommended";
                }
                else {
                    recommended = "This book is not recommended";
                }
                
                System.out.println("Book Name: " + bookList.getString("book_name") + 
                        "\nSeries: " + bookList.getString("series") + 
                        "\nAuthor: " + bookList.getString("author") +
                        "\nReview: " + bookList.getString("review") + 
                        "\n" + recommended + "\n");
            }

            con.close();
        }
    
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
