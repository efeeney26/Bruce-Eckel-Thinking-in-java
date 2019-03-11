package typesinfo;
import java.util.HashMap;
//использование instanceof
import static typesinfo.util.Print.*;

class Individual {
    private String name;
    public Individual(String name) {this.name = name;}
    public Individual() {}
}
class Person extends Individual {
    public Person(String name) {super(name);}
}
class Pet extends Individual {
    public Pet(String name) {super(name);}
    public Pet() {super();}
}

class Dog extends Pet {
    public Dog(String name) {super(name);}
    public Dog() {super();}
}

class Mutt extends Dog {
    public Mutt(String name) {super(name);}
    public Mutt() {super();}
}
class Pug extends Dog {
    public Pug(String name) {super(name);}
    public Pug() {super();}
}
class Cat extends Pet {
    public Cat(String name) {super(name);}
    public Cat() {super();}
}
class EgyptianMau extends Cat {
    public EgyptianMau(String name) {super(name);}
    public EgyptianMau() {super();}
}
class Manx extends Cat {
    public Manx(String name) {super(name);}
    public Manx() {super();}
}
class Cymric extends Manx {
    public Cymric(String name) {super(name);}
    public Cymric() {super();}
}
class Rodent extends Pet {
    public Rodent(String name) {super(name);}
    public Rodent() {super();}
}
class Rat extends Rodent {
    public Rat(String name) {super(name);}
    public Rat() {super();}
}
class Mouse extends Rodent {
    public Mouse(String name) {super(name);}
    public Mouse() {super();}
}
class Hamster extends Rodent {
    public Hamster(String name) {super(name);}
    public Hamster() {super();}
}
public class PetCount {
    static class PetCounter extends HashMap<String, Integer> {
        public void count(String type) {
            Integer quantity = get(type);
            if(quantity == null)
                put(type, 1);
            else
                put(type, quantity + 1);
        }
    }
    public static void countPets(PetCreator creator) {
        PetCounter petCounter = new PetCounter();
        for (Pet pet: creator.createArray(20)) {
            //Подсчет всех объектов Pet
            printnb(pet.getClass().getSimpleName() + " ");
            if(pet instanceof Pet)
                petCounter.count("Pet");
            if(pet instanceof Dog)
                petCounter.count("Dog");
            if(pet instanceof Mutt)
                petCounter.count("Mutt");
            if(pet instanceof Pug)
                petCounter.count("Pug");
            if(pet instanceof Cat)
                petCounter.count("Cat");
            if(pet instanceof Manx)
                petCounter.count("EgyptianMau");
            if(pet instanceof Manx)
                petCounter.count("Manx");
            if(pet instanceof Rodent)
                petCounter.count("Rodent");
            if(pet instanceof Rat)
                petCounter.count("Rat");
            if(pet instanceof Mouse)
                petCounter.count("Mouse");
            if(pet instanceof Hamster)
                petCounter.count("Hamster");
        }
        //вывод результатов подсчета
        print();
        print(petCounter);
    }
    public static void main() {
        countPets(new ForNameCreator());
    }
}
