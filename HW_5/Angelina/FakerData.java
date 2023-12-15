import net.datafaker.Faker;

import java.util.Locale;

public class FakerData {
    public static void main(String[] args) {
        DBConnection dbConnection = new DBConnection();
        Locale locale = new Locale("ru");
        Faker faker = new Faker(locale);
        for (int i = 0; i < 1000; i++) {
            String FIO = faker.name().nameWithMiddle();
            String[] parts = FIO.split(" ");

            String lastName = parts[2];
            String firstName = parts[0];
            String patronymic = parts[1];
            String birthDate = faker.date().birthday(18, 99, "dd/MM/YYYY");
            String profession = faker.company().profession();
            String nationality = faker.nation().nationality();
            String phoneNumber = faker.phoneNumber().phoneNumber();
            String emailAddress = faker.internet().emailAddress(firstName.toLowerCase() + lastName.toLowerCase());

            dbConnection.insertion(lastName, firstName, patronymic, birthDate, profession, nationality, phoneNumber, emailAddress);
        }
    }
}