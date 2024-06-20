package Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Functions {
    private Integer type;
    private boolean enable;
    private boolean grantPermissions;
    private String level;
}
