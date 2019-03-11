package innerclasses;
import static innerclasses.util.Print.*;

public class DotNew {
    public class Inner {
        public String toString() {
            return getClass().getSimpleName();
        }
    }
    public static void main(String[] args) {
        DotNew dn = new DotNew();
        Inner dni = dn.new Inner();
        print(dni);
    }
}
