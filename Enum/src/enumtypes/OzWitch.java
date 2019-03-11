package enumtypes;
import static enumtypes.util.Print.*;
//добавление метов к enum
public enum OzWitch {
    //определение экземпляров должны предшествовать опредлениям методов
    WEST("TOTO WEST"),
    NORTH("TATA NORTH"),
    EAST("TUTU EAST"),
    SOUTH("TITI SOUTH");
    //конструктор должен быть закрытым или с доступом уровня пакета
    private String description;

    OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for ( OzWitch ozWitch : OzWitch.values() ) {
            print(ozWitch + ": " + ozWitch.getDescription());
        }
    }
}
