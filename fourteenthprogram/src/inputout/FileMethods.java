package inputout;
import java.io.File;
//Работа с классом файл
//{args[0] == C://Books}
import static inputout.util.Print.*;

public class FileMethods {
    File dir = new File("C://Books");//файл для каталога
    File file = new File("C://Books", "Hello.txt");//файл, для файла в каталоге
    public static void main(String[] args) {
        File dir = new File(args[0]);//определяем файл для каталога
        if(dir.isDirectory()) {//если объект - каталог
            for (File item : dir.listFiles())//получаем все вложенные объекты в каталоге
            {
                if(item.isDirectory())
                    print(item.getName() + " - folder");
                else
                    print(item.getName() + " - file");
            }
        }
    }
}
