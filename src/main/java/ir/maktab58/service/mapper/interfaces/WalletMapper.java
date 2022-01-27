package ir.maktab58.service.mapper.interfaces;

import ir.maktab58.data.entities.Wallet;
import ir.maktab58.dto.WalletDto;
import org.mapstruct.Mapper;

/**
 * @author Taban Soleymani
 */
@Mapper
public interface WalletMapper {
    Wallet toWallet(WalletDto walletDto);

    WalletDto toWalletDto(Wallet wallet);
}
