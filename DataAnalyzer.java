import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
public class DataAnalyzer {
    private static int[] list = {26, 15, 30, 52, 35, 35, 70, 0, 60, 65, 58, 72, 60, 17, 17, 81, 22, 4, 77, 29, 93, 19, 5, 63, 64, 78, 43, 14, 90, 24, 
        55, 21, 45, 9, 90, 44, 17, 5, 28, 24, 16, 66, 73, 56, 74, 5, 97, 64, 58, 60, 24, 77, 17, 97, 38, 66, 85, 43, 89, 62, 
        68, 44, 52, 35, 98, 5, 48, 31, 55, 36, 99, 46, 72, 90, 35, 58, 33, 78, 12, 72, 2, 78, 25, 78, 59, 29, 22, 7, 45, 2, 
        28, 37, 44, 41, 3, 33, 28, 89, 32, 81};

    public static int linearSearch(int[] list, int target) {
        for (int i = 0; i < list.length; i++) if (list[i] == target) return i;
        return -1;
    }

    public static int binarySearch(int[] list, int target) {
        int left = 0;
        int right = list.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list[mid] == target) return mid;

            if (list[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int reverseSearch(int[] list, int target) {
        for (int i = list.length - 1; i >= 0; i--) if (list[i] == target) return i;
        return -1;
    }

    public static void main(String[] args) {
        int target = 7;
        String[] fileContent = new String[100];
        File file = new File("numbers.txt");

        try{
            Scanner input = new Scanner(file);
            int index = 0;
            while (input.hasNextLine()) {
                fileContent[index] = input.nextLine();
                index++;
            }
            input.close();
        } catch (Exception e) {
            System.out.println("File not found");
        }
        
        for(int i = 0; i < fileContent.length; i++) {
            list[i] = Integer.parseInt(fileContent[i]);
        }
    
        System.out.println("Linear Search: " + linearSearch(list, target));
        System.out.println("Reverse Search: " + reverseSearch(list, target));

        Arrays.sort(list);

        System.out.println("Binary Search: " + binarySearch(list, target));

    }
}