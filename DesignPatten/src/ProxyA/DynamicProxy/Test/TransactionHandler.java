package ProxyA.DynamicProxy.Test;

import ProxyA.DynamicProxy.InvocationHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by zhangyifa on 6/14/17.
 */
public class TransactionHandler implements InvocationHandler {

    private Object object;

    public TransactionHandler(Object object) {
        this.object = object;
    }

    @Override
    public void invoke(Object o, Method m) {
        System.out.println("Transaction Start");
        try {
            m.invoke(object);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("Transaction Commit");
    }

}
