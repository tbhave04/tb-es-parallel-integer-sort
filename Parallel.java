import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.Random;
import java.util.Scanner;

public class Parallel{

    private static final int THRESHOLD = 20000;

    // Merges two sorted subarrays 
    public static void merge(int[] nums, int start, int mid, int end){
        int n1 = mid - start + 1;
        int n2 = end - mid;
        int halfOne[] = new int [n1];
        int halfTwo[] = new int [n2];

        for(int i = 0; i<halfOne.length; i++){
            halfOne[i] = nums[start + i];
        }
        for(int i = 0; i<halfTwo.length; i++){
            halfTwo[i] = nums[mid+1+i];
        }
        
        int i = 0, j = 0;
        int k = start;
        while (i < n1 && j < n2) {
            if (halfOne[i] <= halfTwo[j]) {
                nums[k] = halfOne[i];
                i++;
            }
            else {
                nums[k] = halfTwo[j];
                j++;
            }
            k++;
        }

        while(i < n1){
            nums[k] = halfOne[i];
            i++;
            k++;
        }

        while (j < n2){
            nums[k] = halfTwo[j];
            j++;
            k++;
        }
    }

    // Sorts an array using merge sort
    public static void sequentialMergeSort(int[] nums, int start, int end){
        if (start < end){;
            int mid = (start + (end))/2;
            sequentialMergeSort(nums, start, mid);
            sequentialMergeSort(nums, mid + 1, end);
            merge(nums, start, mid, end);
            
        }
    }

    static class MergeSortTask extends RecursiveAction {
        private final int[] nums;
        private final int start;
        private final int end;

        MergeSortTask(int[] nums, int start, int end) {
            this.nums = nums;
            this.start = start;
            this.end = end;
        }

        // Parallizes recursive calls to sort two halves of an array
        @Override
        protected void compute() {
            if (end - start < THRESHOLD) {
                sequentialMergeSort(nums, start, end);
            } else {
                int mid = start + (end - start) / 2;
                MergeSortTask leftTask = new MergeSortTask(nums, start, mid);
                MergeSortTask rightTask = new MergeSortTask(nums, mid + 1, end);
                invokeAll(leftTask, rightTask);
                merge(nums, start, mid, end);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder inputBuilder = new StringBuilder();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            inputBuilder.append(line).append(" ");
        }

        String input = inputBuilder.toString();
        String[] parts = input.split("\\s+"); 
        
        int[] numbers = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }

        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new MergeSortTask(numbers, 0, numbers.length - 1));
        for(int i = 0; i < numbers.length; i++){
            System.out.print(numbers[i] + " ");
        }
    }
}