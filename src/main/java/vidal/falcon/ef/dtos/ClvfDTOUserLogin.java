package vidal.falcon.ef.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClvfDTOUserLogin {
    private String userName;
    private String password;
    private String role;
}
