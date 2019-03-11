package innerclasses;
import static innerclasses.util.Print.*;
import java.util.*;
//Обобзенная ситема управления

public class Controller {
    //Класс из пакета java.util для хранения событий Event
    private List<Event> eventList = new ArrayList<Event>();
    public void addEvent(Event c) {eventList.add(c);}
    public void run() {
        while (eventList.size() > 0) {
            for(Event e: new ArrayList<Event>(eventList))
                if(e.ready()) {
                    print(e);
                    e.action();
                    eventList.remove(e);
                }
        }
    }
}
