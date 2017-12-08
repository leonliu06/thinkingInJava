package net.mrliuli.generics.wildcards;

/**
 * Created by li.liu on 2017/12/8.
 */
public class Wildcards {
    // Raw arguments:
    static void rawArgs(Holder holder, Object arg){
        holder.set(arg);
        holder.set(new Wildcards());

        // Can't do this; don't have any 'T':
        // T t = holder.get();

        // OK, but type information has been lost:
        Object obj = holder.get();

    }

    // Similar to rawArgs(), but errors
    static void unboundedArg(Holder<?> holder, Object arg){
        //holder.set(arg);  // Error:
        //holder.set(new Wildcards());  // Same error

        // Can't do this, don't have any 'T':
        //T t = holder.get();

        // OK, but type information has been lost:
        Object obj = holder.get();
    }

    static <T> T exact1(Holder<T> holder){
        T t = holder.get();
        return t;
    }

    static <T> T exact2(Holder<T> holder, T arg){
        holder.set(arg);
        T t = holder.get();
        return t;
    }

    static <T> T wildSubtype(Holder<? extends T> holder, T arg){
        //holder.set(arg);     // Error:
        T t = holder.get();
        return t;
    }

    static <T> void wildSupertype(Holder<? super T> holder, T arg){
        holder.set(arg);
        //T t = holder.get();     // Error

        // OK, but type information has been lost:
        Object obj = holder.get();
    }

    public static void main(String[] args){
        Holder raw = new Holder<Long>();
        // Or:
        raw = new Holder();
        Holder<Long> qualified = new Holder<Long>();
        Holder<?> unbounded = new Holder<Long>();
        Holder<? extends Long> bounded = new Holder<Long>();
        Long lng = 1L;

        rawArgs(raw, lng);
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, lng);

        unboundedArg(raw, lng);
        unboundedArg(qualified, lng);
        unboundedArg(unbounded, lng);
        unboundedArg(bounded, lng);

        Object r1 = exact1(raw);
        Long r2 = exact1(qualified);
        Object r3 = exact1(unbounded);  // Must return Object

    }
}
