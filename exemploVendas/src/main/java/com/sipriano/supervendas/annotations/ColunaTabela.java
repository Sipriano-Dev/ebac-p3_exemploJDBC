package main.java.com.sipriano.supervendas.annotations;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ColunaTabela {

    String dbName();

    String setJavaName();
}