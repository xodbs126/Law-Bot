package com.example.law_bot.service;

import com.example.law_bot.DTO.ConsultResponseDTO;
import com.example.law_bot.DTO.CreateConsultDTO;
import com.example.law_bot.entity.Consult;
import com.example.law_bot.entity.User;
import com.example.law_bot.repository.ConsultRepository;
import com.example.law_bot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PlanServiceImpl implements PlanService {

    private final UserRepository userRepository;
    private final ConsultRepository consultRepository;

    @Override
    @Transactional
    public void createConsult(CreateConsultDTO dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 존재하지 않습니다."));


        if (user.getCoins() < 5) {
            throw new IllegalStateException("코인이 부족하여 상담을 등록할 수 없습니다.");
        }

        LocalDateTime consultTime = dto.getConsultTime().toLocalDate().atStartOfDay();

        Consult consult = new Consult();
        consult.setUser(user);
        consult.setContent(dto.getContent());
        consult.setConsultArea(dto.getConsultArea());
        consult.setConsultRange(dto.getConsultRange());
        consult.setConsultTime(consultTime);
        consult.setStatus(Consult.ConsultStatus.WAITING);

        user.setCoins(user.getCoins() - 5);

        consultRepository.save(consult);

    }

    @Override
    public List<ConsultResponseDTO> getAllConsults() {
        return consultRepository.findAll().stream()
                .map(ConsultResponseDTO::new)
                .toList();
    }
}
