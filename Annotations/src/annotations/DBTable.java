package annotations;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//аннотация, которая сообщает обработчику аннотаций, что он должен создать таблицу бд
import static annotations.util.Print.*;
@Target(ElementType.TYPE)//каждый аргумент ElementType в аннотацц @Target устанавливает ограничение, которое сообщает компилятору, что аннотация применяется только к конкретному типу
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
	public String name() default "";//имеет элемент name(), чтобы аннотация могла предоставить имя таблицы бд, которая будет создана обработчиком
}
