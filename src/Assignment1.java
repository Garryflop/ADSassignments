import java.util.Scanner;

public class Assignment1 {
    // O(n)
    public static int minInt(int n, int[] a, int min){
        if (min > a[n - 1]){
            min = a[n - 1];
        }
        if (n == 1){
            if (a[n - 1] < min){
                min = a[n - 1];
            }
            return min;
        }

        return minInt(n - 1, a, min);
    }
    //O(n)
    public static double findAvg(int n, int[] a, double sum){
        if (n == 0){
            return sum/a.length;
        }

        return findAvg(n - 1, a, sum + a[n - 1]);
    }
    //O(sqrt(n))
    public static boolean isPrime(int n, int div){
        if (n <= 2){
            return (n == 2);
        }

        if (n % div == 0){
            return false;
        }

        if (div * div > n){
            return true;
        }
        return isPrime(n, div + 1);
    }

    //O(n)
    public static long findFactorial(int n){
        if (n == 0 || n == 1){
            return 1;
        }
        return n * findFactorial(n - 1);
    }

    //O(n)
    public static int findFibonacci(int n){
        if (n <= 1){
            return n;
        }
        return findFibonacci(n-1) + findFibonacci(n - 2);
    }

    //O(n)
    public static int findPow(int n, int p){
        if (p == 0){
            return 1;
        }
        return n * findPow(n, p - 1);
    }

    //O(n * n!)
    public static void permutate(char[] a, int start){
        if (start == a.length - 1){
            System.out.println(String.valueOf(a));
            return;
        }
        for (int i = start; i < a.length; i++){
            swap(a, start, i);
            permutate(a, start + 1);
            swap(a, start, i);
        }
    }

    private static void swap(char[] a, int i, int j){
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //O(n)
    public static boolean isNumber(char[] a, int n){
        if (n == 0 && isDigit(a[n])){
            return true;
        }
        if (isDigit(a[n - 1])){
            return isNumber(a, n - 1);
        }

        return false;

    }

    private static boolean isDigit(char a){
        if (a >= '0' && a <= '9'){
            return true;
        }
        return false;
    }
    //O(2**n)
    public static int binCoef(int n, int k){
        if (k == 0 || k == n){
            return 1;
        }

        return binCoef(n - 1, k - 1) + binCoef(n - 1, k);
    }
    //O(log(n)))
    public static int findGCD(int n, int k){
        if (k == 0){
            return n;
        }

        return findGCD(k, n % k);
    }

    public static void main(String[] args) {
        //1
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] a = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            a[i] = sc.nextInt();
//        }
//        int min = Integer.MAX_VALUE;
//        System.out.println(minInt(n, a, min));
        //2
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] a = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            a[i] = sc.nextInt();
//        }
//        double sum = 0;
//        System.out.println(findAvg(n, a, sum));
        //3
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        if (isPrime(n, 2)){
//            System.out.println("Prime");
//        }
//        else{
//            System.out.println("Composite");
//        }
        //4
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        System.out.println(findFactorial(n));
        //5
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        System.out.println(findFibonacci(n));
        //6
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        System.out.println(findPow(a, b));
        //7
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        permutate(s.toCharArray(), 0);
        //8
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        char[] a = s.toCharArray();
//        System.out.println(isNumber(a, a.length) ? "Yes" : "No");
        //9
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        System.out.println(binCoef(a, b));
        //10
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        System.out.println(findGCD(n, k));
    }
}