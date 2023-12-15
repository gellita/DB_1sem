import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DBConnection {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String password = "968683";
    private Connection connection;

    public Connection connect() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Соединение установлено");
        }
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Соединение закрыто");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при закрытии соединения: " + e.getMessage());
        }
    }

    public void insertion(String lastName, String firstName, String patronymic,
                          String birthDate, String profession, String nationality,
                          String phoneNumber, String emailAddress) {
        try {
            connect();
            String query = "INSERT INTO users (last_name, first_name, patronymic, birth_date, profession, nationality, phone_number, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, lastName);
            statement.setString(2, firstName);
            statement.setString(3, patronymic);


            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date parsedDate = dateFormat.parse(birthDate);


            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());

            statement.setDate(4, sqlDate);
            statement.setString(5, profession);
            statement.setString(6, nationality);
            statement.setString(7, phoneNumber);
            statement.setString(8, emailAddress);
            statement.executeUpdate();
            System.out.println("Пользователь добавлен в базу данных.");
        } catch (SQLException | ParseException e) {
            System.err.println("Ошибка при добавлении пользователя: " + e.getMessage());
        } finally {
            closeConnection();
        }
    }
}
