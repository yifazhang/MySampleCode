package Factory;

/**
 * Created by zyf on 2017/6/15.
 */
public class Test {
    public static void main(String[] args) {

//        Car c = Car.getInstance();
//        Car c2 = Car.getInstance();
//
//        System.out.println(c == c2);
//
//        c.run();
    Moveable m = new Plane();
    m.run();

    }
}
