package enumtypes;
import static enumtypes.util.Print.*;
//переопределение методов enum
public enum SpaceShip {
    SCOUT, CARGO, TRANSPORT, CRUISER;
    public String toString() {
            return name().charAt(0) + name().substring(1).toLowerCase();
    }

    public static void main(String[] args) {
        for (SpaceShip spaceShip : values()) {
            print(spaceShip);
        }
    }
}
