package com.company;
import static com.company.util.Print.*;

class Shared {
    private int refcount = 0;
    private static long counter = 0;
    private final long id = counter++;
    public Shared() {
        print("Создаем " + this);
    }
    public void addRef() {refcount++;}
    protected void dispose() {
        if(--refcount == 0)
            print("Disposing " + this);
    }
    public String toString() {return "Shared" + id;}
}

class Composing {
    private Shared shared;
    private static long counter = 0;
    private final long id = counter++;
    public Composing(Shared shared) {
        print("Создаем " + this);
        this.shared = shared;
        this.shared.addRef();
    }
    protected void dispose() {
        print("disposing " + this);
        shared.dispose();
    }
    public String toString() {return "Composing " + id;}
}

public class ReferenceCouting {
}
