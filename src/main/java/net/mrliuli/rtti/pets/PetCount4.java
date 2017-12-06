package net.mrliuli.rtti.pets;

/**
 * Created by li.liu on 2017/12/5.
 */
public class PetCount4 {

    public static void main(String[] args){
        TypeCounter counter = new TypeCounter(Pet.class);
        for(Pet pet : Pets.createArray(20)){
            System.out.print(pet.getClass().getSimpleName() + " ");
            counter.count(pet);
        }
        System.out.println();
        System.out.print(counter);
    }

}
