package enumtypes;
import java.text.DateFormat;
import java.util.Date;

import static enumtypes.util.Print.*;
//методы констант
public enum ConstantSpecificMethod {
    DATA_TIME {
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },
    CLASSPATH {
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },
    VERSION {
        String getInfo() {
            return System.getProperty("java.version");
        }
    };
    abstract String getInfo();

    public static void main(String[] args) {
        for ( ConstantSpecificMethod csm : values()) {
            print(csm.getInfo());
        }
    }
}
