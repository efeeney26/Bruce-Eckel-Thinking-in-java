package errorsexceptions;
import static errorsexceptions.util.Print.*;
import java.util.*;
import java.io.*;
import java.util.logging.Logger;
//передача исключений в констоль
public class MainException {
    //передаем все исключения на консоль
    public static void main() throws Exception {
        //открываем файл
        FileInputStream file = new FileInputStream("MainException.java");
        //используем файл
        //закрываем файл
        file.close();
    }
}
