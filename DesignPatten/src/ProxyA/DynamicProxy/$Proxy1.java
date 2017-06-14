package ProxyA.DynamicProxy;
import java.lang.reflect.Method;
public class $Proxy1 implements ProxyA.DynamicProxy.Test.UserMgr{
   public $Proxy1(InvocationHandler h){
       this.h = h;
   }
   ProxyA.DynamicProxy.InvocationHandler h;
  @Override
  public void addUser() {
       try {
           Method md = ProxyA.DynamicProxy.Test.UserMgr.class.getMethod("addUser");
           h.invoke(this, md);
       }catch(Exception e){
           e.printStackTrace();
        }
   }
}