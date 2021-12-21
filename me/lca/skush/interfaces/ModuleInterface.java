package me.lca.skush.interfaces;

import me.lca.skush.module.Category;
import org.lwjgl.input.Keyboard;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ModuleInterface {
    String name();
    String description() default "";
    int keyBind() default Keyboard.KEY_NONE;
    Category category();
    int color();
}
