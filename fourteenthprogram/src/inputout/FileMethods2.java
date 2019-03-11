package inputout;
import java.io.File;
//{{Аргументы: C:/Books/notes.txt C:/Books/notes1.txt
import static inputout.util.Print.*;

public class FileMethods2 {
    public static void main(String[] args) {
        File file = new File(args[0]);
        print("FIle name: " + file.getName());
        print("Parent folder: " + file.getParent());
        if ((file.exists()))
            print("file exist");
        else
            print("file not found");
        print("file length: " + file.length());
        if(file.canRead())
            print("file can  be read");
        else
            print("file can not be read");
        if(file.canWrite())
            print("file can  be write");
        else
            print("file can not be write");
        File file11 = new File(args[1]);
        try {
            boolean created = file11.createNewFile();
            if(created)
                print("File has been created");
        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        boolean deleted = file.delete();
        if(deleted)
            print("file has been deleted");
        file11.delete();

    }
}
