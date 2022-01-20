package ir.maktab58.data.dto.users;

import ir.maktab58.data.dto.AddressDto;
import ir.maktab58.data.dto.WalletDto;
import ir.maktab58.data.enums.UserStatus;
import lombok.*;

import java.util.*;

/**
 * @author Taban Soleymani
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDto extends UserDto {
    private UserStatus userStatus;
    private WalletDto wallet;
    private Set<AddressDto> addressDtoList = new HashSet<>();

    @Builder(setterPrefix = "with")
    public CustomerDto(String firstName, String lastName, String username, String password, String email, Date firstAccess, Date lastUpdate, UserStatus userStatus, WalletDto wallet, Set<AddressDto> addressDtoList) {
        super(firstName, lastName, username, password, email, firstAccess, lastUpdate);
        this.userStatus = userStatus;
        this.wallet = wallet;
        this.addressDtoList = addressDtoList;
    }
}
