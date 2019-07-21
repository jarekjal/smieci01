package jarekjal.nauka;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
    String str() default "hmmm...";
    int val() default 100;

}
