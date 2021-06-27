package com.inbetter.camp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassLoaderChecker {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String path = System.getProperty("user.dir") + "/src/com/inbetter/camp/";
        XlassClassLoader m = new XlassClassLoader(path, "Hello");
        Class c = m.loadClass("Hello");
        Object o = c.newInstance();
        Method hello = c.getMethod("hello");
        hello.invoke(o);
    }

}
