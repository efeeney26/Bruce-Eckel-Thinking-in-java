package inputout;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import static inputout.util.Print.*;
//Форматированное чтение из памяти
public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException {
        try {
            DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read(args[0]).getBytes()));
            while (true)
                printnb((char)in.readByte());
        }catch (EOFException e)
        {
            System.err.print("End of stream");
        }
    }
}
