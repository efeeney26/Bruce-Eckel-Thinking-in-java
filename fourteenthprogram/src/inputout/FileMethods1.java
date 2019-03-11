package inputout;
import java.io.File;
//{Аргументы: C://Books/Test C://Books/Test1}
import static inputout.util.Print.*;

public class FileMethods1 {
    public static void main(String[] args) {
        File dir = new File(args[0]);//определяем объект для каталога
        boolean created = dir.mkdir();//создаем папку
        if(created)
            print("Folder has been created");
        File newDir = new File(args[1]);
        dir.renameTo(newDir);//переименуем каталог
        boolean deleted = newDir.delete();//удалим каталог
        if(deleted)
            print("Dir has been deleted");
        print(dir.getParent());
    }
}
