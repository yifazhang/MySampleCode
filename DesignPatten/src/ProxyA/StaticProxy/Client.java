package ProxyA.StaticProxy;

/**
 * Created by zhangyifa on 6/14/17.
 */
public class Client {

    public static void main(String[] args) {
        Tank tank = new Tank();
        TankTimeProxy ttp = new TankTimeProxy(tank);
        TankLogProxy tlp = new TankLogProxy(ttp);
        Moveable m = tlp;
        m.move();
    }

}
