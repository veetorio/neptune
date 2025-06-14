package com.example.api.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.TYPE) // Pode ser usada em interfaces ou classes
@Retention(RetentionPolicy.RUNTIME) // Precisa estar disponível em tempo de execução
public @interface LoggerWatcher {
    String value() default "";
}

