package by.itacademy.mikhalevich.icourse.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Над чем мы её можем вешать, над классом (TYPE) и над методом)
@Target({ElementType.TYPE, ElementType.METHOD})
//Что бы можно было достать информацию о провешаной транзакции из уже запущенного кода, потому что Spring работает на этиапе Runtime
@Retention(RetentionPolicy.RUNTIME)
public @interface ControllerException {

}
