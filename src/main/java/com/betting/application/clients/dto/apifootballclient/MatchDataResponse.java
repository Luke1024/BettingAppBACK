package com.betting.application.clients.dto.apifootballclient;

public class MatchDataResponse {
    private String match_id;
    private String country_id;
    private String league_id;
    private String country_name;
    private String league_name;
    private String match_date;
    private String match_time;
    private String match_hometeam_name;
    private String match_awayteam_name;
    private String match_status;

    public MatchDataResponse() {}

    public MatchDataResponse(String match_id, String country_id, String league_id, String country_name, String league_name, String match_date, String match_time, String match_hometeam_name, String match_awayteam_name, String match_status) {
        this.match_id = match_id;
        this.country_id = country_id;
        this.league_id = league_id;
        this.country_name = country_name;
        this.league_name = league_name;
        this.match_date = match_date;
        this.match_time = match_time;
        this.match_hometeam_name = match_hometeam_name;
        this.match_awayteam_name = match_awayteam_name;
        this.match_status = match_status;
    }

    public String getMatch_id() {
        return match_id;
    }

    public String getCountry_id() {
        return country_id;
    }

    public String getLeague_id() {
        return league_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public String getLeague_name() {
        return league_name;
    }

    public String getMatch_date() {
        return match_date;
    }

    public String getMatch_time() {
        return match_time;
    }

    public String getMatch_hometeam_name() {
        return match_hometeam_name;
    }

    public String getMatch_awayteam_name() {
        return match_awayteam_name;
    }

    public String getMatch_status() {
        return match_status;
    }

    @Override
    public String toString() {
        return "MatchDataResponse{" +
                "match_id='" + match_id + '\'' +
                ", country_id='" + country_id + '\'' +
                ", league_id='" + league_id + '\'' +
                ", country_name='" + country_name + '\'' +
                ", league_name='" + league_name + '\'' +
                ", match_date='" + match_date + '\'' +
                ", match_time='" + match_time + '\'' +
                ", match_hometeam_name='" + match_hometeam_name + '\'' +
                ", match_awayteam_name='" + match_awayteam_name + '\'' +
                ", match_status='" + match_status + '\'' +
                '}';
    }
}
