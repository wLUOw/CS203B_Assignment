import java.io.File;
import java.util.Scanner;

public class TestProg {
    public static void main(String[] args) {
        for(int i = 1; i <= 10; i++) {
            test("testing data", i);
        }

        System.out.println();

        for (int i = 1; i <= 10; i++) {
            test("extra data", i);
        }
    }

    private static void test(String data, int i){
        try {
            File input = new File("./Assignment02/" + data + "/" + i + ".in");
            Scanner in = new Scanner(input);
            int N  = in.nextInt();
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = in.nextInt();
            }

            File output = new File("./Assignment02/" + data + "/" + i + ".out");
            Scanner out = new Scanner(output);
            int[] ans = new int[N];
            for (int j = 0; j < N; j++) {
                ans[j] = out.nextInt();
            }

            boolean isRight = true;
            int[] res = Median.findMedians(arr);
            for (int j = 0; j < N; j++) {
                if (ans[j] != res[j]){
                    isRight = false;
                    break;
                }
            }
            System.out.println(data + i + " " + (isRight ? "Pass" : "Fail"));

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
