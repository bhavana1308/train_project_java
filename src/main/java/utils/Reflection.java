package utils;

import trains.Passenger;

import java.lang.reflect.*;


public class Reflection {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {

        Passenger obj = new Passenger("Mary", "Keller", 72);
        Class c = Class.forName("trains.Passenger");

        //Constructor array
        Constructor[] constructors = c.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("Name of Constructor : " + constructor);
            System.out.println("Count of constructor parameter : " + constructor.getParameterCount());
            Parameter[] parameters = constructor.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("Constructor's parameter : " + parameter);
            }
            System.out.println();
        }
        System.out.println();

        //Method Array
        Method[] methods = c.getDeclaredMethods();
        System.out.println("Length of method : " + methods.length);
        for (Method method : methods) {
            System.out.println("Method name: \t" + method);
            System.out.println("Method return type : \t" + method.getReturnType());
            System.out.println("Modifier: " + Modifier.toString(method.getModifiers()));
            System.out.println("Method parameter count: \t" + method.getParameterCount());
            System.out.println();
            String methodName = method.getName();
            if (methodName.equals("setAge")) {
                method.setAccessible(true);
                method.invoke(obj, 75);
            }
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("Method's Parameter : " + parameter);
            }
            System.out.println();
        }
        System.out.println();

        //Classes
        Class[] classes = c.getDeclaredClasses();
        for (Class class1 : classes) {
            System.out.println("class: " + class1);
            System.out.println("Name of class: " + class1.getName());
        }

        //Fields
        Field[] fields = c.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());

        }
    }

}
