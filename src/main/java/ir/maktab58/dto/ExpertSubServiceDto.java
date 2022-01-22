package ir.maktab58.dto;

import ir.maktab58.dto.services.SubServiceDto;
import ir.maktab58.dto.users.ExpertDto;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Taban Soleymani
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(setterPrefix = "with")
public class ExpertSubServiceDto {
    @NotNull(message = "subService should not be null")
    private SubServiceDto subServiceDto;

    @NotNull(message = "expert should not be null")
    private ExpertDto expertDto;

    private Date creationDate;
}
