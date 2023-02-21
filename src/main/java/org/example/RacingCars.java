package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private final List<Car> cars;

    public RacingCars(final List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getNewArrayListCars() {
        return new ArrayList<>(cars);
    }

    public List<Car> getUnmodifiableListCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> getCopyOfCars() {
        return List.copyOf(cars);
    }

    public List<Car> getCopyConstructorCars() {
        return cars.stream()
                .map(Car::new) // 복사 생성자로 Car 생성
                .collect(Collectors.toUnmodifiableList());
    }

    public int getCarsSize() {
        return cars.size();
    }

    public String getCarElementName(int index) {
        return cars.get(index).getName();
    }

    public void addCar(String name, int position) {
        cars.add(new Car(name, position));
    }

    public void setCarElementName(int index, String changeName) {
        Car car = cars.get(index);
        car.setName(changeName);
    }
}
