public class BubbleSort {

    public static void main(String[] args) {
        //冒泡排序
        int[] arr = {5, 8, 6, 3, 9, 2, 1, 7};
        int lastExchangeIndex = 0;
        int sortBorder = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            Boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                int a = arr[j];
                int b = arr[j + 1];
                if (a > b) {
                    arr[j] = b;
                    arr[j + 1] = a;
                    //为了某轮排序后整个数组已经是有序，直接结束外层循环
                    isSorted = false;
                    //排除已经连续有序的区域
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
        for (int num : arr) {
            System.out.println(num);
        }
    }
}
