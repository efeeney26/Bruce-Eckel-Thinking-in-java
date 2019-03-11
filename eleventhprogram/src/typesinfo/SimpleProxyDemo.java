package typesinfo;
import static typesinfo.util.Print.*;
//Динамические посредники, использование паттерна proxy(посредник)

interface Interface {
    void doSmth();
    void doSmthElse(String arg);
}

class RealObject implements Interface {
    public void doSmth() {print("doSmth");}
    public void doSmthElse(String arg) {print("doSmthElse " + arg);}
}

class SimpleProxy implements Interface {
    private Interface proxied;
    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }
    public void doSmth() {
        print("SimpleProxy doSmth");
        proxied.doSmth();
    }
    public void doSmthElse(String arg) {
        print("SimpleProxy doSmthElse " + arg);
        proxied.doSmthElse(arg);
    }
}

public class SimpleProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSmth();
        iface.doSmthElse("bonobo");
    }
    public static void main() {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
