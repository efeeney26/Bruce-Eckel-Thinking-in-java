package com.company;
import java.util.Arrays;
import static com.company.util.Print.*;
//переработка Apply через интерфейс

interface Processor1 {
    String name();
    Object process(Object input);
}

abstract class StringProcessor implements Processor1 {
    public String name() {
        return getClass().getSimpleName();
    }
    public abstract String process(Object input);
}

class Upcase1 extends StringProcessor {
    public String process(Object input) {
        return ((String)input).toUpperCase();
    }
}

class Downcase1 extends StringProcessor {
    public String process(Object input) {
        return ((String)input).toUpperCase();
    }
}

class Splitter1 extends StringProcessor {
    public String process(Object input) {
        return Arrays.toString(((String)input).split(" "));
    }
}

public class NewApply {
    public static void process(Processor1 p, Object s) {
        print("Using Processor1 " + p.name());
        print(p.process(s));
    }
    public static String s = "If she weight as same as duck, she's made of wood";
    public static void main(String[] args) {
        NewApply.process(new Upcase1(), s);
        NewApply.process(new Downcase1(), s);
        NewApply.process(new Splitter1(), s);
    }
}
