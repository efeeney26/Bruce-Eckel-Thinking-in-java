package generics;
import static generics.util.Print.*;
//Автоматическое создание Generator для класса
//с конструктором по умолчанию(без аргументов)

public class BasicGenerator<T> implements Generator<T> {
    private Class<T> type;
    public BasicGenerator (Class<T> type) {this.type = type;}
    public T next() {
        try {
            //предполагается, что type является public-классом
            return type.newInstance();
        }catch (Exception e) {
            throw new RuntimeException();
        }
    }
    //получение генератора по умолчанию для заданного type:
    public static <T> Generator<T> create(Class<T> type) {
        return new BasicGenerator<T>(type);
    }
}
