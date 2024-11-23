package uz.pdp.home_task.country;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Countries {
    private Integer id = idGen++;
    private String name;
    private static Integer idGen = 1;
}
