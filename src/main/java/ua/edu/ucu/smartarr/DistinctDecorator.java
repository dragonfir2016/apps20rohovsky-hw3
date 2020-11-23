package ua.edu.ucu.smartarr;

import java.util.ArrayList;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray sm) {
        super(sm);
        this.smartArray = removeDuplicates(this.smartArray);
    }

    private SmartArray removeDuplicates(SmartArray smArray) {
        Object[] testArr = smArray.toArray();
        ArrayList<Object> ansArr = new ArrayList<>();
        for (int i = 0; i < testArr.length; i++) {
            for (int j = i + 1; j < testArr.length; j++) {
                if (testArr[i] != null && testArr[j] != null &&
                        testArr[i].equals(testArr[j])) {
                    testArr[j] = null;
                }
            }
        }
        for (Object o : testArr) {
            if (o != null) {
                ansArr.add(o);
            }
        }
        return new BaseArray(ansArr.toArray());
    }

    @Override
    public Object[] toArray() {
        return this.smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Removed duplicates from given array:)";
    }

    @Override
    public int size() {
        return this.smartArray.size();
    }
}
