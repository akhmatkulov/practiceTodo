package uz.pdp.home_task.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id = idGen++;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
    private static Integer idGen = 1;

}
