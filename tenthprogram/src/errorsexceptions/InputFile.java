package errorsexceptions;
import static errorsexceptions.util.Print.*;
import java.util.*;
import java.io.*;
import java.util.logging.Logger;
//Специфика исключений в конструкторах

public class InputFile {
    private BufferedReader in;
    public InputFile(String fname) throws Exception {
        try {
            in = new BufferedReader(new FileReader(fname));
            //остальной код, способный возбужать исключения
        }catch (FileNotFoundException e) {
            print("Невозможно открыть " + fname);
            //файл не открывался, поэтому не может быть закрыn
            throw e;
        }catch (Exception e) {
            //при других исключениях файл должен быть закрыт
            try {
                in.close();
            }catch (IOException e2) {
                print("in.close() исполнен неудачно");
            }
            throw e;//повторное возбуждение
        }finally {
            //не закрывать файл здесь!!
        }
    }
    public String getLine() {
        String s;
        try {
            s = in.readLine();
        }catch (IOException e) {
            throw new RuntimeException("readline() исполнен неудачно");
        }
        return s;
    }
    public void dispose() {
        try {
            in.close();
            print("dispose() успешен");
        }catch (IOException e) {
            throw new RuntimeException("in.clods() исполнение неудачно");
        }
    }
}
