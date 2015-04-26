package com.hb.model;

import java.util.List;

public class Holiday {

    private Integer weather;
    private Integer daysToGo;
    private List<String> cards;

    public Holiday(Integer weather, Integer daysToGo, List<String> cards) {
        this.weather = weather;
        this.daysToGo = daysToGo;
        this.cards = cards;
    }

    public Integer getWeather() {
        return weather;
    }

    public Integer getDaysToGo() {
        return daysToGo;
    }

    public List<String> getCards() {
        return cards;
    }
}
