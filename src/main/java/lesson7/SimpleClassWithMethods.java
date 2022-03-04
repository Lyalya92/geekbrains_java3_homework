package lesson7;

public class SimpleClassWithMethods {

    public SimpleClassWithMethods() {
    }

    @BeforeSuiteAnnotation
    private void beforeSuiteMethod(){
        System.out.println("BeforeSuite");
    }

    @AfterSuiteAnnotation
    private void afterSuiteMethod(){
        System.out.println("AfterSuite");
    }

    @TestAnnotation(priority = 1)
    private void method1(){
        System.out.println("Run method with priority 1");
    }

    @TestAnnotation(priority = 10)
    public void method2(){
        System.out.println("Run method with priority 10");
    }

    @TestAnnotation(priority = 2)
    public void method3(){
        System.out.println("Run method with priority 2");
    }

    @TestAnnotation
    private void method4(){
        System.out.println("Run method with default priority (default = 5)");
    }

    @TestAnnotation(priority = 2)
    private void method5(){
        System.out.println("Run method with priority 2");
    }
}
