package inputout;
import java.io.*;

import static inputout.util.Print.*;
//буферизованный ввод в файл
public class BufferedOutputFile {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read(args[0])));
        PrintWriter out = new PrintWriter(new BufferedWriter(new BufferedWriter(new FileWriter(args[0]))));
        int lineCount = 1;
        String s;
        String outS = "String 8";
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + " " + s);
        }
        out.println(lineCount + " " + outS);
        in.close();
        out.close();
        printnb(BufferedInputFile.read(args[0]));
    }
}
