package ProxyA.CGLIB;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

/**
 * Created by zyf on 2017/6/15.
 */
public class ServiceInvocationHandler implements MethodInterceptor{

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("事务开始。。。");
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("事务结束。。。");
        return result;
    }
}
