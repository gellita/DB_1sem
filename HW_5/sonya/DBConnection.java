import javax.sql.DataSource;
import java.sql.*;

public class DBConnection {
    private final DataSource dataSource;
    private final static String SQL_INSERT = "insert into users(surname, name, patronymic, birthdate, profession, nationality, phone_number, email) values (?, ?, ?, ?, ?, ?, ?, ?)";

    public DBConnection(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void save(User person){
        try(Connection connection = dataSource.getConnection()){
            try (PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, person.getSurname());
                statement.setString(2, person.getName());
                statement.setString(5, person.getPatronymic());
                statement.setDate(6, Date.valueOf(person.getBirthdate()));
                statement.setString(7, person.getProfession());
                statement.setString(8, person.getNationality());
                statement.setString(9, person.getPhone());
                statement.setString(10, person.getEmail());

                int affectedRows = statement.executeUpdate();

                if (affectedRows != 1) {
                    throw new SQLException("Cannot insert course");
                }
                try (ResultSet generatedIds = statement.getGeneratedKeys()){
                    if (generatedIds.next()) {
                        person.setId(generatedIds.getInt("id"));
                    } else {
                        throw new SQLException("Cannot retrieve id");
                    }
                }
            }

        } catch (SQLException e){
            throw new IllegalStateException(e);
        }
    }
}
