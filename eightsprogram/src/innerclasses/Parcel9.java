package innerclasses;
import static innerclasses.util.Print.*;
//конструирование безымянного внутреннего класса

public class Parcel9 {
    public Destination destination(String dest, float price) {
        return new Destination() {
            private int cost;
            //Инициализация экземпляра для каждого объекта
            {//внутри блока код недоступен для инициализации полей, поэтому инициализатор экземпляра фактически является конструктором безымянного класса
                cost = Math.round(price);
                if (cost > 100)
                    print("Превышение бюджета");
            }
            private String label = dest;
            public String readLabel() {return label;}
        };
    }
    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.destination("Танзания", 101.395F);
        print(d.readLabel());
    }
}
