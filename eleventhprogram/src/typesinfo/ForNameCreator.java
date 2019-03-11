package typesinfo;
import java.util.ArrayList;
import java.util.List;

import static typesinfo.util.Print.*;
public class ForNameCreator extends PetCreator{
    private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();
    //типы, создаваемые случайным образом
    private static String[] typeNames = {
            "typesinfo.Mutt",
            "typesinfo.Pug",
            "typesinfo.EgyptianMau",
            "typesinfo.Manx",
            "typesinfo.Cymric",
            "typesinfo.Rat",
            "typesinfo.Mouse",
            "typesinfo.Hamster",
    };
    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for (String name: typeNames) {
                types.add(
                        (Class<? extends Pet>) Class.forName(name));
            }
        }catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }
    static {loader();}

    @Override
    public List<Class<? extends Pet>> types() { return types;}
}
