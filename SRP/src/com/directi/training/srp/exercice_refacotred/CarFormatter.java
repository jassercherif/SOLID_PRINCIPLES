package com.directi.training.srp.exercice_refacotred;

import java.util.List;

public class CarFormatter {
    public String formatCarNames(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getBrand());
            sb.append(" ");
            sb.append(car.getModel());
            sb.append(", ");
        }
        // Remove the trailing comma and space if any cars are present
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }
}
