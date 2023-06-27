import java.util.*;

class solution {
    // combination helper using recursive approah-->
    private static void getCombination(int index, int sum, int[] arr, int k, ArrayList<Integer> a,
            ArrayList<ArrayList<Integer>> re) {
        if (index == arr.length) {
            if (sum == k) {
                re.add(new ArrayList<>(a));
            }
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[index])
                continue;
            a.add(arr[i]);
            getCombination(i + 1, sum + arr[i], arr, k, a, re);
            a.remove(a.size() - 1);
        }
    }

    // combination sum of target double--->
    private static ArrayList<ArrayList<Integer>> combSumElement(int[] arr, int k) {
        ArrayList<ArrayList<Integer>> re = new ArrayList<>();
        getCombination(0, 0, arr, k, new ArrayList<>(), re);
        return re;
    }

    // 2d array convert into sinle array--->
    private static int[] twoArraytoSingleArray(int[][] arr) {
        int[] result = new int[arr.length * 2];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            result[index++] = arr[i][0];
            result[index++] = arr[i][1];
        }

        return result;
    }

    // sum of two Integer equals to traget--->
    private static int[][] sumOfTwoInteEqualsToTarget(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        ArrayList<int[]> arrayList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {

                int v = k - arr[i];
                if (set.contains(v)) {
                    int[] r = { v, arr[i] };
                    arrayList.add(r);
                }
            } else {
                int v = -(k - arr[i]);
                if (set.contains(v)) {
                    int[] r = { v, arr[i] };
                    arrayList.add(r);
                }
            }
            set.add(arr[i]);
        }
        int[][] result = new int[arrayList.size()][2];
        int index = 0;
        for (int i = 0; i < result.length; i++) {
            result[index][0] = arrayList.get(i)[0];
            result[index][1] = arrayList.get(i)[1];
            index++;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // taking size of array from user -->
        int n = sc.nextInt();
        int[] arr = new int[n];// initialize array with size n;

        // taking value of each index of array from user -->
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();// target value;

        // Task 1-->
        int[][] sumOfInte = sumOfTwoInteEqualsToTarget(arr, k);

        // print pair of sum of two Integer equal to target value-->
        System.out.print("First Combination For " + k + " ");
        for (int i = 0; i < sumOfInte.length; i++) {
            System.out.print("[" + sumOfInte[i][0] + "," + sumOfInte[i][1] + "]");
        }
        System.out.println();

        // Task 2-->
        int[] singleArray = twoArraytoSingleArray(sumOfInte);
        Arrays.sort(singleArray);// array sort -->

        System.out.print("Merge Into a single Array ");
        // convert 2d into single array and print--->
        for (int i = 0; i < singleArray.length; i++) {
            System.out.print(singleArray[i] + " ");
        }

        System.out.println();

        // Task 3-->
        List<ArrayList<Integer>> result = combSumElement(singleArray, k * 2);

        System.out.println("Second Combination For " + k * 2);
        // print list combination sum of Integer equals to k*2 -->
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }
}
