import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class GenData {
    public static void main(String[] args) {

        new File("./Assignment02/extra data/").mkdirs();

        for( int i = 1; i <= 10; i++ ) {
            int[] arr = randomArray();

            try (PrintWriter out = new PrintWriter("./Assignment02/extra data/" + i + ".in")){
                out.println(10000);
                for(int j = 0; j < arr.length; j++){
                    out.println(arr[j]);
                }
            } catch ( IOException e ) {
                e.printStackTrace();
            }

            int[] ans = getAns(arr);
            try(PrintWriter out = new PrintWriter("./Assignment02/extra data/" + i + ".out")){
                for(int j = 0; j < ans.length; j++){
                    out.println(ans[j]);
                }
            } catch ( IOException e ) {
                e.printStackTrace();
            }
        }
    }

    private static int[] randomArray(){
        int[] arr = new int[10000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(20000) - 10000;
        }
        return arr;
    }

    private static int[] getAns(int[] arr){
        int[] ans = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            sort(arr, 0, i);
            ans[i] = arr[i / 2];
        }
        return ans;
    }

    private static void sort(int[] array, int lo, int hi){
        if (hi <= lo){
            return;
        }
        int i = lo;
        int j = hi + 1;
        int v = array[lo];
        while (true) {
            while (array[++i] < v) {
                if (i == hi){
                    break;
                }
            }
            while (v < array[--j]){
                if(j == lo){
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(array, i, j);
        }
        exch(array, lo, j);

        sort(array, lo, j - 1);
        sort(array, j + 1, hi);
    }

    private static void exch(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
