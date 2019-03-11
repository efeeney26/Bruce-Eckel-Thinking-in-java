package inputout;
import java.io.IOException;
import java.io.StringReader;

import static inputout.util.Print.*;
//Чтение из памяти
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(BufferedInputFile.read(args[0]));
        int c;
        while ((c = in.read()) != -1)
            printnb((char)c);
    }
}
