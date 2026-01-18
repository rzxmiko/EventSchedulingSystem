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
            System.out.println("5. Выйти");
            int command = scanner.nextInt();

            if (command == 1) {
                Statement statement = connection.createStatement();
                String SQL_SELECT = "SELECT * FROM participants";
                ResultSet rs = statement.executeQuery(SQL_SELECT);

                while (rs.next()) {
                    System.out.println("Id: " + rs.getInt("id") + " Name: " + rs.getString("name") + " Age: " + rs.getInt("age"));
                }
            }
            else if(command == 2){
                System.out.print("Введите id участника:");
                int id = scanner.nextInt();
                System.out.print("Введите новый возраст: ");
                int newAge = scanner.nextInt();

                String SQL_UPDATE = "update participants set age = ? where id = ?";
                PreparedStatement pstmt = connection.prepareStatement(SQL_UPDATE);
                pstmt.setInt(1, newAge);
                pstmt.setInt(2,id);
                pstmt.executeUpdate();
            }
            else if(command == 3){
                System.out.println("Введите имя: ");
                String name = scanner.next();
                System.out.println("Введите возраст: ");
                int age = scanner.nextInt();

                String SQL_INSERT = "insert into participants(name, age) values (?,?)";
                PreparedStatement pstmt = connection.prepareStatement(SQL_INSERT);
                pstmt.setString(1,name);
                pstmt.setInt(2,age);
                pstmt.executeUpdate();
            }
            else if(command == 4){
                System.out.println("Введите id участника для удаления: ");
                int id = scanner.nextInt();

                String SQL_DELETE = "delete from participants where id = ?";
                PreparedStatement pstmt = connection.prepareStatement(SQL_DELETE);
                pstmt.setInt(1,id);
                pstmt.executeUpdate();
            }
            else if (command == 5){
                connection.close();
                break;
            }
        }
    }
}