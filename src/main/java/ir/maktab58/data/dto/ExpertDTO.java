package ir.maktab58.data.dto;

import ir.maktab58.data.models.enums.UserStatus;
import ir.maktab58.data.models.services.SubService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
