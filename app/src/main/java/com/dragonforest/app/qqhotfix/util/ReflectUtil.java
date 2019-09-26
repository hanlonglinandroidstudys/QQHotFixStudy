package com.dragonforest.app.qqhotfix.util;

import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static android.content.ContentValues.TAG;

/**
 * 反射工具类
 *
 * @author 韩龙林
 * @date 2019/9/26 10:23
 */
public class ReflectUtil {

    /**
     * 反射获取属性 会从所有父类中找，不区分private
     */
    public static Field getField(Class cls, String fieldName) {
        // 如果自己类中找不到 就去父类中递归查找
        Field declaredField = null;
        while (cls != null) {
            Log.e(TAG, "getField: 当前类" + cls.getName());
            try {
                declaredField = cls.getDeclaredField(fieldName);
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                    return declaredField;
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            cls = cls.getSuperclass();
        }
        // 没有找到
        return null;
    }

    /**
     * 反射获取方法 会从所有父类中找，不区分private  注意方法需要传入参数
     */
    public static Method getMethod(Class cls, String methodName, Class<?>... paramTypes) {

        // 如果自己类中找不到 就去父类中递归查找
        Method declaredMethod = null;
        while (cls != null) {
            try {
                declaredMethod = cls.getDeclaredMethod(methodName, paramTypes);
                if (declaredMethod != null) {
                    declaredMethod.setAccessible(true);
                    return declaredMethod;
                }
                cls = cls.getSuperclass();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        // 没有找到
        return null;
    }
}
