import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class World {
    private Bird[] birds;

    public World(String namesFilePath, String colorFilePath, String dietFilePath, String statusFilePath) {
        ArrayList<String> birdNames = new ArrayList<>();
        try (Scanner input = new Scanner(new File(namesFilePath))) {
            while (input.hasNextLine()) {
                birdNames.add(input.nextLine());
            }
        }catch(IOException e){
            System.out.println("File not found: " + namesFilePath);
        }
        ArrayList<String> colors = new ArrayList<>();
        try (Scanner input = new Scanner(new File(colorFilePath))) {
            while (input.hasNextLine()) {
                colors.add(input.nextLine());
            }
        }catch(IOException e){
            System.out.println("File not found: " + colorFilePath);
        }
        ArrayList<String> diets = new ArrayList<>();
        try (Scanner input = new Scanner(new File(dietFilePath))) {
            while (input.hasNextLine()) {
                diets.add(input.nextLine());
            }
        }catch(IOException e){
            System.out.println("File not found: " + dietFilePath);
        }
        ArrayList<String> statuses = new ArrayList<>();
        try (Scanner input = new Scanner(new File(statusFilePath))) {
            while (input.hasNextLine()) {
                statuses.add(input.nextLine());
            }
        }catch(IOException e){
            System.out.println("File not found: " + statusFilePath);
        }
        birds = new Bird[birdNames.size()];

        for (int i = 0; i < birdNames.size(); i++) {
            birds[i] = new Bird(birdNames.get(i), colors.get(i), diets.get(i), statuses.get(i));
        }
    }

    private Bird[] searchBy(String color, String diet, String status){
        ArrayList<Bird> result = new ArrayList<>();
        for (Bird bird : birds) {
            boolean matches = true;
            if (!color.isEmpty() && !bird.getColor().equals(color)) {
                matches = false;
            }
            if (!diet.isEmpty() && !bird.getDiet().equals(diet)) {
                matches = false;
            }
            if (!status.isEmpty() && !bird.getStatus().equals(status)) {
                matches = false;
            }
            if (matches) {
                result.add(bird);
            }
        }
        Bird[] resultArray = new Bird[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    public String getMostCommonColor(){
        ArrayList<String> colors = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();
        for (Bird bird : birds) {
            if (!colors.contains(bird.getColor())) {
                colors.add(bird.getColor());
                counts.add(1);
            } else {
                int index = colors.indexOf(bird.getColor());
                counts.set(index, counts.get(index) + 1);
            }
        }
        int maxIndex = 0;
        for (int i = 1; i < counts.size(); i++) {
            if (counts.get(i) > counts.get(maxIndex)) {
                maxIndex = i;
            }
        }
        return colors.get(maxIndex);
    }

    public String getMostCommonDiet(){
        ArrayList<String> diets = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();
        for (Bird bird : birds) {
            if (!diets.contains(bird.getDiet())) {
                diets.add(bird.getDiet());
                counts.add(1);
            } else {
                int index = diets.indexOf(bird.getDiet());
                counts.set(index, counts.get(index) + 1);
            }
        }
        int maxIndex = 0;
        for (int i = 1; i < counts.size(); i++) {
            if (counts.get(i) > counts.get(maxIndex)) {
                maxIndex = i;
            }
        }
        return diets.get(maxIndex);
    }

    public String getMostCommonStatus(){
        ArrayList<String> statuses = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();
        for (Bird bird : birds) {
            if (!statuses.contains(bird.getStatus())) {
                statuses.add(bird.getStatus());
                counts.add(1);
            } else {
                int index = statuses.indexOf(bird.getStatus());
                counts.set(index, counts.get(index) + 1);
            }
        }
        int maxIndex = 0;
        for (int i = 1; i < counts.size(); i++) {
            if (counts.get(i) > counts.get(maxIndex)) {
                maxIndex = i;
            }
        }
        return statuses.get(maxIndex);
    }

    public Bird[] searchByColor(String color) {
        return searchBy(color, "", "");
    }

    public Bird[] searchByDiet(String diet) {
        return searchBy("", diet, "");
    }

    public Bird[] searchByStatus(String status) {
        return searchBy("", "", status);
    }

    public Bird[] searchByColorAndDiet(String color, String diet) {
        return searchBy(color, diet, "");
    }

    public Bird[] searchByColorAndStatus(String color, String status) {
        return searchBy(color, "", status);
    }
}
