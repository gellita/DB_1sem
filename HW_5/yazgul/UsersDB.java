import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDB {
    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String user = "postgres";
    private String password = "1111";

    private Connection connection;

    public UsersDB() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        }
        catch (SQLException e) {
            System.err.println("Ошибка подключения: " + e.getMessage());
        }
    }
    public void closeConnection() {
        try {
            if (connection != null & !connection.isClosed()) {
                connection.close();
                System.out.println("Соединение закрыто.");
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при закрытии соединения: " + e.getMessage());
        }
    }

    public void insertUser(String lastName, String firstName, String middleName, String dateOfBirth, String profession, String nationality, String phoneNumber, String email) {
        try {
            String query = "INSERT INTO users (last_name, first_name, middle_name, date_of_birth, profession, nationality, phone_number, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, lastName);
            statement.setString(2, firstName);
            statement.setString(3, middleName);
            statement.setDate(4, java.sql.Date.valueOf(dateOfBirth));
            statement.setString(5, profession);
            statement.setString(6, nationality);
            statement.setString(7, phoneNumber);
            statement.setString(8, email);
            statement.executeUpdate();
            System.out.println("Пользователь добавлен в базу данных.");
        } catch (SQLException e) {
            System.err.println("Ошибка при добавлении пользователя: " + e.getMessage());
        }
    }
    public void listOfUsers() {
        try {
            String query = "SELECT * FROM users";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String lastName = resultSet.getString("last_name");
                String firstName = resultSet.getString("first_name");
                String middleName = resultSet.getString("middle_name");
                String dateOfBirth = resultSet.getDate("date_of_birth").toString();
                String profession = resultSet.getString("profession");
                String nationality = resultSet.getString("nationality");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
//                System.out.println("Фамилия: " + lastName + ", Имя: " + firstName + ", Дата рождения: " + dateOfBirth);
                System.out.print("Фамилия: " + lastName);
                System.out.print(", ");
                System.out.print("Имя: " + firstName);
                System.out.print(", ");
                System.out.print("Отчество: " + middleName);
                System.out.print(", ");
                System.out.print("Дата рождения: " + dateOfBirth);
                System.out.print(", ");
                System.out.print("Профессия: " + profession);
                System.out.print(", ");
                System.out.print("Национальность: " + nationality);
                System.out.print(", ");
                System.out.print("Номер телефона: " + phoneNumber);
                System.out.print(", ");
                System.out.print("Email: " + email);
                System.out.println();
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при выполнении запроса: " + e.getMessage());
        }
    }

}