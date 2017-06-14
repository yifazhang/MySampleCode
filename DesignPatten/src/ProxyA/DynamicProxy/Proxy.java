package ProxyA.DynamicProxy;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;


/**
 * Created by zhangyifa on 6/14/17.
 */
public class Proxy {

    public static Object newProxyInstance(Class infce, InvocationHandler h) throws Exception {
        String methodStr = "";
        String rt = "\r\n";

        Method[] methods = infce.getMethods();
        for (Method m : methods) {
            methodStr += "  @Override" + rt +
                    "  public void " + m.getName() + "() {" + rt +
                    "       try {" + rt +
                    "           Method md = " + infce.getName() + ".class.getMethod(\"" + m.getName() + "\");" + rt +
                    "           h.invoke(this, md);" + rt +
                    "       }catch(Exception e){" + rt +
                    "           e.printStackTrace();" + rt +
                    "        }" + rt +
                    "   }";
        }

        String src = "package ProxyA.DynamicProxy;" + rt +
                "import java.lang.reflect.Method;" + rt +
                "public class $Proxy1 implements " + infce.getName() + "{" + rt +
                "   public $Proxy1(InvocationHandler h){" + rt +
                "       this.h = h;" + rt +
                "   }" + rt +
                "   ProxyA.DynamicProxy.InvocationHandler h;" + rt +
                methodStr + rt +
                "}";
        String fileName = "/home/zhangyifa/Documents/java/code/MySampleCode/DesignPatten/src/ProxyA/DynamicProxy/$Proxy1.java";
        File f = new File(fileName);
        FileWriter fw = new FileWriter(f);
        fw.write(src);
        fw.flush();
        fw.close();

        //complie
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null,null,null);
        Iterable units = fileManager.getJavaFileObjects(fileName);
        CompilationTask t = compiler.getTask(null,fileManager,null,null,null,units);
        t.call();
        fileManager.close();

        //load into memory and create an instance
        URL[] urls = new URL[]{new URL("file:/" +"home/zhangyifa/Documents/java/code/MySampleCode/DesignPatten/src/")};
        URLClassLoader ul = new URLClassLoader(urls);
        Class c = ul.loadClass("ProxyA.DynamicProxy.$Proxy1");
//        System.out.println(c);

        Constructor ctr = c.getConstructor(InvocationHandler.class);
        Object m = ctr.newInstance(h);

        return m;
    }

}
