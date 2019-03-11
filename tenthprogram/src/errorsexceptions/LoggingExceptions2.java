package errorsexceptions;
import static errorsexceptions.util.Print.*;
import java.util.*;
import java.io.*;
import java.util.logging.Logger;
//Регистрация перехваченных исключений(перехват и регистрация сторонних исключений, сообзение генерируется в обработчике исключений. Так чаще бывает на практике)

public class LoggingExceptions2 {
    private static Logger logger = Logger.getLogger("LoggerException2");
    static void logException(Exception e) {
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
    public static void main() {
        try {
            throw new NullPointerException();
        }catch (NullPointerException e) {
            logException(e);
        }
    }
}
