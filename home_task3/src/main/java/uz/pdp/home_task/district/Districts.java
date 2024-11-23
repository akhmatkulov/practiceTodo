package uz.pdp.home_task.district;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Districts {
    private Integer id = idGen++;
    private String name;
    private Integer regionId;
    private static Integer idGen = 1;
}
