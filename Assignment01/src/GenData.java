import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class GenData {
    public static void main( String[] args ) {

        new File("./Assignment01/extra data/").mkdirs();

        for( int i = 1; i <= 20; i++ ) {
            int[] arr = randomSort();
            int[] ans = getAns(arr);
            try(PrintWriter fout = new PrintWriter("./Assignment01/extra data/" + i + ".in")){
                fout.println(10000);
                for(int j = 0; j < ans.length; j++){
                    fout.println(ans[j]);
                }
            } catch ( IOException e ) {
                e.printStackTrace();
            }
            try(PrintWriter fout = new PrintWriter("./Assignment01/extra data/" + i + ".out")){
                for(int j = 0; j < arr.length; j++){
                    fout.println(arr[j]);
                }
            } catch ( IOException e ) {
                e.printStackTrace();
            }
        }

    }

    private static int[] randomSort(){
        int[] arr = new int[10000];
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= arr.length; i++) {
            list.add(i);
        }
        for (int i = 0; i < arr.length; i++) {
            int index = random.nextInt(list.size());
            arr[i] = list.remove(index);
        }
        return arr;
    }

    public static int[] getAns(int[] arr){
        LinkedList<Integer> list = new LinkedList<>();
        int[] ans = new int[arr.length];
        boolean isDestroy = true;
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        int i = 0;
        while (!list.isEmpty()){
            if (isDestroy){
                ans[i] = list.get(0);
                list.remove(0);
                i++;
            } else {
                int temp = list.remove(0);
                list.add(temp);
            }
            isDestroy = !isDestroy;
        }

        return ans;
    }

}