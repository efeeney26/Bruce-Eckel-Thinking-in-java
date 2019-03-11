package com.company;
import java.util.Arrays;
import static com.company.util.Print.*;

class Processor {
    String name() { return getClass().getSimpleName();};
    Object process(Object input) {return input;}
}

class Upcase extends Processor {
    public String process(Object input) {
        return ((String) input).toUpperCase();//Ковариантный возвращаемый тип(process переопределен, в базовом классе возвращается Object(базовый тип), в производном возвращается String(производный от базового типа) }
    }
}
class Downcase extends Processor {
    public String process(Object input) {
        return ((String)input).toLowerCase();//тоже ковариантность
    }
}

class Splitter extends Processor {
    public String process(Object input) {
        return Arrays.toString(((String)input).split(" "));
    }
}

public class Apply {
    public static void process(Processor p, Object s) {
        print("Используем Processor " + p.name());
        print(p.process(s));
    }
    public static String s = "Disagreement is beliefs is by defenition incorrect";
    public  static void main(String[] args) {
        process(new Upcase(), s);
        process(new Downcase(), s);
        process(new Splitter(), s);
    }
}
