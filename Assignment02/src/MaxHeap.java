class MaxHeap{

    private static final int MAXSIZE = 500001;
    private int[] a;

    public MaxHeap() {
        a = new int[MAXSIZE];
    }

    public void push(int k){
        a[++a[0]] = k;
        swim();
    }

    public void pop(){
        int s = 2, t = 1;
        a[1] = a[a[0]--];
        while (s <= a[0]){
            if (s <= a[0] - 1 && a[s + 1] > a[s]){
                s++;
            }
            if (a[s] > a[t]){
                exch(s, t);
                t = s;
                s *= 2;
            } else {
                break;
            }
        }
    }

    public int getMax(){
        return a[1];
    }

    public int size(){
        return a[0];
    }

    private void exch(int x, int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    private void swim(){
        int p = a[0];
        while(p > 1){
            if (a[p] > a[p / 2]){
                exch(p,p / 2);
                p /= 2;
            } else {
                break;
            }
        }
    }

}