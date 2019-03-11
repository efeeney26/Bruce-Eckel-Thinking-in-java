package innerclasses;
import static innerclasses.util.Print.*;
//переписанный Factories c помощью безымянных классов
interface Service {
    void method1();
    void method2();
}

interface ServiceFactory {
    Service getService();
}

class Implemention1 implements Service {
    private Implemention1() {}
    public void method1() {print(getClass().getSimpleName() + " method1");}
    public void method2() {print(getClass().getSimpleName() + " method2");}
    public static ServiceFactory factory = new ServiceFactory() {
        public Service getService() {return new Implemention1();}
    };
}

class Implemention2 implements Service {
    private Implemention2() {}
    public void method1() {print(getClass().getSimpleName() + " method1");}
    public void method2() {print(getClass().getSimpleName() + " method2");}
    public static ServiceFactory factory = new ServiceFactory() {
        public Service getService() {return new Implemention2();}
    };
}

public class FactoriesNew {
    public static void serviceConsumer(ServiceFactory fact) {
        Service s = fact.getService();
        s.method1();
        s.method2();
    }
    public static void main(String[] args) {
        serviceConsumer(Implemention1.factory);
        serviceConsumer(Implemention2.factory);
    }
}
