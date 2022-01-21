package ir.maktab58.dto.users;

import lombok.*;

import java.util.Date;

/**
 * @author Taban Soleymani
 */
@Data
@NoArgsConstructor
@ToString
public class ManagerDto extends UserDto {

    @Builder(setterPrefix = "with")
    public ManagerDto(String firstName, String lastName, String username, String password, String email, Date firstAccess, Date lastUpdate) {
        super(firstName, lastName, username, password, email, firstAccess, lastUpdate);
    }
}
