package enumtypes;
import static enumtypes.util.Print.*;
//переопределение методов констант


public enum OverrideConstantSpecific {
    NUT, BOLT,
    WASHER {
        void f() {print("Override method");}
    };
    void f() {print("default method");}

    public static void main(String[] args) {
        for (OverrideConstantSpecific ocs : values()) {
            printnb(ocs + ": ");
            ocs.f();
        }
    }
}
