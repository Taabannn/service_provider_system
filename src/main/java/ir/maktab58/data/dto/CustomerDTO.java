package ir.maktab58.data.dto;

import ir.maktab58.data.enums.UserStatus;
import lombok.*;

import java.util.Date;

/**
 * @author Taban Soleymani
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CustomerDTO {
    String username;
    String Email;
    long Credit;
    UserStatus userStatus;
    Date firstAccess;
}
