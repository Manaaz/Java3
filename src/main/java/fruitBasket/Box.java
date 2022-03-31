package fruitBasket;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    private T fruit;
    private ArrayList<T> fruits = new ArrayList<>();

    public Box(T fruit, int amount) {
        setFruits(fruit, amount);
    }

    private void setFruits(T fruit, int amount) {
        this.fruit = fruit;
        fruits = new ArrayList<T>();
        for (int i = 0; i < amount; i++) {
            fruits.add(fruit);
        }
    }

    private void clearFruits() {
        fruits.clear();
        fruit = null;
    }

    public T getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return fruits.size();
    }

    public void addQuantity(T addedFruit) {
        fruits.add(addedFruit);
    }

    public void minusQuantity(T deletedFruit) {
        if(fruits.size() > 0) {
            fruits.remove(deletedFruit);
        }
    }

    public float getBasketWeight() {
        if(fruit != null) return getQuantity() * fruit.getWeight();
        else return 0f;
    }

    public boolean compare(Box<?> box) {
        return Math.abs(getBasketWeight() - box.getBasketWeight())  < 0.0000001;
    }

    public void moveContent(Box<T> box2) {
        if (box2.getQuantity() == 0) {
            box2.setFruits(this.getFruit(), this.getQuantity());
            this.clearFruits();
        }
    }

}
