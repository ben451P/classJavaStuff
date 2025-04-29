package com.bcts.data;

// import java.io.File;
// import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
// import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import org.springframework.data.mongodb.core.mapping.Document;
@Service
public class World {
    private Bird[] birds;
    @Autowired
    private BirdRepository birdRepository;

    public void createBirds() {
        List<Bird> birdList = birdRepository.findAll();
        birds = new Bird[birdList.size()];
        for (int i = 0; i < birdList.size(); i++) {
            birds[i] = birdList.get(i);
        }
    }

    public Bird[] getBirds() {
        if (birds == null) {
            createBirds();
        }
        return birds;
    }

    public Bird[] searchBy(String color, String diet, String status){
        if (birds == null) {
            createBirds();
        }
        ArrayList<Bird> result = new ArrayList<>();
        for (Bird bird : birds) {
            boolean matches = true;
            if (!(color == null) && !color.isEmpty() && !bird.getColor().equals(color)) {
                matches = false;
            }
            if (!(diet == null) && !diet.isEmpty() && !bird.getDiet().equals(diet)) {
                matches = false;
            }
            if (!(status == null) && !status.isEmpty() && !bird.getStatus().equals(status)) {
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
        if (birds == null) {
            createBirds();
        }
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
        if (birds == null) {
            createBirds();
        }
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
        if (birds == null) {
            createBirds();
        }
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

    public Dictionary<String, Bird[]> countByColor() {
        if (birds == null) {
            createBirds();
        }
        Dictionary<String, Bird[]> result = new Hashtable<>();
        for(Bird bird : birds) {
            if(result.get(bird.getColor()) == null) {
                result.put(bird.getColor(), new Bird[1]);
                result.get(bird.getColor())[0] = bird;
            } else {
                Bird[] temp = result.get(bird.getColor());
                Bird[] newTemp = new Bird[temp.length + 1];
                for(int i = 0; i < temp.length; i++) {
                    newTemp[i] = temp[i];
                }
                newTemp[temp.length] = bird;
                result.put(bird.getColor(), newTemp);
            }
        }
        return result;
    }

    public Dictionary<String, Bird[]> countByDiet(){
        if (birds == null) {
            createBirds();
        }
        Dictionary<String, Bird[]> result = new Hashtable<>();
        for(Bird bird : birds) {
            if(result.get(bird.getDiet()) == null) {
                result.put(bird.getDiet(), new Bird[1]);
                result.get(bird.getDiet())[0] = bird;
            } else {
                Bird[] temp = result.get(bird.getDiet());
                Bird[] newTemp = new Bird[temp.length + 1];
                for(int i = 0; i < temp.length; i++) {
                    newTemp[i] = temp[i];
                }
                newTemp[temp.length] = bird;
                result.put(bird.getDiet(), newTemp);
            }
        }
        return result;
    }

    public Dictionary<String, Bird[]> countByStatus(){
        if (birds == null) {
            createBirds();
        }
        Dictionary<String, Bird[]> result = new Hashtable<>();
        for(Bird bird : birds) {
            if(result.get(bird.getStatus()) == null) {
                result.put(bird.getStatus(), new Bird[1]);
                result.get(bird.getStatus())[0] = bird;
            } else {
                Bird[] temp = result.get(bird.getStatus());
                Bird[] newTemp = new Bird[temp.length + 1];
                for(int i = 0; i < temp.length; i++) {
                    newTemp[i] = temp[i];
                }
                newTemp[temp.length] = bird;
                result.put(bird.getStatus(), newTemp);
            }
        }
        return result;
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
