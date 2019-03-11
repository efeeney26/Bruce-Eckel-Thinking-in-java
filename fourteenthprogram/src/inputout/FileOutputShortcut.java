package inputout;
//сокращенная форма вывода тектового файла
import static inputout.util.Print.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class FileOutputShortcut {
    static String file = "FileOutputShortcut.out";
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read(args[0])));
        //сокращенная запись
        PrintWriter out = new PrintWriter(file);
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null)
            out.println(s + " " + lineCount++);
        out.println(lineCount + " " + "String 8" + " " + lineCount);
        printnb(BufferedInputFile.read(args[0]));
    }
}
