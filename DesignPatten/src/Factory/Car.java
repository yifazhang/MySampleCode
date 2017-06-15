package Factory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyf on 2017/6/15.
 */
public class Car {

    private static Car car = new Car();
    private static List<Car> cars = new ArrayList<Car>();

    private Car() {}

    public static Car getInstance() {
        return car;
    }

    public void run() {
        System.out.println("冒烟奔跑中 car。。。");
    }
}
