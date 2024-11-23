package uz.pdp.practicetodo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDo {
    private Integer id = idGen++;
    private String text;
    private Boolean completed;
    private static Integer idGen = 1;

    public ToDo(String text, Boolean completed) {
        this.text = text;
        this.completed = completed;
    }
}
