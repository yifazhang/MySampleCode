package ProxyA.JDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by zyf on 2017/6/15.
 */
public class ServiceInvocationHandler implements InvocationHandler{

    private Object target;

    public ServiceInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("代理类方法，进行了增强。。。");
        System.out.println("事务开始。。。");
        // 执行目标方法对象
        result = method.invoke(target, args);
        System.out.println("事务结束。。。");
        return result;
    }
}
