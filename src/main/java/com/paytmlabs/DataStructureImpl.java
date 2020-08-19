package com.paytmlabs;

import java.util.ArrayList;
import java.util.List;

/**
 * Resizable-array implementation of the <tt>DataStructure</tt> interface.
 * Implements all optional {@link DataStructure} operations & permits only {@link Double} elements.
 * (This class utilizes the {@link ArrayList} for storing & retrieving elements.)
 */
public class DataStructureImpl implements DataStructure {

    /**
     * Constructs an empty {@link DataStructure}
     *
     * @param n number of last added elements (for calculating moving average)
     * @throws IllegalArgumentException if n is zero or negative
     */
    public DataStructureImpl(final int n) {
        if (n < 1) {
            throw new IllegalArgumentException(n + " isn't greater than or equal to 1");
        }
        this.n = n;
    }

    /**
     * The number of last added elements (for calculating moving average)
     */
    private final int n;

    /**
     * The <tt>ArrayList</tt> into which the elements of this {@link DataStructure} are stored
     */
    private final List<Double> list = new ArrayList<>();

    /**
     * The start index of the n elements window (for calculating moving average)
     */
    private int startIdx = 0;

    /**
     * The sum of n (or lesser) last added elements (for calculating moving average)
     * which is updated prior to adding new elements to this {@link DataStructure}
     */
    private double sum = 0;


    /**
     * Gets moving average of n last elements added by dividing sum with n (even if n <tt>DataStructure</tt> size).
     * For example: DataStructureImpl[0.0, 1.0] (size = 2), (sum = 1), (n = 5)
     * (moving average != 1.0 / 2), (moving average == 1.0 / 5)
     * (sum is updated prior to adding elements to {@link DataStructure} if n - 1 <= list size)
     *
     * @return moving average of last added n elements
     */
    @Override
    public double getMovingAverage() {
        return sum / n;
    }

    /**
     * Adds the specified {@link Double} element to the end of {@link DataStructure}.
     * (sum is updated prior to adding elements to {@link DataStructure} if list size > n - 1)
     * For example: DataStructureImpl[1.0, 2.0, 3.0, 4.0, 5.0] (d = 6.0), (n = 5)
     * (sum = 21 - 1) as (size = 5) > (n - 1 = 4)
     *
     * @param d element to be added
     */
    @Override
    public void add(final double d) {
        sum += d; //adds element to sum
        if (list.size() > n - 1) {
            sum -= list.get(startIdx); //removes element in startIdx position from sum
            startIdx++; //updates startIdx (slides window)
        }
        list.add(d); //adds element to list
    }

    /**
     * Returns the {@link Double} element at the specified position in {@link DataStructure}
     * by simply calling the get method from {@link ArrayList}.
     *
     * @param i index of the element to return
     * @return the element at the specified position
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public double get(final int i) {
        return list.get(i);
    }

}
