package ir.maktab58.dto.users;

import ir.maktab58.service.validation.OnLogin;
import ir.maktab58.service.validation.OnRegister;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author Taban Soleymani
 */
@Data
@NoArgsConstructor
@ToString
public class ManagerDto extends UserDto {

    @Builder(setterPrefix = "with")
    public ManagerDto(@Size(min = 2, max = 20, message = "firstName should consist of 2-20 characters", groups = OnRegister.class) String firstName, @Size(min = 2, max = 20, message = "lastName should consist of 2-20 characters", groups = OnRegister.class) String lastName, @NotBlank(message = "username should not be empty", groups = OnLogin.class) @Pattern(regexp = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$", message = "username length must be between 3-18", groups = OnRegister.class) String username, @NotBlank(message = "password should not be empty", groups = OnLogin.class) @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,20}$", message = "password length must be between 8-20", groups = OnRegister.class) String password, @NotBlank(message = "email should not be empty", groups = OnLogin.class) @Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", message = "email should be like xxxxx@example.com", groups = OnRegister.class) String email, Date firstAccess, Date lastUpdate) {
        super(firstName, lastName, username, password, email, firstAccess, lastUpdate);
    }
}
