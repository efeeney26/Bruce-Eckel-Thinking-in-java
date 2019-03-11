package typesinfo;
import java.util.Random;
//инициализация классов
import static typesinfo.util.Print.*;

class Initiable {
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);
    static {
        print("Инициализция Initable");
    }
}

class Initiable2 {
    static int staticNonFinal = 147;
    static {
        print("Инициализция Initable2");
    }
}

class Initiable3 {
    static int staticNonFinal = 74;
    static {
        print("Инициализция Initable3");
    }
}

public class ClassInitialization {
    public static Random rand = new Random(47);
    public static void main() throws Exception{
        Class initable = Initiable.class;
        print("после создания ссылки initable");
        //не приводит к инициализации
        print(Initiable.staticFinal);
        //приводит к инициализации
        print(Initiable.staticFinal2);
        //приводит к инициализации
        print(Initiable2.staticNonFinal);
        Class initiable3 = Class.forName("typesinfo.Initiable3");
        print("после создания ссылки Initiable3");
        print(Initiable3.staticNonFinal);
    }
}
