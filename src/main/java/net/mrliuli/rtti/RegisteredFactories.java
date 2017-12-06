package net.mrliuli.rtti;

import net.mrliuli.rtti.factory.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by li.liu on 2017/12/5.
 */

class Part{

    public String toString(){
        return getClass().getSimpleName();
    }

    // 在基类中保存了它所有子类的内部工厂类
    static List<Factory<? extends Part>> partFactories = new ArrayList<Factory<? extends Part>>();

    static {
        // 因为是静态内部类，所以创建时不需要外围对象
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new CabinAirFilter.Factory());
        partFactories.add(new OilFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());
        partFactories.add(new PowerSteeringBelt.Factory());
    }

    private static Random rand = new Random(47);

    public static Part createRandom(){
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }

}

class Filter extends Part{}

class FuelFilter extends Filter{

    // 静态内部工厂类
    // Create a Class Factory for each specific type:
    public static class Factory implements net.mrliuli.rtti.factory.Factory<FuelFilter>{
        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }
    }

}

class AirFilter extends Filter{
    // Create a Class Factory for each specific type:
    public static class Factory implements net.mrliuli.rtti.factory.Factory<AirFilter>{
        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }
}

class CabinAirFilter extends Filter{
    public static class Factory implements net.mrliuli.rtti.factory.Factory<CabinAirFilter>{
        @Override
        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }
}

class OilFilter extends Filter{
    public static class Factory implements net.mrliuli.rtti.factory.Factory<OilFilter>{
        @Override
        public OilFilter create() {
            return new OilFilter();
        }
    }
}

class Belt extends Part{}

class FanBelt extends Belt{
    public static class Factory implements net.mrliuli.rtti.factory.Factory<FanBelt>{
        @Override
        public FanBelt create() {
            return new FanBelt();
        }
    }
}

class GeneratorBelt extends Belt{
    public static class Factory implements net.mrliuli.rtti.factory.Factory<GeneratorBelt>{
        @Override
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}

class PowerSteeringBelt extends Belt{
    public static class Factory implements net.mrliuli.rtti.factory.Factory<PowerSteeringBelt>{
        @Override
        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    }
}

public class RegisteredFactories {
    public static void main(String[] args){
        for(int i = 0; i < 10; i++){
            System.out.println(Part.createRandom());
        }
    }
}
