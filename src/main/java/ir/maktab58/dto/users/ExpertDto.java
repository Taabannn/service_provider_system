package ir.maktab58.dto.users;

import ir.maktab58.dto.ExpertSubServiceDto;
import ir.maktab58.dto.ImageFileDto;
import ir.maktab58.dto.services.SubServiceDto;
import ir.maktab58.dto.WalletDto;
import ir.maktab58.data.enums.UserStatus;
import ir.maktab58.service.validation.OnLogin;
import ir.maktab58.service.validation.OnRegister;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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

    private WalletDto walletDto = WalletDto.builder().build();

    private ImageFileDto imageFileDto;

    private Set<ExpertSubServiceDto> expertSubServiceDtoSet = new HashSet<>();

    @Builder(setterPrefix = "with")
    public ExpertDto(@Size(min = 2, max = 20, message = "firstName should consist of 2-20 characters", groups = OnRegister.class) String firstName, @Size(min = 2, max = 20, message = "lastName should consist of 2-20 characters", groups = OnRegister.class) String lastName, @NotBlank(message = "username should not be empty", groups = OnLogin.class) @Pattern(regexp = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$", message = "username length must be between 3-18", groups = OnRegister.class) String username, @NotBlank(message = "password should not be empty", groups = OnLogin.class) @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,20}$", message = "password length must be between 8-20", groups = OnRegister.class) String password, @NotBlank(message = "email should not be empty", groups = OnLogin.class) @Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", message = "email should be like xxxxx@example.com", groups = OnRegister.class) String email, Date firstAccess, Date lastUpdate, UserStatus userStatus, Double score, WalletDto walletDto, ImageFileDto imageFileDto, Set<ExpertSubServiceDto> expertSubServiceDtoSet) {
        super(firstName, lastName, username, password, email, firstAccess, lastUpdate);
        this.userStatus = userStatus;
        this.score = score;
        this.walletDto = walletDto;
        this.imageFileDto = imageFileDto;
        this.expertSubServiceDtoSet = expertSubServiceDtoSet;
    }
}
