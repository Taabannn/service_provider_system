package ir.maktab58.data.dto;

import ir.maktab58.data.enums.UserStatus;

import java.util.Date;

/**
 * @author Taban Soleymani
 */
public class ExpertDTO {
    String username;
    String email;
    double score;
    UserStatus userStatus;
    Date firstAccess;
}
