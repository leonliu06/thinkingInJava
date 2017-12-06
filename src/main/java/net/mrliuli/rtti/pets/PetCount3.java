package net.mrliuli.rtti.pets;

import net.mindview.util.*;

import java.util.*;

import static net.mindview.util.Print.print;

/**
 * Created by li.liu on 2017/12/5.
 */
public class PetCount3 {

    static class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer>{

        public PetCounter(){
            super(MapData.map(LiteralPetCreator.allTypes, 0));
        }

        public void count(Pet pet){

            // Class.isInstance() eliminates instanceofs:
            for(Map.Entry<Class<? extends Pet>, Integer> pair : this.entrySet()){
                if(pair.getKey().isInstance(pet))
                    put(pair.getKey(), pair.getValue() + 1);
            }

        }

        public String toString(){
            StringBuilder result = new StringBuilder("{");
            for(Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()){
                result.append(pair.getKey().getSimpleName());
                result.append("=");
                result.append(pair.getValue());
                result.append(", ");
            }
            result.delete(result.length() - 2, result.length());
            result.append("}");
            return result.toString();
        }

    }

    public static void main(String[] args){
        PetCounter petCounter = new PetCounter();
        for(Pet pet : Pets.createArray(20)){
            System.out.print(pet.getClass().getSimpleName() + " ");
            petCounter.count(pet);
        }
        print();
        print(petCounter);
    }

}
