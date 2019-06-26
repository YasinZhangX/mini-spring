package com.yasin.core;

import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author yasin
 */
public class ClassScanner {

    public static List<Class<?>> scanClasses(String packageName) throws IOException, ClassNotFoundException {
        List<Class<?>> classList = new ArrayList<>();

        String path = packageName.replace(".", "/"); // 获取包路径
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader(); // 获取类加载器
        Enumeration<URL> resources = classLoader.getResources(path);    // 获取类中资源

        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            if (resource.getProtocol().contains("jar")) {  // 处理jar包资源
                JarURLConnection jarURLConnection = (JarURLConnection)resource.openConnection();
                String jarFilePath = jarURLConnection.getJarFile().getName();
                classList.addAll(getClassNameFromJar(jarFilePath, path));
            } else {
                // TODO: 其他资源处理
            }
        }

        return classList;
    }

    private static List<Class<?>> getClassNameFromJar(String jarFilePath, String path) throws IOException, ClassNotFoundException {
        List<Class<?>> classList = new ArrayList<>();

        JarFile jarFile = new JarFile(jarFilePath);
        Enumeration<JarEntry> jarEntries = jarFile.entries();
        while (jarEntries.hasMoreElements()) {
            JarEntry jarEntry = jarEntries.nextElement();
            String entryName = jarEntry.getName();    // 例如com/yasin/test/Test.class
            if (entryName.startsWith(path) && entryName.endsWith(".class")) {
                String classFullName = entryName.replace("/", ".").substring(0, entryName.length()-6);
                classList.add(Class.forName(classFullName));
            }
        }

        return classList;
    }

}
