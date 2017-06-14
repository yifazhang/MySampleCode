package ProxyA.StaticProxy;

/**
 * Created by zhangyifa on 6/14/17.
 */
public class TankLogProxy implements Moveable {

    Moveable m;

    public TankLogProxy(Moveable m) {
        super();
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("Tank log Start");
        m.move();
        System.out.println("Tank log End");
    }
}
