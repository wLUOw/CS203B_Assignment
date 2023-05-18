import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Median {
    public static int[] findMedians(int[] array){
        MaxHeap maxHeap = new MaxHeap();
        MinHeap minHeap = new MinHeap();
        for (int i = 0; i < array.length; i++) {
            addElement(array[i], maxHeap, minHeap);
            array[i] = getMid(maxHeap);
        }
        return array;
    }

    public static void addElement(int k, MaxHeap heap1, MinHeap heap2){
        if (heap1.size() == 0 || heap1.getMax() > k){
            heap1.push(k);
            if (heap1.size() > heap2.size() + 1){
                heap2.push(heap1.getMax());
                heap1.pop();
            }
        } else {
            heap2.push(k);
            if (heap1.size() < heap2.size()){
                heap1.push(heap2.getMin());
                heap2.pop();
            }
        }
    }

    public static int getMid(MaxHeap heap1){
        return heap1.getMax();
    }

    public static void main(String[] args) throws FileNotFoundException {

        File input = new File("./Assignment02/testing data/sample input.txt");
        if(!input.exists()) {
            System.out.println("File isn't exist");
            System.exit(0);
        }
        Scanner in = new Scanner(input);
        int N  = in.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = in.nextInt();
        }
        int[] result = findMedians(array);

        File output = new File("./Assignment02/testing data/sample output.txt");
        in = new Scanner(output);
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            if(in.nextInt() != result[i]) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }
}
