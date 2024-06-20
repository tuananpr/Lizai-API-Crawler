package Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Permissions {
    private String group;
    private String name;
    private Functions functions;

    // tương tự qua mấy tg kia cũng vậy

}
