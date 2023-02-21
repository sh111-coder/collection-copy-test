package org.example;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;

@DisplayName("그대로 리스트(return cars) 반환 시 테스트")
public class GetCarsTest {

    private RacingCars racingCars;
    private List<Car> copiedList;
    private int originalListSize;
    private String originalCar1Name;

    @BeforeEach
    void init() {
        originalCar1Name = "seongHa";
        Car car1 = new Car(originalCar1Name, 0);
        Car car2 = new Car("hadi", 0);
        Car car3 = new Car("odo", 0);
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        racingCars = new RacingCars(cars);
        originalListSize = racingCars.getCarsSize();
        copiedList = racingCars.getCars();
    }

    @Nested
    @DisplayName("원본 리스트 관련 테스트")
    class originalListTest {

        @Test
        @DisplayName("원본 리스트 변경 시 복사한 리스트도 변경이 된다.")
        void test1() {
            racingCars.addCar("addCar", 0);

            Assertions.assertEquals(copiedList.size(),  originalListSize + 1);
        }

        @Test
        @DisplayName("원본 리스트 안의 객체 요소 변경 시 복사한 리스트 안의 객체 요소도 변경이 된다.")
        void test2() {
            racingCars.setCarElementName(0, "changeSeongHa");

            Assertions.assertNotEquals(copiedList.get(0).getName(), originalCar1Name);
            Assertions.assertEquals(copiedList.get(0).getName(), "changeSeongHa");
        }
    }

    @Nested
    @DisplayName("복사한 리스트 관련 테스트")
    class copiedListTest {

        @Test
        @DisplayName("복사한 리스트는 변경할 수 있다.")
        void test3() {
            Assertions.assertDoesNotThrow(() -> copiedList.add(new Car("newCar", 0)));
        }

        @Test
        @DisplayName("복사한 리스트 변경 시 원본 리스트도 변경이 된다.")
        void test4() {
            copiedList.add(new Car("newCar", 0));

            Assertions.assertEquals(racingCars.getCarsSize(), originalListSize + 1);
        }

        @Test
        @DisplayName("복사한 리스트 안의 객체 요소는 변경될 수 있다.")
        void test5() {
            Assertions.assertDoesNotThrow(() -> copiedList.get(0).setName("changeSeongHa"));
        }

        @Test
        @DisplayName("복사한 리스트 안의 객체 요소가 변경되면 원본 리스트 안의 객체 요소도 변경된다.")
        void test6() {
            copiedList.get(0).setName("changeSeongHa");

            Assertions.assertNotEquals(racingCars.getCarElementName(0), "seongHa");
            Assertions.assertEquals(racingCars.getCarElementName(0), "changeSeongHa");
        }
    }
}
