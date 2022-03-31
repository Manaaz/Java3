import fruitBasket.Apple;
import fruitBasket.Box;
import fruitBasket.Orange;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //task 1:
        switchArrayElements();

        //task 2:
        convertArrayToArrayList();

        //task 3:
        generateBasket();

    }

    private static void switchArrayElements() {

        System.out.println("task 1:");

        Integer[] data = new Integer[]{1,2,3};
        GenericStorage<Integer> arrObj = new GenericStorage<>(data);

        arrObj.printData();

        arrObj.exchange(2,0);
        arrObj.printData();

        arrObj.exchange(2,1);
        arrObj.printData();

        arrObj.exchange(3,2);
        arrObj.printData();


        String[] data2 = new String[] {"test1", "test2", "test3"};
        GenericStorage<String> arrObj2 = new GenericStorage<>(data2);

        arrObj2.printData();

        arrObj2.exchange(2,0);
        arrObj2.printData();

        arrObj2.exchange(2,1);
        arrObj2.printData();

        arrObj2.exchange(3,2);
        arrObj2.printData();

    }

    private static void convertArrayToArrayList() {

        System.out.println("task 2:");

        String[] arrStr = new String[]{"a","b","c","d","q","w","e","r","t","y"};

        GenericStorage<?> arrObj = new GenericStorage<>(arrStr);

        arrObj.printData();

        ArrayList<?> newArayList = arrObj.convertArrayToArrayList();

        System.out.println(newArayList.toString());

    }

    private static void generateBasket() {

        System.out.println("task 3:");

        Apple appleFruit = new Apple();
        Orange orangeFruint = new Orange();

        Box<Apple> appleBox = new Box<>(appleFruit, 10);

        appleBox.addQuantity(appleFruit);
        appleBox.addQuantity(appleFruit);

        System.out.println("Корзина фруктов: " + appleBox.getFruit().getName());
        System.out.println("Количество: " + appleBox.getQuantity());
        System.out.println("Вес корзины: " + appleBox.getBasketWeight());

        appleBox.addQuantity(appleFruit);
        appleBox.addQuantity(appleFruit);

        System.out.println("Количество после добавления новых: " + appleBox.getQuantity());
        System.out.println("Вес корзины: " + appleBox.getBasketWeight());


        Box<Orange> orangeBox = new Box<>(orangeFruint, 10);

        orangeBox.addQuantity(orangeFruint);
        orangeBox.addQuantity(orangeFruint);

        System.out.println("Корзина фруктов: " + orangeBox.getFruit().getName());
        System.out.println("Количество: " + orangeBox.getQuantity());
        System.out.println("Вес корзины: " + orangeBox.getBasketWeight());

        orangeBox.minusQuantity(orangeFruint);
        orangeBox.minusQuantity(orangeFruint);

        System.out.println("Количество после добавления новых: " + orangeBox.getQuantity());
        System.out.println("Вес корзины: " + orangeBox.getBasketWeight());


        //System.out.println("compare basket1 & basket2" + appleBox.compare());
        System.out.println("move basket1 -> basket3, and clear basket1");

        Box<Apple> appleBox2 = new Box<>(appleFruit, 0);
        appleBox.moveContent(appleBox2);

        System.out.println("Вес новой корзины: " + appleBox2.getBasketWeight());
        System.out.println("Вес старой корзины: " + appleBox.getBasketWeight());

    }

}

