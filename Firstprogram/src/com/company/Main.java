package com.company;
import java.util.*;
import static com.company.util.Print.*;


class Test extends Test3 {
    int i = 6;
    public  void f() {print(1);}
    public  void f(int i) {print(i);}
    class Test1 extends Test2 {
        Test t = new Test();
        void g(int i) {
            Test t = new Test();
            t.i = i;
        }

    }
}
class Test2 extends Test{
    public void f() {print(2);}
}
class Test3 {
    void h() {
        Test2 t2 = new Test2();
        t2.f(5);
    }
}


/**Firstprogram return string woth date
 * @author efeeney
 * @version 1.0
 */
public class Main {
    /**Point of entry
     * @param args array of arguments
     */
    public static void main(String[] args) {
        /*System.out.println("Hello, today is " + new Date());
        print("go");
        Test t = new Test();
        Test.Test1 e = new Test().new Test1();
        Test2 r = new Test2();
        new Test3().h();
        Test3 t3 = new Test3();
        Test3 t4 = new Test3();
        print(t3.equals(t4));
        String g = "hhy";
        String c[] = g.split("");
        print(Arrays.toString(c));
        print(g.indexOf("h"));*/

        //Ex1.main(args);

        Ex2.main(args);
    }
}/* Output
    Hello, today is <date></date>
*/// ~