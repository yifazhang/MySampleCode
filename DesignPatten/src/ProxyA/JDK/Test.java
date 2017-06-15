package ProxyA.JDK;

import java.lang.reflect.Proxy;

/**
 * Created by zyf on 2017/6/15.
 */
public class Test {
    public static void main(String[] args) {
        UserService service = new UserServiceImpl();
        ServiceInvocationHandler handler = new ServiceInvocationHandler(service);

        UserService service1 = (UserService) Proxy.newProxyInstance(
                                                UserService.class.getClassLoader(),
                                                service.getClass().getInterfaces(),
                                                handler);
        service1.addUser();
    }
}
