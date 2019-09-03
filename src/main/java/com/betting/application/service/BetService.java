package com.betting.application.service;

import com.betting.application.domain.Bet;
import com.betting.application.domain.SportEvent;
import com.betting.application.domain.User;
import com.betting.application.domain.dto.BetPlacerDto;
import com.betting.application.repository.BetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BetService {
    @Autowired
    private BetRepository betRepository;

    @Autowired
    private SportEventService sportEventService;

    @Autowired
    private UserService userService;

    public List<Bet> getUserBets(Long id){
        return userService.getUser(id).get().getBets();
    }

    public List<Bet> getUserArchivedBets(Long id){
        return userService.getUser(id).get().getBets().stream().filter(bet -> bet.isArchived()==true)
                .collect(Collectors.toList());
    }

    public void saveBet(BetPlacerDto betPlacerDto){
        Optional<SportEvent> sportEvent = sportEventService.getSportEvent(betPlacerDto.getMatchId());
        Optional<User> user = userService.getUser(betPlacerDto.getUserId());
        if(sportEvent.isPresent()){
            betRepository.save(new Bet(user.get(), sportEvent.get(), betPlacerDto.getAmount(), betPlacerDto.getResult()));
        }
    }

    public void deleteBets(Long betId){
        betRepository.deleteById(betId);
    }

    public void unarchiveBets(Long betId){
        Optional<Bet> bet = betRepository.findById(betId);
        if(bet.isPresent()){
            bet.get().setArchived(false);
            betRepository.save(bet.get());
        } else {}
    }
}
