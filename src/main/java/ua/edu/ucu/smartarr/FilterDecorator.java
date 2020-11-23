package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private final MyPredicate pred;

    public FilterDecorator(SmartArray sm, MyPredicate mp) {
        super(sm);
        this.pred = mp;
        this.smartArray = applyPredicate(this.smartArray);
    }

    private SmartArray applyPredicate(SmartArray smArray) {
        ArrayList<Object> resArr = new ArrayList<>();
        Object[] testArr = smArray.toArray();
        for (Object o : testArr) {
            if (this.pred.test(o)) {
                resArr.add(o);
            }
        }
        return new BaseArray(resArr.toArray());
    }

    @Override
    public Object[] toArray() {
        return this.smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Applied given predicate to given SmartArray:)";
    }

    @Override
    public int size() {
        return this.smartArray.size();
    }
}
