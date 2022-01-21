package ir.maktab58.dto;

import ir.maktab58.dto.services.SubServiceDto;
import ir.maktab58.dto.users.ExpertDto;

import javax.validation.constraints.NotNull;

/**
 * @author Taban Soleymani
 */
public class ExpertSubServiceDto {
    @NotNull(message = "subService should not be null")
    private SubServiceDto subServiceDto;

    @NotNull(message = "expert should not be null")
    private ExpertDto expertDto;
}
