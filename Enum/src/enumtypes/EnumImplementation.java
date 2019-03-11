package enumtypes;
import java.util.Random;
import static enumtypes.util.Print.*;
//перечисление может реализовывать интерфейс

enum CartoonCharacter implements Generator<CartoonCharacter> {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOB;

    private Random random = new Random(47);

    @Override
    public CartoonCharacter next() {
        return values()[random.nextInt(values().length)];
    }
}

public class EnumImplementation {
    public static <T> void printNexT(Generator<T> rg) {
        printnb(rg.next() + ", ");
    }

    public static void main(String[] args) {
        //надо выбрать любой экземпляр
        CartoonCharacter cc = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++) {
            printNexT(cc);
        }
    }
}
