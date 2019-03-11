package inputout;
import java.io.*;
import java.util.Arrays;

import static inputout.util.Print.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //DirList.test(args);//чтенеие файлов и каталогов

        //FileMethods.main(args);//методы работы с File

        //FileMethods1.main(args);//методы работы с File

        //FileMethods2.main(args);//методы работы с File

        //BufferedInputFile.main(args);//буферизованное чтение из файла

        //MemoryInput.main(args);//Чтение из памяти

        //FormattedMemoryInput.main(args);//Форматированное чтение из памяти

        /*String s = BufferedInputFile.read(args[0]);//тест форматированного чтения из памяти
        byte[] b =s.getBytes();
        print(Arrays.toString(b));
        ByteArrayInputStream bs = new ByteArrayInputStream(b);
        DataInputStream ds = new DataInputStream(bs);
        while (true)
            printnb((char)ds.readByte());*/

        //TestEof.main(args);//побайтовое чтение файла

        //BufferedOutputFile.main(args);//буферизованный ввод в файл

        //FileOutputShortcut.main(args);//сокращенная форма вывода тектового файла



    }
}
