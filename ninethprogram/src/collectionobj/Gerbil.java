package collectionobj;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import static collectionobj.util.Print.*;

public class Gerbil {
    private int gerbilNumber;
    public Gerbil(int gerbilNumber) {this.gerbilNumber = gerbilNumber;}
    public void hop() {print(gerbilNumber);}
    public static void main(String[] args) {
        ArrayList<Gerbil> al = new ArrayList<Gerbil>();
        for (int i = 0; i < 3; i++)
            al.add(new Gerbil(i));
        for (Gerbil g : al) {
            g.hop();
        }

    }
}
