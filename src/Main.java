import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "1111";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Connection connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
        while (true){
            System.out.println("1. Показать список участников");
            System.out.println("2. Изменить данные участников");
            System.out.println("3. Создать нового участника");
            System.out.println("4. Удалить участника");
            System.out.println("4. Выйти");
            int command = scanner.nextInt();

            if (command == 1) {
                Statement statement = connection.createStatement();
                String SQL_SELECT = "SELECT * FROM participants";
                ResultSet rs = statement.executeQuery(SQL_SELECT);

                while (rs.next()) {
                    System.out.println("Id: " + rs.getInt("id") + "Name: " + rs.getString("name") + " Age: " + rs.getInt("age"));
                }
            }
        }
    }
}