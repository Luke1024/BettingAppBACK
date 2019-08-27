package com.betting.application.domain.dto;

public class OddsDto {
    private double odd_1;
    private double odd_x;
    private double odd_2;

    public OddsDto(){}

    public OddsDto(double odd_1, double odd_x, double odd_2) {
        this.odd_1 = odd_1;
        this.odd_x = odd_x;
        this.odd_2 = odd_2;
    }

    public double getOdd_1() {
        return odd_1;
    }

    public double getOdd_x() {
        return odd_x;
    }

    public double getOdd_2() {
        return odd_2;
    }
}
