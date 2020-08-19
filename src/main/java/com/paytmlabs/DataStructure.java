package com.paytmlabs;

/**
 * An interface for {@link DataStructure} that provides the moving average of the last N elements added,
 * adding elements to the structure & getting access to the elements.
 */
public interface DataStructure {

    /**
     * Gets moving average of n last elements added
     *
     * @return moving average of last added n elements
     */
    double getMovingAverage();

    /**
     * Adds the specified {@link Double} element to the end of {@link DataStructure}
     *
     * @param d element to be added
     */
    void add(final double d);

    /**
     * Returns the {@link Double} element at the specified position in {@link DataStructure}
     *
     * @param i index of the element to return
     * @return the element at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   (<tt>i &lt; 0 || i &gt;= size()</tt>)
     */
    double get(final int i);

}
