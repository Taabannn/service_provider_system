package ir.maktab58.data.dto.users;

import ir.maktab58.data.dto.SubServiceDto;
import ir.maktab58.data.dto.WalletDto;
import ir.maktab58.data.enums.UserStatus;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private List<SubServiceDto> subServiceDtoList = new ArrayList<>();
    private byte[] image;

    @Builder(setterPrefix = "with")
    public ExpertDto(String firstName, String lastName, String username, String password, String email, Date firstAccess, Date lastUpdate, UserStatus userStatus, Double score, WalletDto walletDto, List<SubServiceDto> subServiceDtoList, byte[] image) {
        super(firstName, lastName, username, password, email, firstAccess, lastUpdate);
        this.userStatus = userStatus;
        this.score = score;
        this.walletDto = walletDto;
        this.subServiceDtoList = subServiceDtoList;
        this.image = image;
    }
}
