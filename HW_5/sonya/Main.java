import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] name = {"a", "b", "c", "t", "h", "e", "j"};
        String[] surname = {"a", "b", "c", "t", "h", "e", "j"};
        String[] patronymic = {"a", "b", "c", "t", "h", "e", "j"};
        String[] profession = {"a", "b", "c", "t", "h", "e", "j"};
        String[] national = {"a", "b", "c", "t", "h", "e", "j"};

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        hikariConfig.setUsername("postgres");
        hikariConfig.setPassword("HateYou1");
        hikariConfig.setDriverClassName("org.postgresql.Driver");

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);

        DBConnection dbConnection = new DBConnection(dataSource);
        Random random = new Random();

        for (int i = 0; i < 1000; i++){
            User user = User.builder()
                    .surname(surname[random.nextInt(surname.length)])
                    .name(name[random.nextInt(name.length)])
                    .patronymic(patronymic[random.nextInt(patronymic.length)])
                    .birthdate(generateRandomDate())
                    .profession(profession[random.nextInt(profession.length)])
                    .nationality(national[random.nextInt(national.length)])
                    .phoneNumber(generateRandomPhoneNumber())
                    .email(generateRandomEmail(name, surname))
                    .build();
            dbConnection.save(user);

        }
    }
    private static String generateRandomDate() {
        Random random = new Random();
        int year = random.nextInt(30) + 1970; // Generate a year between 1970 and 2000
        int month = random.nextInt(12) + 1;
        int day = random.nextInt(28) + 1;
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    private static String generateRandomPhoneNumber() {
        Random random = new Random();
        StringBuilder phoneNumber = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            phoneNumber.append(random.nextInt(10));
        }

        return phoneNumber.toString();
    }
    private static String generateRandomEmail(String name, String surname){
        Random random = new Random();
        String[] emailProviders = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com", "aol.com"};
        String email = name.toLowerCase() + "." + surname.toLowerCase() + random.nextInt(1000) + "@" + emailProviders[random.nextInt(emailProviders.length)];
        return email;
    }
}