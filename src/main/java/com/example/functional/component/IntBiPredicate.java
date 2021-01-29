package com.example.functional.component;

@FunctionalInterface
public interface IntBiPredicate {

    /**
     * Evaluates this predicate on the given int arguments.
     *
     * @param t the first input argument
     * @param u the second input argument
     * @return {@code true} if the input arguments match the predicate,
     * otherwise {@code false}
     */
    boolean testAsInt(int t, int u);
}
