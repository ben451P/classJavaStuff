import java.io.IOException;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class FileOperator {
    private static String staticFilePath;

    public static String getStaticFilePath() {
        return staticFilePath;
    }

    public static void setStaticFilePath(String filePath) {
        staticFilePath = filePath;
    }

    public static String[] toStringArray(int arraySize) {
        return toStringArray(staticFilePath, arraySize);
    }

    public static int[] toIntArray(int arraySize) {
        return toIntArray(staticFilePath, arraySize);
    }

    public static double[] toDoubleArray(int arraySize) {
        return toDoubleArray(staticFilePath, arraySize);
    }
    
    public static String[] toStringArray(String filePath, int arraySize) {
        String[] array = new String[arraySize];
        try (Scanner input = new Scanner(new File(filePath))) {
            int index = 0;
            while (input.hasNextLine() && index < arraySize) {
                array[index] = input.nextLine();
                index++;
            }
        }catch(IOException e){
            System.out.println("File not found");
        }
        return array;
    }

    public static int[] toIntArray(String filePath, int arraySize) {
        int[] array = new int[arraySize];
        try (Scanner input = new Scanner(new File(filePath))) {
            int index = 0;
            while (input.hasNextLine() && index < arraySize) {
                array[index] = input.nextInt();
                index++;
            }
        }catch(IOException e){
            System.out.println("File not found");
        }
        return array;
    }

    public static double[] toDoubleArray(String filePath, int arraySize) {
        double[] array = new double[arraySize];
        try (Scanner input = new Scanner(new File(filePath))) {
            int index = 0;
            while (input.hasNextLine() && index < arraySize) {
                array[index] = input.nextDouble();
                index++;
            }
        }catch(IOException e){
            System.out.println("File not found");
        }
        return array;
    }

    public static int[] findString(String[] list, String target) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(target)) {
                indices.add(i);
            }
        }
        int[] result = new int[indices.size()];
        for (int i = 0; i < indices.size(); i++) {
            result[i] = indices.get(i);
        }
        return result;
    }

    public static String[] birdsWithDiet(String[] diets, String target) {
        int[] indexes = findString(diets, target);
        String[] birdNames = toStringArray("data/names.txt", 98);
        String[] birds = new String[indexes.length];
        for(int i = 0; i < indexes.length; i++) {
            birds[i] = birdNames[indexes[i]];
        }

        return birds;
    }

    public static int countInstances(String[] list, String target) {
        int count = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(target)) {
                count++;
            }
        }
        return count;
    }

    public static int countStartsWith(String[] list, String target) {
        int count = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i].startsWith(target)) {
                count++;
            }
        }
        return count;
    }

    public static String[] removeDuplicates(String[] list) {
        List<String> uniqueList = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            if (!uniqueList.contains(list[i])) {
                uniqueList.add(list[i]);
            }
        }
        String[] result = new String[uniqueList.size()];
        for (int i = 0; i < uniqueList.size(); i++) {
            result[i] = uniqueList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        String filePath = "data/diets.txt";
        int arraySize = 98;

        String[] stringArray = toStringArray(filePath, arraySize);
        // System.out.println("String Array: " + Arrays.toString(stringArray));

        // System.out.println("All indices of Red: " + Arrays.toString(findString(stringArray, "Red")));

        System.out.println("Birds with diet insects: " + Arrays.toString(birdsWithDiet(stringArray, "insects")));

        System.out.println("Birds with diet insects: " + countInstances(stringArray, "insects"));

        String[] uniqueArray = removeDuplicates(stringArray);
        System.out.println("Unique Array: " + Arrays.toString(uniqueArray));

        String targetPrefix = "in";
        int countPrefix = countStartsWith(stringArray, targetPrefix);
        System.out.println("Count of strings starting with '" + targetPrefix + "': " + countPrefix);
    }
}
