package org.bootcamp;

public class InsurancePolicyCalculator {

    public static final InsurancePolicyCalculator INSTANCE = new InsurancePolicyCalculator();

    private InsurancePolicyCalculator() {

    }

    public int calculate(Vehicle vehicle, Formula formula)
    {
        return formula.calculate(vehicle);
    }
}
