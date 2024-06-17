package org.example.anno;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.validation.StateValidation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)  //代表该注解只能用在字段上
@Retention(RUNTIME) //代表该注解什么时候生效
//@Repeatable(List.class)
@Documented //代表该注解会被包含在javadoc中
@Constraint(
        validatedBy = {StateValidation.class}
)   //代表谁来给该注解提供校验规则
public @interface State {
    //提供校验失败时的提示信息
    String message() default "state的参数只能为已发布或草稿";

    //指定分组
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
