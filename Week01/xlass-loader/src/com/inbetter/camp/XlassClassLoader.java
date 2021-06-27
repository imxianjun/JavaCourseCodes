package com.inbetter.camp;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Homework:
 * 自定义一个 Classloader，
 * 加载一个 Hello.xlass 文件，
 * 执行 hello 方法，
 * 此文件内容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件
 */
public class XlassClassLoader extends ClassLoader {
    private String path;
    private String classLoaderName;

    public XlassClassLoader(String path, String classLoaderName) {
        this.path = path;
        this.classLoaderName = classLoaderName;
    }

    @Override
    public Class findClass(String name) {
        byte[] b = decode(loadClassData(name));
        return defineClass(name, b, 0, b.length);
    }

    private byte[] decode(byte[] byteArray){
        byte[] targetArray = new byte[byteArray.length];
        for (int i = 0; i < byteArray.length; i++) {
            targetArray[i] = (byte) (255 - byteArray[i]);
        }
        return targetArray;
    }

    private byte[] loadClassData(String name) {
        name = path + name + ".xlass";
        InputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            in = new FileInputStream(new File(name));
            out = new ByteArrayOutputStream();
            int i = 0;
            while ((i = in.read()) != -1) {
                out.write(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return out.toByteArray();
    }

}
