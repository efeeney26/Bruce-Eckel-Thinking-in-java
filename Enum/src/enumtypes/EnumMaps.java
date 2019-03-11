package enumtypes;
import java.util.EnumMap;
import java.util.Map;

import static enumtypes.util.Print.*;
//основы EnumMaps и реализация паттерна "Команда"

interface Command {void action();}

public class EnumMaps {
    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> em = new EnumMap<AlarmPoints, Command>(AlarmPoints.class);
        em.put(AlarmPoints.KITCHEN, new Command() {
            @Override
            public void action() {
                print("Kitchen fire!");
            }
        });
        em.put(AlarmPoints.BATHROOM, new Command() {
            @Override
            public void action() {
                print("Bathroom alert!");
            }
        });
        for (Map.Entry<AlarmPoints, Command> em1 : em.entrySet()) {
            printnb(em1.getKey() + ": ");
            em1.getValue().action();
        }
        try {
            em.get(AlarmPoints.UTILITY).action();
        }catch (Exception e) {
            print(e);
        }
    }
}
