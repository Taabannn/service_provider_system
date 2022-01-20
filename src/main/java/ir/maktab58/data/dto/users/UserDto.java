package ir.maktab58.data.dto.users;

import lombok.*;

import java.util.Date;

/**
 * @author Taban Soleymani
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class UserDto {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private Date firstAccess;
    private Date lastUpdate;
}
