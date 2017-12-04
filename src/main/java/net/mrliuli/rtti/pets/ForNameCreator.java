package net.mrliuli.rtti.pets;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 2017/12/4.
 */
public class ForNameCreator extends PetCreator {

    private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();

    // Types that you want to be randomly created:
    private static String[] typeNames = {
        "net.mrliuli.rtti.pets.Mutt",
        "net.mrliuli.rtti.pets.Pug",
        "net.mrliuli.rtti.pets.EgyptianMau",
        "net.mrliuli.rtti.pets.Manx",
        "net.mrliuli.rtti.pets.Cymric",
        "net.mrliuli.rtti.pets.Rat",
        "net.mrliuli.rtti.pets.Mouse",
        "net.mrliuli.rtti.pets.Hamster"
    };

    @SuppressWarnings("unchecked")
    private static void loader(){
        try{
            for(String name :typeNames){
                types.add((Class<? extends Pet>)Class.forName(name));
            }
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    static { loader(); }

    @Override
    public List<Class<? extends Pet>> getTypes() {
        return types;
    }
}
