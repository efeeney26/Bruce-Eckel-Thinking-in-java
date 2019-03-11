package inputout;
import java.io.File;
import java.io.FilenameFilter;
import java.net.FileNameMap;
import java.util.Arrays;
import java.util.regex.Pattern;
//чтенеие файлов и каталогов
import static inputout.util.Print.*;
import static java.lang.String.CASE_INSENSITIVE_ORDER;
//вывод списка каталогов с использованием регулярных выражений
//{Параметры "D*\.java}
public class DirList {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if(args.length == 0)
            list = path.list();
        else
            list = path.list(new DirFilter(args[0]));
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            print(dirItem);
        }
    }
    public static void test(String[] args) {
        File dir = new File(args[0]);
        if (dir.isDirectory()) {
            for (File item : dir.listFiles()) {
                if(item.isDirectory()) {
                    print(item.getName() + "\t folder");
                }
                else
                    print(item.getName() + "\t file");
            }
        }
    }
}

class DirFilter implements FilenameFilter {
    private Pattern pattern;
    public DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
