import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class Collection {

    public void collection(int intNumber, int arraySize, int... list) {

        int highestUniqueValue = 1;

        Deque<Integer> queue = new LinkedList<>();
        Integer[] subArray;


        // elements of a queue will be transfared into the list
        for (int i = 0; i < intNumber; i++) {
            queue.add(list[i]);
        }

        // elements of a queue will be transfared into the list
        Integer[] queueArray = new Integer[queue.size()];
        queue.toArray(queueArray);


        System.out.println("The number of elements in the set: " + queue.size());
        System.out.println("ArraySize: " + arraySize);
        System.out.println("Queue: " + Arrays.toString(queueArray) + "\n");

        int begin = 0;
        int done = arraySize;

//        copying the content of the queue into the subArray
        for (int i = 0; i < intNumber; i++) {
            subArray = Arrays.copyOfRange(queueArray, begin, done);
            if (queueArray[i].equals(queueArray[intNumber - done + 2])) {
                continue;
            }
            int uniqueNum = uniqueNumb(arraySize, subArray);

            System.out.println(Arrays.toString(subArray) + " has " + uniqueNum + " unique numbers.");
            if (highestUniqueValue <= uniqueNum) {
                highestUniqueValue = uniqueNum;
                begin++;
                done++;
            }
        }
        System.out.println("Highest number of a unique values in SubArray: " + highestUniqueValue);
        System.out.println("");
    }

    // this is a function that finds a unique element
    public int uniqueNumb(int size, Integer[] uniqueArray) {
        int totalNumber = 0;
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(uniqueArray));
        totalNumber = hashSet.size();
        return totalNumber;
    }
}
