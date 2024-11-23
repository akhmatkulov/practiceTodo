package uz.pdp.store_online.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private int id = genId++;
    private String name;
   private String username;
    private String password;
    private String email;
    private static Integer genId = 1;

}
