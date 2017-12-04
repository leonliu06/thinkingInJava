package net.mrliuli.rtti.pets;

import java.util.ArrayList;

/**
 * Created by leon on 2017/12/4.
 */
public class Pets {

    public static final PetCreator creator = new LiteralPetCreator();

    public static Pet randomPet(){
        return creator.randomPet();
    }

    public static  Pet[] createArray(int size){
        return creator.createArray(size);
    }

    public static ArrayList<Pet> arrayList(int size){
        return creator.arrayList(size);
    }
}
