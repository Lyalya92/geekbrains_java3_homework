package lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class MyTester {

    private static Class classObject = new SimpleClassWithMethods().getClass();

    public static void main(String[] args) {
        MyTester.start(classObject);
    }

    public static void start(Class className){
        var hasBeforeSuite = false;
        var hasAfterSuite = false;
        Method [] methods = className.getDeclaredMethods();

        // Find and run BeforeSuite method
        for (Method m: methods) {
          if (m.getAnnotation(BeforeSuiteAnnotation.class) != null) {
              if (hasBeforeSuite) {
                  throw new RuntimeException("Only one BeforeSuite method allowed!");
              } else {
                  hasBeforeSuite = true;
                  try {
                      m.setAccessible(true);
                      m.invoke(className.newInstance());
                  } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                      e.printStackTrace();
                  }
              }

          }
        }

        // Add all methods with TestAnnotation to TreeMap
        TreeMap <Integer, HashSet<Method>> methodsTreeMap = new TreeMap<>();
        for (Method m: methods) {
            if(m.getAnnotation(TestAnnotation.class) != null) {
                var priority = m.getAnnotation(TestAnnotation.class).priority();
                if (methodsTreeMap.containsKey(priority)) {
                    methodsTreeMap.get(priority).add(m);
                } else {
                    HashSet <Method> temp = new HashSet<>();
                    temp.add(m);
                    methodsTreeMap.put(priority,temp);
                }
            }
        }

        // Run all methods one after another depending on the priority
        for (Map.Entry entry: methodsTreeMap.entrySet())
              {
                  for (Method method : (HashSet<Method>) entry.getValue()){
                      try {
                          if (Modifier.isPrivate(method.getModifiers()))  { method.setAccessible(true); }
                          method.invoke(className.newInstance());
                      } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                          e.printStackTrace();
                      }

                  }
              }


        // Find and run AfterSuite method
        for (Method m: methods) {
            if (m.getAnnotation(AfterSuiteAnnotation.class) != null) {
                if (hasAfterSuite) {
                    throw new RuntimeException("Only one AfterSuite method allowed!");
                } else {
                    hasAfterSuite = true;
                    try {
                        if (Modifier.isPrivate(m.getModifiers()))  { m.setAccessible(true); }
                        m.invoke(className.newInstance());
                    } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

}
