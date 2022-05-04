import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {



    @Test
    void quest5_getArrayOk() {
        int[] arrExp = {3,3,3,3,3,3,3,3,3,3};
        int[] arrFact = Main.quest5_getArray(10, 3);
        Assertions.assertArrayEquals(arrExp, arrFact);
    }
    @Test
    void quest5_getArrayError() {
        int[] arrExp = {3,3,3,3,3,3,3,3,3,4};
        int[] arrFact = Main.quest5_getArray(10, 3);
        Assertions.assertArrayEquals(arrExp, arrFact);
    }

    @Test
    void quest8_arraySort_shuffleForward1() {

        int[] arrExp = {6,1,2,3,4,5};
        int[] arr = Main.getTestingArr();
        arr = Main.quest8_arrShuffleOneArray(arr, 1);
        Assertions.assertArrayEquals(arrExp, arr);

    }

    @Test
    void quest8_arraySort_shuffleForward2() {

        int[] arrExp = {5, 6, 1, 2, 3, 4};
        int[] arr = Main.getTestingArr();

        arr = Main.getTestingArr();
        Main.quest8_arrShuffleOneArray(arr, 2);
        Assertions.assertArrayEquals(arrExp, arr);

    }

    @Test
    void quest8_arraySort_shuffleForward3_Error() {

        int[] arrExp = {4, 5, 6, 1, 2, 3};
        int[] arr = Main.getTestingArr();

        arr = Main.getTestingArr();
        Main.quest8_arrShuffleOneArray(arr, 2);
        Assertions.assertArrayEquals(arrExp, arr);

    }

    @Test
    void quest8_arraySort_shuffleBack() {

        int[] arrExp = new int[]{2, 3, 4, 5, 6, 1};
        int[] arr = Main.getTestingArr();
        Main.quest8_arrShuffleOneArray(arr, -1);
        Assertions.assertArrayEquals(arrExp, arr);

    }

}