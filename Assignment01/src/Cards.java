import java.util.*;

public class Cards {
    /**
     * Using the order the cards are destroyed, calculate the initial order of the cards.
     * @param destroyOrder the order the cards are destroyed.
     * @return the initial order
     */
    public static int[] calculateInitCards( int[] destroyOrder ) {
        LinkedList<Integer> list = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean isDestroy = true;
        for (int i = 1; i <= destroyOrder.length; i++) {
            list.add(i);
        }

        int i = 0;
        while (!list.isEmpty()){
            if (isDestroy){
                map.put(list.get(0), destroyOrder[i]);
                list.remove(0);
                i++;
            } else {
                int temp = list.get(0);
                list.remove(0);
                list.add(temp);
            }
            isDestroy = !isDestroy;
        }
        int[] init = new int[destroyOrder.length];
        for (int j = 0; j < init.length; j++) {
            init[j] = map.get(j + 1);
        }
        return init;
    }

    public static void main( String[] args ) {
        try( Scanner input = new Scanner(System.in) ) {
            int N = input.nextInt();
            int[] destroyOrder = new int[N];
            for( int i = 0; i < N; i ++ )
                destroyOrder[i] = input.nextInt();
            int[] initOrder = calculateInitCards(destroyOrder);
            for( int i : initOrder )
                System.out.println(i);
        }
    }
}