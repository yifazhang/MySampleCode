package ProxyA.DynamicProxy.Test;

import ProxyA.DynamicProxy.InvocationHandler;

/**
 * Created by zhangyifa on 6/14/17.
 */
public class Client {
    public static void main(String[] args) throws Exception {
        UserMgr mgr = new UserMgrImpl();
        InvocationHandler h = new TransactionHandler(mgr);
        UserMgr u = (UserMgr) Proxy.newProxyInstance(UserMgr.class, h);
        u.addUser();
    }
}
