package typesinfo.packageaccess;
import static typesinfo.util.Print.*;
//интерфейс можно обойти

interface A {
    void f();
}

class B implements A {
    public void f() {}
    public void g() {}
}

public class InterfaceViolation {
    public static void main() {
        A a = new B();
        a.f();
        if (a instanceof B)
            ((B)a).g();//нисходящее приведени типов
    }
}

class C implements A {
    public void f() {print("public C f()");}
    public void g() {print("public C g()");}
    void u() {print("package C.u()");}
    protected void v() {print("protected C.v()");}
    private void w() {print("private C.w()");}
}

class HiddenC {
    public static A makeA() {return new C();}
}

