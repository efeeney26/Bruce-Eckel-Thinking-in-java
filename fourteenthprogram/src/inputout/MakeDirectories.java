package inputout;
import java.io.File;

import static inputout.util.Print.*;

public class MakeDirectories {
    private static void usage() {
        print(
                "Использование: MakeDirectories путь1 ...\n" +
                        "Создает все пути\n" +
                        "Испошльзование:MakeDirectories -d путь1 ...\n" +
                        "удаляет все пути\n" +
                        "Использование: MakeDirectories -r путь1 путь2\n" +
                        "Переименовывает путь1 в путь2\n"
        );
        System.exit(1);
    }
    private static void fileData(File f) {
        print(
                "Полное имя: " + f.getAbsolutePath() +
                        "\n доступно для чтения: " + f.canRead() +
                        "\n доступно для записи: " + f.canWrite() +
                        "\n имя файла getName(): " + f.getName() +
                        "\n родительский каталог getParent(): " + f.getParent() +
                        "\n путь getPath(): " + f.getPath() +
                        "\n размер " + f.length() +
                        "\n последнее изменение " + f.lastModified()
        );
        if(f.isFile())
            print("Это файл");
        else if(f.isDirectory())
            print("Это каталог");
    }
    public static void main(String[] args) {
            if(args.length != 3) usage();
            if(args[0].equals("-r")) {
                if(args.length != 3) usage();
                File
                        old = new File((args[1])),
                        rname = new File(args[2]);
                old.renameTo(rname);
                fileData(old);
                fileData(rname);
                return;//выход из метода main
            }
            int count = 0;
            boolean del = false;
            if(args[0].equals("-d")) {
                count++;
                del = true;
            }
            count--;
            while (++count < args.length) {
                File f = new File(args[count]);
                if(f.exists()) {
                    print(f + "существует");
                    if(del) {
                        print("Удаление " + f);
                        f.delete();
                    }
                }
                else {//не существует
                    if(!del) {
                        f.mkdirs();
                        print("создано " + f);
                    }
                }
                fileData(f);
            }
    }
}
