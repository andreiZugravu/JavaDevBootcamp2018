package org.bootcamp.service;

import org.bootcamp.calculator.InsurancePolicyCalculator;
import org.bootcamp.dao.VehicleInfoPlainFileDao;
import org.bootcamp.formula.Formula;
import org.bootcamp.model.VehicleInfo;
import org.bootcamp.vehicle.Vehicle;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.bootcamp.service.ConversionUtils.getVehicle;

public final class InsuranceCalculatorService {
    private String filePath;

    public InsuranceCalculatorService(String filePath) {
        this.filePath = filePath;
    }

    public List<InsuranceCalculationResult> calculateAll() {
        final InsurancePolicyCalculator calculator = InsurancePolicyCalculator.INSTANCE;

        final VehicleInfoPlainFileDao vehicleInfoDao = new VehicleInfoPlainFileDao(filePath);

        final List<VehicleInfo> vehicleInfos = vehicleInfoDao.getAllVehicles();

        final List<InsuranceCalculationResult> resultList = new LinkedList<>();

        if(vehicleInfos.isEmpty()) {
            return Collections.emptyList();
        }
        else {
            for (VehicleInfo vehicleInfo : vehicleInfos) {
                final Vehicle vehicle = getVehicle(vehicleInfo);

                final Formula formula = Formula.valueOf(vehicleInfo.getVehicleTypeFormula());

                final int totalCost = calculator.calculate(vehicle, formula);

                final InsuranceCalculationResult result = new InsuranceCalculationResult(vehicleInfo.getId(), totalCost);

                resultList.add(result);
            }

            return resultList;
        }
    }
}
