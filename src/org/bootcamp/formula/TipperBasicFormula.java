package org.bootcamp.formula;

import org.bootcamp.vehicle.Vehicle;

public final class TipperBasicFormula implements Formula {
    @Override
    public int calculate(Vehicle vehicle) {
        int cost = vehicle.getAge() * 300;
        cost += vehicle.getNumberOfMiles() > 80000 ? 700 : 0;

        return cost;
    }
}
