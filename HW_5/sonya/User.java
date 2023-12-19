import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {
    private Integer id;
    private String surname;
    private String name;
    private String patronymic;
    private Date birthdate;
    private String profession;
    private String nationality;
    private String phoneNumber;
    private String email;
}
