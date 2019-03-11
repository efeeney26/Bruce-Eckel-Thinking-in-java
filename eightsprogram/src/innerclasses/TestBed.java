package innerclasses;
import static innerclasses.util.Print.*;
//помещение кода во вложенный класс

public class TestBed {
    public void f() {print("f()");}
    public static class Tester {
        public static void main(String[] args) {
            TestBed testBed = new TestBed();
            testBed.f();
        }
    }
}
