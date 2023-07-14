package person.zh.search;

public class Search {
    public static void main(String[] args) {
        int arr[] = {1, 2, 30, 788, 789, 999, };
//        int resIndex = binarySearch(arr, 0, arr.length - 1, 30);
        int resIndex = insertValueSearch(arr, 0, arr.length - 1, 30);
        int resIndex1 = binarySearchNoRecursion(arr, 0);
        System.out.println("resIndex1:" + resIndex1);
    }

    // 非递归二分查找
    public static int binarySearchNoRecursion(int arr[], int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;  // 没找到
    }

    /**
     *
     * @param arr   有序数组
     * @param left  查找起点
     * @param right 查找终点
     * @param findVal   要查找的值
     * @return  如果找到就返回索引，找不到就返回-1
     */
    public static int binarySearch(int arr[], int left, int right, int findVal) {
        if (left > right || arr[0] > findVal || arr[arr.length - 1] < findVal) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (findVal > arr[mid]) {
            // 去右边找
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < arr[mid]) {
            // 去左边找
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }

    public static int insertValueSearch(int arr[], int left, int right, int findVal) {
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]) ;
        if (findVal > arr[mid]) {
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < arr[mid]){
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }


    double eps = 0.0000001;
    int N;
    double l, r;
    double[] A = new double[20];
    double mid, lmid, rmid;

    double f(double x) {
        double res = (double)0;
        for (int i = N; i >= 0; i--) res += A[i] * Math.pow(x, i);
        return res;
    }

    public int main1() {
        while (r - l > eps) {
            mid = (l + r) / 2;
            lmid = mid - eps;
            rmid = mid + eps;
            // if成立，则说明l~lmid为单调递减，在峰值点左侧，往右找，
            if (f(lmid) > f(rmid))
                r = mid;
            else
                l = mid;
        }
        System.out.println(l);
        return 0;
    }

}
