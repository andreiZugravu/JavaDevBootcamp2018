package org.bootcamp;

import org.bootcamp.calculator.InsurancePolicyCalculator;
import org.bootcamp.dao.VehicleInfoPlainFileDao;
import org.bootcamp.formula.Formula;
import org.bootcamp.model.VehicleInfo;
import org.bootcamp.vehicle.Bus;
import org.bootcamp.vehicle.Car;
import org.bootcamp.vehicle.Tipper;
import org.bootcamp.vehicle.Vehicle;

import java.util.List;

public class MainApp {

    private static final InsurancePolicyCalculator calculator = InsurancePolicyCalculator.INSTANCE;

    private static final String OUTPUT_FORMAT = "Vehicle with id %s has total cost %d";

    public static void main(String[] args) {

        if(args.length >= 1) {
            final VehicleInfoPlainFileDao vehicleInfoDao = new VehicleInfoPlainFileDao(args[0]);

            final List<VehicleInfo> vehicleInfos = vehicleInfoDao.getAllVehicles();

            if (vehicleInfos.isEmpty()) {
                System.err.println("No records found");
                return;
            }
            else {
                for (VehicleInfo vehicleInfo : vehicleInfos) {
                    final Vehicle vehicle = getVehicle(vehicleInfo);

                    final Formula formula = Formula.valueOf(vehicleInfo.getVehicleTypeFormula());

                    final int totalCost = calculator.calculate(vehicle, formula);

                    final String output = String.format(OUTPUT_FORMAT, vehicleInfo.getId(), totalCost);

                    System.out.println(output);
                }
            }
        }
        else {
            System.out.println("No arguments!");
        }
    }

    private static Vehicle getVehicle(VehicleInfo vehicleInfo) {
        final String carClassName = Car.class.getSimpleName().toUpperCase(); //vine lower case by default, noi le avem upper in fisier
        final String busClassName = Bus.class.getSimpleName().toUpperCase();
        final String tipperClassName = Tipper.class.getSimpleName().toUpperCase();

        if (vehicleInfo.getVehicleTypeName().equals(carClassName)) {
            return new Car(vehicleInfo.getAge(), vehicleInfo.getNumberOfMiles(), vehicleInfo.isDiesel());
        }

        if (vehicleInfo.getVehicleTypeName().equals(busClassName)) {
            return new Car(vehicleInfo.getAge(), vehicleInfo.getNumberOfMiles(), vehicleInfo.isDiesel());
        }

        if(vehicleInfo.getVehicleTypeName().equals(tipperClassName)) {
            return new Car(vehicleInfo.getAge(), vehicleInfo.getNumberOfMiles(), vehicleInfo.isDiesel());
        }

        return null;
    }
}