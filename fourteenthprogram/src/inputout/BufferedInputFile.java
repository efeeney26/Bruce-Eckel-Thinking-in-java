package inputout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//{Аргументы: C:/Books/test.txt}
import static inputout.util.Print.*;
//буферизованное чтение из файла

public class BufferedInputFile {
    //исключения направляются в консоль
    public static String read(String filename) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader(filename));//чтение входных данных по строкам
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = bf.readLine()) != null)
            sb.append(s + "\n");
        bf.close();
        return sb.toString();
    }
    public static void main(String[] args) throws IOException{
            print(read(args[0]));
    }
}
