package ir.maktab58.dto.services;

import ir.maktab58.dto.ExpertSubServiceDto;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * @author Taban Soleymani
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(setterPrefix = "with")
public class SubServiceDto {
    @NotBlank(message = "should not be empty")
    private String subServiceDescription;

    private long basePrice;

    @NotNull(message = "not null")
    private MainServiceDto mainService;

    @NotNull(message = "not null")
    Set<ExpertSubServiceDto> expertSubServiceDtoSet;
}
