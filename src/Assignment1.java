//
//public class Assignment1 {
//    // O(n)
//    public static int minInt(int n, int[] a){
//        int min = a[0];
//        for (int i = 1; i < n; i++){
//            if(a[i] < min){
//                min = a[i];
//            }
//        }
//        return min;
//    }
//
//    //O(n)
//    public static double average(int n, int[] a){
//        int sum = 0;
//        for (int i = 0; i < n; i++){
//            sum += a[i];
//        }
//        return (sum/n);
//    }
//
//    //O(n)
//    public static boolean isPrimeLinear(int n){
//        if (n < 2){
//            return false;
//        }
//
//        for (int i = 2; i < n; i++){
//            if (n % i == 0){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    //O(n**0.5)
//    public static boolean isPrimeSqrt(int n){
//        if (n < 2){
//            return false;
//        }
//
//        for (int i = 2; i * i <= n; i++){
//            if (n % i == 0){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    //O(n)
//    public static int findFactorial(int n){
//        if (n == 0 || n == 1){
//            return 1;
//        }
//        return n * findFactorial(n - 1);
//    }
//
//    //O(n)
//    public static int findFibonacci(int n){
//        if (n <= 1){
//            return n;
//        }
//        return findFibonacci(n-1) + findFibonacci(n - 2);
//    }
//
//    //O(n)
//    public static int findPow(int n, int p){
//        int s = 1;
//        for (int i = 1; i <= n; i++){
//            s *= p;
//        }
//        return s;
//    }
//
//
//    public static int permutate(char[] a, int n){}
//
//
//
//    public static void main(String[] args) {
//        System.out.println(findFibonacci(17));
//
//    }
//
//}
public class Problem7 {
    public static void main(String[] args) {
        String s = "IOX";
        System.out.println("All permutations of \"" + s + "\":");
        permute(s.toCharArray(), 0);
    }

    // Helper method to generate permutations using backtracking
    public static void permute(char[] arr, int start) {
        if (start == arr.length - 1) {
            System.out.println(String.valueOf(arr));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);
            permute(arr, start + 1);
            swap(arr, start, i); // backtrack
        }
    }

    // Utility method to swap two elements in the array
    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
