package org.CricketerHub;

// ..........................................
// Assignment # 0!
// © Srujana Guttula
// Written by: Srujana Guttula - 40237663
// ..........................................

/**
 * The `Cricketer` class represents a cricketer's information.
 * It stores details like cricketer ID, name, batting and bowling averages, strike rate, economy rate, and availability.
 */
public class Cricketer {

    private static int numberOfCricketers = 0;
    long cricketerId;
    String cricketerName;
    float battingAvg;
    float bowlingAvg;
    float strikeRate;
    float economyRate;
    boolean isAvailable;

    /**
     * Default constructor for the `Cricketer` class.
     */
    public Cricketer() {
        this.cricketerId = 0;
        this.cricketerName = "";
        this.battingAvg = 0.0F;
        this.bowlingAvg = 0.0F;
        this.strikeRate = 0.0F;
        this.economyRate = 0.0F;
        this.isAvailable = false;
    }

    /**
     * Parameterized constructor for the `Cricketer` class.
     * @param cricketerId The unique identifier for the cricketer.
     * @param cricketerName The name of the cricketer.
     * @param battingAvg The batting average of the cricketer.
     * @param bowlingAvg The bowling average of the cricketer.
     * @param strikeRate The strike rate of the cricketer.
     * @param economyRate The economy rate of the cricketer.
     * @param isAvailable The availability status of the cricketer.
     */
    public Cricketer(long cricketerId, String cricketerName, float battingAvg, float bowlingAvg, float strikeRate, float economyRate, boolean isAvailable) {
        this.cricketerId = cricketerId;
        this.cricketerName = cricketerName;
        this.battingAvg = battingAvg;
        this.bowlingAvg = bowlingAvg;
        this.strikeRate = strikeRate;
        this.economyRate = economyRate;
        this.isAvailable = isAvailable;
        setNumberOfCricketers(numberOfCricketers);
    }

    // Getter and setter methods for class attributes
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
     * Static method to set the total number of cricketers.
     * @param numberOfCricketers The total number of cricketers.
     */
    public static void setNumberOfCricketers(int numberOfCricketers) {
        Cricketer.numberOfCricketers = numberOfCricketers+1;
    }

    /**
     * Static method to get the total number of cricketers created.
     * @return The total number of cricketers created.
     */
    public static int getNumberOfCricketers(){
        return numberOfCricketers;
    }

    /**
     * Checks if this cricketer object is equal to another object.
     * @param o The object to compare to this cricketer.
     * @return `true` if they are equal, `false` otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cricketer)) return false;
        Cricketer cricketer = (Cricketer) o;
        return cricketerId == cricketer.cricketerId && isAvailable == cricketer.isAvailable;
    }

    /**
     * Converts the cricketer object to a string representation.
     * @return A string representing the cricketer's information.
     */
    @Override
    public String toString() {
        return  "ID: " + cricketerId +
                "\nName: " + cricketerName +
                "\nBatting Average: " + battingAvg +
                "\nBowling Average: " + bowlingAvg +
                "\nStrike Rate: " + strikeRate +
                "\nEconomy Rate: " + economyRate +
                "\nAvailability: " + (isAvailable?"isAvailable":"notAvailable");
    }
}
