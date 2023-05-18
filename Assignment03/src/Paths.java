import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Paths {
    public static int findPaths(HashMap<Integer, Integer>[] maps, ArrayList<Integer>[] lists, int num) {
        return dfsPath(maps, lists, 1, 0, 0, num, 0);
    }

    private static int dfsPath(HashMap<Integer, Integer>[] maps, ArrayList<Integer>[] lists, int id, int lastId, int sum, int num, int pathNumber){
        if (lists[id].size() == 1 && id != 1){
            pathNumber += (sum == num ? 1 : 0);
            return pathNumber;
        }
        for (int i = 0; i < lists[id].size(); i++) {
             int newId = lists[id].get(i);
             if (newId != lastId){
                 pathNumber = dfsPath(maps, lists, newId, id, sum + maps[id].get(newId), num, pathNumber);
             }
        }
        return pathNumber;
    }


    public static void main(String[] args) throws FileNotFoundException {
        for (int t = 1; t <= 2; t++) {
            // 文件中第一个数字是数组长度，接下来N个数字才是数组元素。
            // 请根据实际情况更改文件路径
            File input = new File("./Assignment03/test_data/Q2/B" + t + ".in");
            if (!input.exists()) {
                System.out.println("File isn't exist");
                System.exit(0);
            }
            Scanner in = new Scanner(input);
            int n = in.nextInt(); //the number of tree nodes
            int num = in.nextInt();// the target number
            HashMap<Integer, Integer>[] maps = new HashMap[n + 1]; // <id, weight>
            for (int i = 0; i < maps.length; i++) {
                maps[i] = new HashMap<>();
            }
            ArrayList<Integer>[] lists = new ArrayList[n + 1]; // connected which id
            for (int i = 0; i < lists.length; i++) {
                lists[i] = new ArrayList<>();
            }
            for (int i = 1; i < n; i++) {
                int id1 = in.nextInt();
                int id2 = in.nextInt();
                int weight = in.nextInt();
                maps[id1].put(id2, weight);
                maps[id2].put(id1, weight);
                lists[id1].add(id2);
                lists[id2].add(id1);
            }

            int pathNumber = findPaths(maps, lists, num);

            File output = new File("./Assignment03/test_data/Q2/B" + t + ".out");
            in = new Scanner(output);
            int ans = in.nextInt();
            boolean flag = ans == pathNumber;
            System.out.println("testcase " + t + " " + flag);
            //System.out.println("ans-" + ans + " " + pathNumber);
        }
    }
}
