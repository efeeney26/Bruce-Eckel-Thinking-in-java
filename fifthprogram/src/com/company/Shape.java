package com.company;
import static com.company.util.Print.*;
//обеспечение правильного завершения программы(без утечек памяти)

class Shape {
    public Shape(int i) {print("Constr Shape");}
    void dispose() {print("Завершение Shape");}
}

class Circle extends Shape{
    public  Circle(int i) {
        super(i);
        print("Draw circle Circle");
    }
    void dispose() {
        print("Delete circle Circle");
        super.dispose();
    }
}

class Triangle extends Shape {
    public  Triangle(int i) {
        super(i);
        print("Draw triangle Triangle");
    }
    void dispose() {
        print("Delete triangle Triangle");
        super.dispose();
    }
}

class Line extends Shape {
    int start, end;
    public  Line(int start, int end) {
        super(start);
        this.start = start;
        this.end = end;
        print("Draw line from " + start + " to " + end);
    }
    void dispose() {
        print("Delete line Line");
        super.dispose();
    }
}

class CADSystem extends Shape {
    private Circle c;
    private Triangle t;
    private Line[] lines = new Line[3];
    public CADSystem(int i) {
        super(i + 1);
        for (int j = 0; j < lines.length; j++)
            lines[j] = new Line(j, j * j);
        c = new Circle(1);
        t = new Triangle(1);
        print("combine constr");
    }
    void dispose() {
        print("CADSystem dispose()");
        t.dispose();
        c.dispose();
        for (int i = lines.length - 1; i >= 0; i--) {
            lines[i].dispose();
        }
        super.dispose();
    }
}
