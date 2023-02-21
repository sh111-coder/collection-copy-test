package org.example;

import java.util.ArrayList;
import java.util.List;

public class CarController {

    public void run() {
        Car car1 = new Car("SeongHa", 0);
        Car car2 = new Car("Hadi", 0);
        Car car3 = new Car("Odo", 0);

        // List.of와 new ArrayList<>()의 차이
        // List.of() : ImmutableCollections.emptyList()으로 생성 -> 데이터 변경이 없는 불변 Collection으로 생성된다.
        // 따라서, List.of로 만든 List는 변경이 불가능하다.
        // new ArrayList<>() : 파라미터로 받은 Collection을 toArray()로 배열로 변경한 후, Arrays.copyOf()로 생성
        List<Car> cars = List.of(car1, car2, car3);
        List<Car> cars1 = new ArrayList<>(cars);

    }
}
