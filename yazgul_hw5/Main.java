import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Main {
    public static void main(String[] args) {

        UsersDB usersDB = new UsersDB();
        Faker faker = new Faker();
        for (int i = 0; i < 1000; i++) {
            String lastName = faker.name().lastName();
            String firstName = faker.name().firstName();
            String middleName = faker.name().lastName();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateOfBirth = dateFormat.format(faker.date().birthday(18, 65));
            String profession = faker.job().title();
            String nationality = faker.nation().nationality();
            String phoneNumber = faker.phoneNumber().cellPhone();
            String email = faker.internet().emailAddress();

            usersDB.insertUser(lastName, firstName, middleName, dateOfBirth, profession, nationality, phoneNumber, email);
        }

        usersDB.listOfUsers();

        usersDB.closeConnection();

    }

}
