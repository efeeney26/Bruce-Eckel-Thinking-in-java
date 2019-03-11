package innerclasses;
import static innerclasses.util.Print.*;
//Настраивает и запускает систему управления
public class GreenhouseController {
    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
        //вместо жесткого кодирования фиксированных данных
        //можно было бы считать информацию для настройки
        //из текстового файла
        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new WaterOn(600),
                gc.new WaterOff(800),
                gc.new ThermostatDay(1400)
        };
        gc.addEvent(gc.new Restart(2000, eventList));
        if (args.length > 0)
            gc.addEvent(
                    new GreenhouseControls.Terminate(new Integer(args [0])));
        gc.run();
    }
}
