package ProxyA.StaticProxy;

/**
 * Created by zhangyifa on 6/14/17.
 */
public class TankTimeProxy implements Moveable {

    Moveable m;

    public TankTimeProxy(Moveable m) {
        super();
        this.m = m;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        System.out.println("start: "+ start);
        m.move();
        long end = System.currentTimeMillis();
        System.out.println("end: "+ end);
        System.out.println("time: "+(end - start));
    }
}
