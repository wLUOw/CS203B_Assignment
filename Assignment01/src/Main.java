import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Main {
    public static void main(String[] args) {

        for(int i = 1; i <= 2; i++) {
            try {

                In fin1 = new In("./Assignment01/data/" + i + ".in");
                int[] arr0 = fin1.readAllInts();
                int[] arr = new int[arr0[0]];
                for (int j = 0; j < arr.length; j++) {
                    arr[j] = arr0[j + 1];
                }
                fin1.close();

                In fin2 = new In("./Assignment01/data/" + i + ".out");
                int[] ans = fin2.readAllInts();
                fin2.close();

                boolean isRight = true;
                int[] res = Cards.calculateInitCards(arr);
                for (int j = 0; j < arr0[0]; j++) {
                    if (ans[j] != res[j]){
                        isRight = false;
                        break;
                    }
                }
                StdOut.println("data" + i + " " + (isRight ? "Pass" : "Fail"));

            } catch (Exception e){
                e.printStackTrace();
            }
        }

        for(int i = 1; i <= 20; i++) {
            try {

                In fin1 = new In("./Assignment01/extra data/" + i + ".in");
                int[] arr0 = fin1.readAllInts();
                int[] arr = new int[arr0[0]];
                for (int j = 0; j < arr.length; j++) {
                    arr[j] = arr0[j + 1];
                }
                fin1.close();

                In fin2 = new In("./Assignment01/extra data/" + i + ".out");
                int[] ans = fin2.readAllInts();
                fin2.close();

                boolean isRight = true;
                int[] res = Cards.calculateInitCards(arr);
                for (int j = 0; j < arr0[0]; j++) {
                    if (ans[j] != res[j]){
                        isRight = false;
                        break;
                    }
                }
                StdOut.println("extra data" + i + " " + (isRight ? "Pass" : "Fail"));

            } catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
