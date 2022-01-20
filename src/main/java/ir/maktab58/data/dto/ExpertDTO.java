package ir.maktab58.data.dto;

import ir.maktab58.data.enums.UserStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Taban Soleymani
 */
public class ExpertDTO {
    String username;
    String email;
    Double score;
    UserStatus userStatus;
    Date firstAccess;
    Date lastUpdate;
    List<SubServiceDto> subServiceDtoList = new ArrayList<>();
    byte[] image;
}
