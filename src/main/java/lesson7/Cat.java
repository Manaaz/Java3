package lesson7;

public class Cat {
    public String name;
    protected int age = 4;
    private String secret = "Я подрал диван";

    public void voice() {
        System.out.println("Мяу!");
    }

    protected void run() {
        System.out.println("Тыгдык!");
    }

    private void work() {
        System.out.println("Кот устраивается на работу программистом");
    }

    @MyAnnotation(priority = 5)
    private void test1() {
        System.out.println("Один");
    }

    private void test2() {
        System.out.println("Два");
    }

    @MyAnnotation(priority = 4)
    private void test3() {
        System.out.println("Три");
    }

    @MyAnnotation
    private void test4() {
        System.out.println("Четыре");
    }

    private void test5() {
        System.out.println("Пять");
    }


}
