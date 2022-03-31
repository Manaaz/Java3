
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericStorage<T extends Comparable<T>> {
    private T[] data;

    public GenericStorage(T[] data) {
        this.data = data;
    }

    public T[] getData() {
        return data;
    }

    public void setData(T[] data) {
        this.data = data;
    }

    public void printData() {
        System.out.println(Arrays.toString(data));
    }

    public void exchange(int i, int j) {
        try {
            System.out.println("Перемещение элементов местами: "
                                + "i=" + i
                                + " -> "
                                + "j=" + j);

            T temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Ошибка при перемещении элементов. "
                                + System.lineSeparator()
                                + ex);
        }
    }

    public ArrayList<T> convertArrayToArrayList() {

        List<T> listofObjects = Arrays.asList(data);
        return new ArrayList<T>(listofObjects);

    }
}
