package collections;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static collections.util.Print.*;
//Хэширование и хэш-коды, неправильное определение класса для ключа

class Groundhog {
    protected int number;
    public Groundhog(int number) {
        this.number = number;
    }
    @Override
    public String toString() {
        return "Groundhog #" + number;
    }
}

class Prediction {
    private Random rand = new Random(47);
    private boolean shadow = rand.nextDouble() > 0.5;
    public String toString() {
        if(shadow)
            return "Six more weeks of Winter!";
        else
            return "Early Spring";
    }
}

public class SpringDetector {
    //используем класс Groundhog или класс производный от него
    public static <T extends Groundhog> void detectSpring(Class<T> type) throws Exception {
        Constructor<T> ghog = type.getConstructor(int.class);
        Map<Groundhog, Prediction> map = new HashMap<Groundhog, Prediction>();
        for (int i = 0; i < 10; i++) {
            map.put(ghog.newInstance(i), new Prediction());
        }
        print("map = " + map);
        Groundhog gh = ghog.newInstance(3);
        print("Look at " + gh );
        if(map.containsKey(gh))
            print(map.get(gh));
        else
            print("key not found");
    }

    public static void main(String[] args) throws Exception {
        detectSpring(Groundhog.class);
    }
}
