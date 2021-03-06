package typesinfo;
import java.util.*;

import static typesinfo.util.Print.*;
//Создание случайных последовательностей Pet
public abstract class PetCreator {
    private Random rand = new Random(47);
    //Список создаваемых типов, производных от Pet
    public abstract List<Class<? extends Pet>> types();
    public Pet randomPet() {//создание одного случайного объекта Pet
        int n = rand.nextInt(types().size());
        try {
            return types().get(n).newInstance();
        }catch (InstantiationException e) {
            throw new RuntimeException();
        }catch (IllegalAccessException e) {
            throw new RuntimeException();
        }
    }
    public Pet[] createArray(int size) {
        Pet[] result = new Pet[size];
        for (int i = 0; i < size; i++)
            result[i] = randomPet();
        return result;
    }
    public ArrayList<Pet> arrayList(int size) {
        ArrayList<Pet> result = new ArrayList<Pet>();
        Collections.addAll(result, createArray(size));
        return result;
    }
}
