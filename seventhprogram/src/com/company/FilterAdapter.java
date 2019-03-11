package com.company;
import static com.company.util.Print.*;
//здесь исползуем паттерн Адаптер, получаем имеющийся интерфейc и создаем тот интерфейс, который нам нужен
public class FilterAdapter implements Processor1 {
    Filter filter;
    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }
    public String name() {return filter.name();}
    public Waveform process(Object input) {
        return filter.process((Waveform)input);
    }
}
