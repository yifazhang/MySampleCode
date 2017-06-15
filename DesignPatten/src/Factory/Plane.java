package Factory;

/**
 * Created by zyf on 2017/6/15.
 */
public class Plane implements Moveable {

    @Override
    public void run() {
        System.out.println("开飞机");
    }
}
