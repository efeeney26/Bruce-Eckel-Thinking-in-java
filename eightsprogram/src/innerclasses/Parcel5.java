package innerclasses;
import static innerclasses.util.Print.*;
//определяем внутренний класс в произвольную область действия

public class Parcel5 {
    private void internalTracking(boolean b) {
        if(b) {
            class TrackingSleep {//класс TrackingSleep вложен в область действия команды if
                private String id;
                TrackingSleep(String s) {
                    id = s;
                }
                String getSleep() {return id;}
            }
            TrackingSleep ts = new TrackingSleep("Ожидание");
            String s = ts.getSleep();
            print(s);
        }
        else
            print("Статус не задан");
        //TrackingSleep ts = new TrackingSleep("x")//здесь использовать TrackingSleep нельзя - использовн вне области видимости
    }
    public void track() {internalTracking(true);}
    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        p.track();
    }
}
