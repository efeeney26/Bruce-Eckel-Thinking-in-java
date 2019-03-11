package inputout;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import static inputout.util.Print.*;
//Проверка достижения конца файла одновременно
//с чтением из него по байту

public class TestEof {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(args[0])));
        while (in.available() != 0)
            printnb((char)in.readByte());
    }
}
