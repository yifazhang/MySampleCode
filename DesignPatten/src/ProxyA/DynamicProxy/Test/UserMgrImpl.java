package ProxyA.DynamicProxy.Test;

/**
 * Created by zhangyifa on 6/14/17.
 */
public class UserMgrImpl implements UserMgr {

    @Override
    public void addUser() {
        System.out.println("1.插入记录到user表");
        System.out.println("2.做日记在另外一张表");
    }
}
