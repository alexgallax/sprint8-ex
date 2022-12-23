package sprint8ex;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Courier {

    private String login;
    private String password;
    private String firstName;
}
