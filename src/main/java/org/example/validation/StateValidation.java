/**
 * @author 33319
 * @Description
 * @create 2024/6/17 21:40
 */
package org.example.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.anno.State;

//ConstraintValidator<给哪个注解提供规则，校验的数据类型>
public class StateValidation implements ConstraintValidator<State, String> {
    /**
     * @param value   将来要校验的数据
     * @param context 定义了校验的一些默认规则
     * @return 校验成功返回true，校验失败返回false
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //提供校验规则
        if (value == null) {
            return false;
        }
        if (value.equals("已发布") || value.equals("草稿")) {
            return true;
        }
        return false;
    }
}
