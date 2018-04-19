package org.bootcamp.vehicle;

public final class Car extends Vehicle { //final ca sa nu mai poata extinde nimeni clasa
    private String transmission = "manual";

    public Car() {

    }

    public Car(int age, long numberOfMiles, boolean isDiesel) {
        super(age, numberOfMiles, isDiesel);
    }

    public Car(int age, long numberOfMiles, boolean isDiesel, String transmission) {
        super(age, numberOfMiles, isDiesel);
        this.transmission = transmission;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
}
