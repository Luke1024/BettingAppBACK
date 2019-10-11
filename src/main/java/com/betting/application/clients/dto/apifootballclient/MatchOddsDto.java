package com.betting.application.clients.dto.apifootballclient;

import com.betting.application.domain.dto.OddsDto;

import java.util.List;

public class MatchOddsDto {
    private Long match_id;
    private List<OddsDto> oddsDtos;

    public MatchOddsDto(){}

    public MatchOddsDto(Long match_id, List<OddsDto> oddsDtos) {
        this.match_id = match_id;
        this.oddsDtos = oddsDtos;
    }

    public Long getMatch_id() {
        return match_id;
    }

    public List<OddsDto> getOddsDtos() {
        return oddsDtos;
    }
}
