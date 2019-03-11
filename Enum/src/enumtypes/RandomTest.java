package enumtypes;
import enumtypes.enums.Enums;
import static enumtypes.util.Print.*;
//тест на выдачу рандомного значения из enum

import static enumtypes.enums.Enums.*;

enum Activity {SITTING, LYING, STANDING, HOPING}

public class RandomTest {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            printnb(random(Activity.class) + " ");
        }
    }
}
