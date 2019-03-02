package homework09.task2;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class DemoReflection {
    private  static Object object;
    private  static Method method;

    private static String getClassNameFromXML() {

        String s = Objects.requireNonNull(ClassLoader.getSystemClassLoader()
                .getResource("resources.properties")).getFile();
        File f = new File(s);
        try (BufferedReader reader = new BufferedReader(new FileReader(s))) {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    private Object createInstance(String className) {
        try {
            Class clazz = Class.forName(className);
            object = clazz.newInstance();
            try {
                setData();
                getMethod();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                e.getMessage();
            }

        } catch (
                ClassNotFoundException | IllegalAccessException |
                        InstantiationException | NoSuchMethodException |
                        InvocationTargetException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return object;
    }

    private void getMethod() throws NoSuchMethodException {
        method = object.getClass().getDeclaredMethod("isValidUser");
        method.setAccessible(true);
    }

    private void setData()
            throws NoSuchFieldException,
            IllegalAccessException, NoSuchMethodException,
            InvocationTargetException {
        Field name = object.getClass().getDeclaredField("name");
        object.getClass().getMethod("setName", name.getType()).invoke(object, "Semen Semenich");

        Field email = object.getClass().getDeclaredField("email");
        object.getClass().getMethod("setEmail", email.getType()).invoke(object, "gorbunkov@com");

        Field address = object.getClass().getDeclaredField("address");
        object.getClass().getMethod("setAddress", address.getType()).invoke(object, "Dubrovka");

        Field profession = object.getClass().getDeclaredField("profession");
        object.getClass().getMethod("setProfession", profession.getType()).invoke(object, "contrabandist");

        Field age = object.getClass().getDeclaredField("age");
        object.getClass().getMethod("setAge", age.getType()).invoke(object, "50");
    }


    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        object = new DemoReflection().createInstance(getClassNameFromXML());
        System.out.println(object.toString());
        System.out.println(method.invoke(object));
    }


}