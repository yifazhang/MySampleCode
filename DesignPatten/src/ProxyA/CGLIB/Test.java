package ProxyA.CGLIB;

import net.sf.cglib.proxy.Enhancer;


/**
 * Created by zyf on 2017/6/15.
 */
public class Test {
    public static void main(String[] args) {
        UserService service = new UserServiceImpl();
        ServiceInvocationHandler handler = new ServiceInvocationHandler();

        //cglib 中加强器，用来创建动态代理
        Enhancer enhancer = new Enhancer();
        //设置要创建动态代理的类
        enhancer.setSuperclass(service.getClass());
        // 设置回调，这里相当于是对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实行intercept()方法进行拦截
        enhancer.setCallback(handler);
        UserService service1 = (UserService) enhancer.create();
        service1.addUser();
    }
}
