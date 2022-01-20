package ir.maktab58.data.dto.services;

import ir.maktab58.data.dto.users.ExpertDto;
import lombok.*;

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
    private String subServiceDescription;
    private long basePrice;
    private MainServiceDto mainService;
    Set<ExpertDto> expertDtoSet;
}
