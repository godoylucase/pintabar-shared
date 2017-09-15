package com.pintabar.commons.lambda;

import java.util.function.Function;

/**
 * @author Lucas.Godoy on 7/09/17.
 */
@FunctionalInterface
public interface FunctionMayThrowCheckedException<T, R, E extends Exception> extends Function<T, R> {

	@Override
	default R apply(T t) {
		try {
			return applyThrows(t);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	R applyThrows(T t) throws E;
}
