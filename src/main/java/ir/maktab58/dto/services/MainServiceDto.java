package ir.maktab58.dto.services;

import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * @author Taban Soleymani
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(setterPrefix = "with")
public class MainServiceDto {
    @NotBlank(message = "should not be empty")
    private String field;
}
