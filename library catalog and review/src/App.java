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
            ResultSet bookName = stmt.executeQuery("SELECT book_name FROM book_list;");
            //ResultSet review = stmt.executeQuery("SELECT review FROM book_list;");
            
            while (bookName.next()) {
                System.out.println("Book: " + bookName.getString("book_name")); 
                        //+ "\nReview: " + review.getString("review") + "\n");
            }

            con.close();
        }
    
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
