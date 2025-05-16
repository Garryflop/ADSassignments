package Practice;

public class quick {
    public static void main(String[] args) {
        int[] a = {2, 10, 5, 7, 1, -1, 6};
        quick q = new quick();
        q.quickSort(a);
        printArray(a);
    }

    public void quickSort(int[] x){
        quickSort(x, 0, x.length - 1);
    }

    private void quickSort(int[] x, int l, int r){
        if(l < r){
            int pi = partition(x, l, r);
            quickSort(x, l, pi - 1);
            quickSort(x, pi + 1, r);
        }
    }

    private int partition(int[] x, int l, int r){
        int pivot = x[r];
        int i = l - 1;
        for (int j = l; j < r; j++){
            if(x[j] <= pivot){
                i++;
                int temp = x[i];
                x[i] = x[j];
                x[j] = temp;
            }
        }
        int temp = x[i + 1];
        x[i + 1] = x[r];
        x[r] = temp;
        return i + 1;
    }

    private static void printArray(int[] x){
        for(int i : x){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
