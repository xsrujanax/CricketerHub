package org.CricketerHub;

// ..........................................
// Assignment # 0!
// © Srujana Guttula
// Written by: Srujana Guttula - 40237663
// ..........................................
public class Cricketer {

    private static int numberOfCricketers = 0;
    long cricketerId;
    String cricketerName;
    float battingAvg;
    float bowlingAvg;
    float strikeRate;
    float economyRate;
    boolean isAvailable;

    public Cricketer() {
        this.cricketerId = 0;
        this.cricketerName = "";
        this.battingAvg = 0.0F;
        this.bowlingAvg = 0.0F;
        this.strikeRate = 0.0F;
        this.economyRate = 0.0F;
        this.isAvailable = false;
        numberOfCricketers++;
    }

    public long getCricketerId() {
        return cricketerId;
    }

    public void setCricketerId(long cricketerId) {
        this.cricketerId = cricketerId;
    }

    public String getCricketerName() {
        return cricketerName;
    }

    public void setCricketerName(String cricketerName) {
        this.cricketerName = cricketerName;
    }

    public float getBattingAvg() {
        return battingAvg;
    }

    public void setBattingAvg(float battingAvg) {
        this.battingAvg = battingAvg;
    }

    public float getBowlingAvg() {
        return bowlingAvg;
    }

    public void setBowlingAvg(float bowlingAvg) {
        this.bowlingAvg = bowlingAvg;
    }

    public float getStrikeRate() {
        return strikeRate;
    }

    public void setStrikeRate(float strikeRate) {
        this.strikeRate = strikeRate;
    }

    public float getEconomyRate() {
        return economyRate;
    }

    public void setEconomyRate(float economyRate) {
        this.economyRate = economyRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    /**
     * @return no of cricketer objects have been created.
     */
    public static int getNumberOfCricketers(){
        return numberOfCricketers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cricketer)) return false;
        Cricketer cricketer = (Cricketer) o;
        return cricketerId == cricketer.cricketerId && isAvailable == cricketer.isAvailable;
    }
    @Override
    public String toString() {
        return  "ID: " + cricketerId +
                "Name: " + cricketerName + '\'' +
                "Batting Average: " + battingAvg +
                "Bowling Average: " + bowlingAvg +
                "Strike Rate: " + strikeRate +
                "Economy Rate: " + economyRate +
                "Availability: " + (isAvailable?"isAvailable":"notAvailable");
    }

    public static void findCricketersBy(){

    }

    public static void findAllRounders(){

    }
}
