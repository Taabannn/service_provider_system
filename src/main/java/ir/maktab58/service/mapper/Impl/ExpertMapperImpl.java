package ir.maktab58.service.mapper.Impl;

import ir.maktab58.data.entities.users.Expert;
import ir.maktab58.dto.users.CustomerDto;
import ir.maktab58.dto.users.ExpertDto;
import ir.maktab58.service.mapper.interfaces.ExpertMapper;
import ir.maktab58.service.mapper.interfaces.WalletMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Taban Soleymani
 */
@Component
public class ExpertMapperImpl implements ExpertMapper {
    @Autowired
    private WalletMapper walletMapper;

    @Override
    public Expert toExpert(ExpertDto expertDto) {
        return Expert.builder()
                .withFirstName(expertDto.getFirstName())
                .withLastName(expertDto.getLastName())
                .withUsername(expertDto.getUsername())
                .withPassword(expertDto.getPassword())
                .withEmail(expertDto.getEmail())
                .withFirstAccess(expertDto.getFirstAccess())
                .withLastUpdate(expertDto.getLastUpdate())
                .withUserStatus(expertDto.getUserStatus())
                .withWallet(walletMapper.toWallet(expertDto.getWalletDto()))
                .build();
    }

    @Override
    public ExpertDto toExpertDto(Expert expert) {
        return ExpertDto.builder()
                .withFirstName(expert.getFirstName())
                .withLastName(expert.getLastName())
                .withUsername(expert.getUsername())
                .withPassword(expert.getPassword())
                .withEmail(expert.getEmail())
                .withFirstAccess(expert.getFirstAccess())
                .withLastUpdate(expert.getLastUpdate())
                .withUserStatus(expert.getUserStatus())
                .withWalletDto(walletMapper.toWalletDto(expert.getWallet())).build();
    }
}
