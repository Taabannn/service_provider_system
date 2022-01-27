package ir.maktab58.service.mapper.Impl;

import ir.maktab58.data.entities.Wallet;
import ir.maktab58.dto.WalletDto;
import ir.maktab58.service.mapper.interfaces.WalletMapper;
import org.springframework.stereotype.Component;

/**
 * @author Taban Soleymani
 */
@Component
public class WalletMapperImpl implements WalletMapper {
    @Override
    public Wallet toWallet(WalletDto walletDto) {
        return Wallet.builder()
                .withWallet(walletDto.getWallet())
                .withLastUpdate(walletDto.getLastUpdate()).build();
    }

    @Override
    public WalletDto toWalletDto(Wallet wallet) {
        return WalletDto.builder()
                .withWallet(wallet.getWallet())
                .withLastUpdate(wallet.getLastUpdate()).build();
    }
}
