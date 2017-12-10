package net.mrliuli.generics;

import java.util.Set;

/**
 * A generic interface
 * @param <T>
 */
public interface Generator<T>{
	T next();
}
