package th.in.pureapp.animalsworld.model;

import java.util.ArrayList;

/**
 * Created by pakkapon on 31/10/2560.
 */

public class AnimalList {
    private static ArrayList<Animal> animalList;
    public static ArrayList<Animal> getContext(){
        if(animalList == null){
            animalList = new ArrayList<>();
        }
        return animalList;
    }
}
