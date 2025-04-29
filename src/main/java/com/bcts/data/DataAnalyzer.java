package com.bcts.data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DataAnalyzer {
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

    public static String[] birdsWith(String[] list, String target) {
        int[] indexes = findString(list, target);
        String[] birdNames = toStringArray("data/names.txt", 98);
        String[] birds = new String[indexes.length];
        for(int i = 0; i < indexes.length; i++) {
            birds[i] = birdNames[indexes[i]];
        }

        return birds;
    }

    public static String[] birdsWithDiet(String target){
        String filePath = "data/diets.txt";
        int arraySize = 98;

        String[] stringArray = toStringArray(filePath, arraySize);
        String[] birdNames = birdsWith(stringArray, target);
        return birdNames;
    }

    public static String[] birdsWithColor(String target){
        String filePath = "data/color.txt";
        int arraySize = 98;

        String[] stringArray = toStringArray(filePath, arraySize);
        String[] birdNames = birdsWith(stringArray, target);
        return birdNames;
    }

    public static String[] birdsWithStatus(String target){
        String filePath = "data/status.txt";
        int arraySize = 98;

        String[] stringArray = toStringArray(filePath, arraySize);
        String[] birdNames = birdsWith(stringArray, target);
        return birdNames;
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
    
    public static int countWithColor(String target) {
        String filePath = "data/color.txt";
        int arraySize = 98;

        String[] stringArray = toStringArray(filePath, arraySize);
        return countInstances(stringArray, target);
    }

    public static int countWithDiet(String target) {
        String filePath = "data/diets.txt";
        int arraySize = 98;

        String[] stringArray = toStringArray(filePath, arraySize);
        return countInstances(stringArray, target);
    }

    public static int countWithStatus(String target) {
        String filePath = "data/status.txt";
        int arraySize = 98;

        String[] stringArray = toStringArray(filePath, arraySize);
        return countInstances(stringArray, target);
    }

    public static double statusPercentage(String target) {
        String filePath = "data/status.txt";
        int arraySize = 98;

        String[] stringArray = toStringArray(filePath, arraySize);
        int count = countInstances(stringArray, target);
        return (double) count / arraySize * 100;
    }

    public static void main(String[] args) {
        // Test countWithDiet method
        String dietTarget = "Insectivore";
        int dietCount = countWithDiet(dietTarget);
        System.out.println("Number of birds with diet " + dietTarget + ": " + dietCount);

        // Test birdsWithColor method
        String colorTarget = "Red";
        String[] birdsWithRedColor = birdsWithColor(colorTarget);
        System.out.println("Birds with color " + colorTarget + ": " + Arrays.toString(birdsWithRedColor));


    }
}