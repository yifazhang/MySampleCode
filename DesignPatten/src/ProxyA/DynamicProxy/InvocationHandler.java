package ProxyA.DynamicProxy;

import java.lang.reflect.Method;

/**
 * Created by zhangyifa on 6/14/17.
 */
public interface InvocationHandler {
   void invoke(Object o, Method m);

}
