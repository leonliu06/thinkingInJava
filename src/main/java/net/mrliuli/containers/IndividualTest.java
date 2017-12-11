package net.mrliuli.containers;

import net.mrliuli.rtti.pets.Individual;
import net.mrliuli.rtti.pets.Pet;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by li.liu on 2017/12/11.
 */
public class IndividualTest {
    public static void main(String[] args){
        Set<Individual> pets = new TreeSet<>();
//        for(List<? extends Pet> lp : MapOfList.petPeople.values())
//            for(Pet p : lp)
//                pets.add(p);
        System.out.println(pets);
    }
}
