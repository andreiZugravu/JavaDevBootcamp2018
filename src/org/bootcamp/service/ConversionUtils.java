package org.bootcamp.service;

import org.bootcamp.model.VehicleInfo;
import org.bootcamp.vehicle.Bus;
import org.bootcamp.vehicle.Car;
import org.bootcamp.vehicle.Tipper;
import org.bootcamp.vehicle.Vehicle;

final class ConversionUtils { //fara public, o folosim doar in package
    private ConversionUtils() {
    }

    static Vehicle getVehicle(VehicleInfo vehicleInfo) {
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
