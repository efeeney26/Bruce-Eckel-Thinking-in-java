package errorsexceptions;
import static errorsexceptions.util.Print.*;
import java.util.*;
import java.io.*;
import java.util.logging.Logger;
//регистрация исключений с использованием Logger

class LoggingException extends Exception {
    private static Logger logger = Logger.getLogger("LoggerException");//стат-ий метод getLogger ассоциируется со String(обычно имя пакета или класса, к которому относятсяошибки), объект передает свой вывод в System.err
    public LoggingException() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}

public class LoggingExceptions {
    public static void main() {
        try {
            throw new LoggingException();
        }catch (LoggingException e) {
            System.err.println("Перехвачено " + e);
        }
        try {
            throw new LoggingException();
        }catch (LoggingException e) {
            System.err.println("Перехвачено " + e);
        }
    }
}
