package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private final MyComparator compr;

    public SortDecorator(SmartArray sm, MyComparator mc) {
        super(sm);
        this.compr = mc;
        this.smartArray = applyComparator(this.smartArray);
    }

    private SmartArray applyComparator(SmartArray smArray) {
        Object[] resArr = smArray.toArray();
        Arrays.sort(resArr, this.compr);
        return new BaseArray(resArr);
    }

    @Override
    public Object[] toArray() {
        return this.smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Sorted given SmartArray by given comparator:)";
    }

    @Override
    public int size() {
        return this.smartArray.size();
    }
}
