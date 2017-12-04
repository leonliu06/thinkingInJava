package net.mrliuli.rtti.pets;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by leon on 2017/12/4.
 */
public class LiteralPetCreator extends PetCreator {

    // No try block needed
    @SuppressWarnings("unchecked")
    public static final List<Class<? extends Pet>> allTypes = Collections.unmodifiableList(Arrays.asList(
            Pet.class, Dog.class, Cat.class, Rodent.class, Mutt.class, Pug.class, EgyptianMau.class,
            Manx.class, Cymric.class, Rat.class, Mouse.class, Hamster.class
    ));

    // Types for random creation:
    private static final List<Class<? extends Pet>> types = allTypes.subList(allTypes.indexOf(Mutt.class), allTypes.size());

    @Override
    public List<Class<? extends Pet>> getTypes() {
        return types;
    }

    public static void main(String[] args){
        System.out.println(types);
    }
}
