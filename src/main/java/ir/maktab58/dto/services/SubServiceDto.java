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
    @NotBlank(message = "subServiceDescription should not be empty")
    private String subServiceDescription;

    private long basePrice;

    @NotNull(message = "mainService could not be null")
    private MainServiceDto mainService;

    Set<ExpertSubServiceDto> expertSubServiceDtoSet;
}
