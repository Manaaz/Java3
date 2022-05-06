package lesson7;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, MalformedURLException, InvocationTargetException, NoSuchMethodException, InstantiationException {

        Cat cat = new Cat();
        Class<?> catClass = Class.forName("lesson7.Cat");

//        getAll(catClass);
//        getAllDeclared(catClass);
//        getField(catClass, cat);
//        setField(catClass, cat);

//        getCatFromURL();

        getAnnotationMethods(catClass, cat);

    }

    private static void getAll(Class<?> catClass) {
        Field[] fields = catClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("--------------");

        Method[] methods = catClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    private static void getAllDeclared(Class<?> catClass) {
        Field[] fields = catClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("--------------");

        Method[] methods = catClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    private static void getField(Class<?> catClass, Cat cat) throws NoSuchFieldException, IllegalAccessException {
        Field field = catClass.getDeclaredField("secret");
        field.setAccessible(true);
        System.out.println(field.get(cat));
    }

    private static void setField(Class<?> catClass, Cat cat) throws NoSuchFieldException, IllegalAccessException {
        Field field = catClass.getDeclaredField("secret");
        field.setAccessible(true);
        field.set(cat, "10");
        System.out.println(field.get(cat));
    }

    private static void getCatFromURL() throws MalformedURLException, ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> classTomcat = URLClassLoader
                .newInstance(new URL[]{new File("X:\\").toURL()})
                .loadClass("Tomcat");

        Constructor<?> constructor = classTomcat.getConstructor();
        Object tomcat = constructor.newInstance();

        Method method = tomcat.getClass().getDeclaredMethod("work");
        method.setAccessible(true);
        method.invoke(tomcat);
    }

    private static void getAnnotationMethods(Class<?> catClass, Cat cat) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = catClass.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                System.out.print(method.getAnnotation(MyAnnotation.class).priority() + " ");
                method.setAccessible(true);
                method.invoke(cat);
            }
        }
    }
}
