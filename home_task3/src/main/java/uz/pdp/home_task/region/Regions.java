package uz.pdp.home_task.region;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Regions {
    private Integer id = idGen++;
    private String name;
    private Integer countryId;
    private static Integer idGen = 1;
}
