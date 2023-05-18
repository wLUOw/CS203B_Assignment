import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parents {
    public static int[] findParents(int n, ArrayList<Integer>[] lists) {
        int[] parents = new int[n];
        parents[0] = -1;
        parents = dfs(parents, lists, 1, 0);
        return parents;
    }

    private static int[] dfs(int[] parents, ArrayList<Integer>[] lists, int node, int lastNode){
        for (int i = 0; i < lists[node].size(); i++) {
            if (lists[node].get(i) != lastNode){
                parents[lists[node].get(i) - 1] = node;
                dfs(parents, lists, lists[node].get(i), node);
            }
        }
        return parents;
    }

    public static void main(String[] args) throws FileNotFoundException {

        for (int t = 1; t <= 2; t++) {
            // 文件中第一个数字是数组长度，接下来N个数字才是数组元素。
            // 请根据实际情况更改文件路径
            File input = new File("./Assignment03/test_data/Q1/A" + t + ".in");
            if (!input.exists()) {
                System.out.println("File isn't exist");
                System.exit(0);
            }
            Scanner in = new Scanner(input);
            int n = in.nextInt();  //the number of tree nodes
            ArrayList<Integer>[] lists = new ArrayList[n + 1]; // connected which id
            for (int i = 0; i < lists.length; i++) {
                lists[i] = new ArrayList<>();
            }
            for (int i = 0; i < n - 1; i++) {
                int n1 = in.nextInt();
                int n2 = in.nextInt();
                lists[n1].add(n2);
                lists[n2].add(n1);
            }

            int[] parents = findParents(n, lists);

            File output = new File("./Assignment03/test_data/Q1/A" + t + ".out");
            in = new Scanner(output);
            boolean flag = true;

            for (int i = 0; i < n; i++) {
                if (in.nextInt() != parents[i]) {
                    flag = false;
                    break;
                }
            }
            System.out.println("testcase " + t + " " + flag);
        }
    }
}
