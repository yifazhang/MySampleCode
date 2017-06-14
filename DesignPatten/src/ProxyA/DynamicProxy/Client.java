package ProxyA.DynamicProxy;


/**
 * Created by zhangyifa on 6/14/17.
 */
public class Client {

    public static void main(String[] args) throws Exception {
        Moveable tank = new Tank();

        InvocationHandler h = new TimeHandler(tank);
        Moveable moveable = (Moveable)Proxy.newProxyInstance(Moveable.class,h);
        moveable.move();
    }

}
