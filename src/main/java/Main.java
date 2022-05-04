import java.util.Arrays;

public class Main {

    //Константы для задания №8
    static int newVal;
    static int previousVal;

    public static void main(String[] args){

        quest1_numberReplace();
        quest2_arrayFiller();
        quest3_multiply();
        quest4_getMatrix();
        int[] arr5 = quest5_getArray(10, 3);
        quest6_arraySort();
        quest7();
        quest8();

    }

    static void quest1_numberReplace(){

        System.out.println("Quest 1:");

        int[] arr = {1,1,0,0,1,0,1,1,0,0};

        for (int i = 0; i < arr.length; i++){
            System.out.print("old: " + arr[i]);
            arr[i] = arr[i] == 0 ? 1 : 0;
            System.out.println(" new: " + arr[i]);
        }

        System.out.println();

    }

    static void quest2_arrayFiller(){

        System.out.println("Quest 2:");

        int[] arr = new int[100];

        int count = 1;
        for (int i =0; i<arr.length; i++){
            arr[i] = count++;
            System.out.println("i = " + i + " arr[i] = " + arr[i]);
        }

        System.out.println();

    }

    static void quest3_multiply(){

        System.out.println("Quest 3:");

        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i =0; i<arr.length; i++){
            System.out.print("old arr[i] value = " + arr[i]);
            if (arr[i] < 6){
                arr[i] *= 2;
            }
            System.out.println(", new arr[i] = " + arr[i]);
        }

        System.out.println();

    }

    static void quest4_getMatrix(){

        System.out.println("Quest 4:");

        int arrayDeep = 9;
        int[][] arr = new int[arrayDeep][arrayDeep];

        for (int i = 0; i < arr.length; i++){

            for (int j = 0; j < arr.length; j++){

                arr[i][j] = i == j ? 1 : 0;

                int x = arr.length - 1 - i;

                if(j == x) {
                    arr[i][j] = 1;
                }

                System.out.print(arr[i][j] + " ");
            }

            System.out.println();

        }

        System.out.println();

    }

    static int[] quest5_getArray(int len, int initialValue){

        System.out.println("Quest 5:");

        int[] arr = new int[len];
        for(int i = 0; i < len; i++){
            arr[i] = initialValue;
        }

        System.out.println("len: " + len + ", initVal: " + initialValue + ", " + Arrays.toString(arr));
        System.out.println();

        return arr;
    }

    static void quest6_arraySort(){

        System.out.println("Quest 6:");

        int[] intArray = {24, 340, 13, 34, 12, 10, 20};

        Arrays.sort(intArray);

        int maxNum = intArray[intArray.length - 1];

        System.out.println("Minimum number = " + intArray[0]);
        System.out.println("Maximum number = " + maxNum);
        System.out.println();
    }

    static void quest7(){
        System.out.println("Quest 7: ");
        int[] arr2 = {1,1,1,2,1};
        Boolean result = quest7_checkBalance(arr2);
        int[] arr3 = {2, 2, 2, 1, 2, 2, 10, 1};
        quest7_checkBalance(arr3);
        int[] arr4 = {2, 5, 6, 1, 3, 10, 1};
        quest7_checkBalance(arr4);
        int[] arr5 = {2, 5, 6, 1, 4, 3, 10, 1};
        quest7_checkBalance(arr5);
        System.out.println();
    }

    static boolean quest7_checkBalance(int[] arr){

        boolean result = false;
        int arrLength = arr.length - 1;
        int leftArrCount;

        System.out.println("arr:  " + Arrays.toString(arr));

        if (arrLength <= 0){
            System.out.println("Error. Need more array values");
            return false;
        }

        //my result {
        for (leftArrCount = 0; leftArrCount <= arrLength; leftArrCount++) {

            int leftSum = 0;
            int rightSum = 0;

            for (int i = 0; i <= leftArrCount; i++){
                leftSum += arr[i];
            }

            for (int i = arrLength; i > leftArrCount; i--){
                rightSum += arr[i];
            }

            if (leftSum == rightSum){
                result = true;
                break;
            }

        }
        //my result }

        //super result {
        int leftArrCount2;
        int leftSum2 = 0;
        int sum = Arrays.stream(arr).sum();

        if(sum%2 != 0){
            return false;
        }

        for (leftArrCount2 = 0; leftArrCount2 <= arrLength; leftArrCount2++){
            leftSum2 += arr[leftArrCount2];
            sum -= arr[leftArrCount2];
            if(leftSum2 == sum){
                result = true;
                break;
            }
        }
        //super result }

        System.out.println("Result - true, on element: " + leftArrCount);
        return result;
    }

    static void quest8(){

        int[] arr = getTestingArr();
        quest8_arrShuffleOneArray(arr, 1);
        arr = getTestingArr();
        quest8_arrShuffleOneArray(arr, 2);
        arr = getTestingArr();
        quest8_arrShuffleOneArray(arr, 9);

        System.out.println();

        arr = getTestingArr();
        quest8_arrShuffleOneArray(arr, -1);
        arr = getTestingArr();
        quest8_arrShuffleOneArray(arr, -2);
        arr = getTestingArr();
        quest8_arrShuffleOneArray(arr, -9);
    }

    static int[] getTestingArr(){
        return new int[]{1,2,3,4,5,6};
    }

    static int[] quest8_arrShuffleOneArray(int[] arr, int moveByQuantity) {

        System.out.println("Quest 8: 1 array");
        System.out.println("Shift:"+moveByQuantity+" times, arr: " + Arrays.toString(arr));

        int arrLength = arr.length;

        if (moveByQuantity > 0){
            arrayShiftPlus(arr, arrLength, moveByQuantity);
        } else {
            arrayShiftMinus(arr, arrLength, moveByQuantity);
        }

        System.out.println("Shift:"+moveByQuantity+" times, result arr: " + Arrays.toString(arr));

        return arr;
    }

    static void arrayShiftPlus(int[] arr, int arrLength, int moveByQuantity){
        int newPosition = 0;

        while(moveByQuantity > 0){

            int i;
            for (i = 0; i < arr.length; i++) {

                newPosition = getNewArrayPositionPlus(arrLength, newPosition);
                getNewArrayValues(arr, i, newPosition);
                arr[newPosition] = newVal;

            }
            newPosition = getNewArrayPositionPlus(arrLength, newPosition);
            arr[newPosition] = previousVal;

            moveByQuantity--;
        }
    }

    static int getNewArrayPositionPlus(int arrLength, int currentPosition){
        if (currentPosition == arrLength - 1) {
            currentPosition = 0;
        } else {
            currentPosition++;
        }
        return currentPosition;
    }

    static void arrayShiftMinus(int[] arr, int arrLength, int moveByQuantity){
        int newPosition = 0;

        while(moveByQuantity < 0){

            int i;
            for (i = 0; i < arr.length; i++) {

                newPosition = getNewArrayPositionMinus(arrLength, newPosition);
                getNewArrayValues(arr, i, newPosition);
                arr[newPosition] = newVal;

            }
            newPosition = getNewArrayPositionMinus(arrLength, newPosition);
            arr[newPosition] = previousVal;

            moveByQuantity++;
        }
    }

    static int getNewArrayPositionMinus(int arrLength, int currentPosition){
        if (currentPosition == 0) {
            currentPosition = arrLength - 1;
        } else {
            currentPosition--;
        }
        return currentPosition;
    }

    static void getNewArrayValues(int[] arr, int i, int newPosition){
        if (Integer.bitCount(previousVal) == 0) {
            newVal = arr[i];
        } else {
            newVal = previousVal;
        }
        previousVal = arr[newPosition];
    }

}
