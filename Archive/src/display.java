package Archive.src;

import java.sql.*;

public class display {
    public static void main(String arg[]) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", 
                    "root", 
                    "root");
            
            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("SELECT * FROM book_list");
            
            String bookName;
            String series;
            String author;
            String review;

            while (resultSet.next()) {
                bookName = resultSet.getString("book name");
                series = resultSet.getString("series");
                author = resultSet.getString("author");
                review = resultSet.getString("review");

                System.out.println(bookName + " by " + author + " part of the " + series + " series.\nReview: " + review + "\n");
            }

            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
