import java.util.Scanner;

public class Serial{

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

    public static void mergeSort(int[] nums, int start, int end){
        if (start < end){;
            int mid = (start + (end))/2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            merge(nums, start, mid, end);
            
        }
    }

    public static void main(String[] args){
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

        mergeSort(numbers, 0, numbers.length-1);
        for(int i = 0; i < numbers.length; i++){
            System.out.print(numbers[i] + " ");
        }
    }
}