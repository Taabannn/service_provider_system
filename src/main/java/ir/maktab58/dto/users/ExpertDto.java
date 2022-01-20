package ir.maktab58.dto.users;

import ir.maktab58.dto.services.SubServiceDto;
import ir.maktab58.dto.WalletDto;
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
public class ExpertDto extends UserDto {
    private UserStatus userStatus;
    private Double score;
    private WalletDto walletDto;
    private Set<SubServiceDto> subServiceDtoList = new HashSet<>();
    private byte[] image;

    @Builder(setterPrefix = "with")
    public ExpertDto(String firstName, String lastName, String username, String password, String email, Date firstAccess, Date lastUpdate, UserStatus userStatus, Double score, WalletDto walletDto, Set<SubServiceDto> subServiceDtoList, byte[] image) {
        super(firstName, lastName, username, password, email, firstAccess, lastUpdate);
        this.userStatus = userStatus;
        this.score = score;
        this.walletDto = walletDto;
        this.subServiceDtoList = subServiceDtoList;
        this.image = image;
    }
}
