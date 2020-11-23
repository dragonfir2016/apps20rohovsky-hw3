package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private final MyFunction func;

    public MapDecorator(SmartArray sm, MyFunction mf) {
        super(sm);
        this.func = mf;
        this.smartArray = applyFunction(this.smartArray);
    }

    private SmartArray applyFunction(SmartArray smArray) {
        Object[] resArr = smArray.toArray();
        for (int i = 0; i < resArr.length; i++) {
            resArr[i] = this.func.apply(resArr[i]);
        }
        return new BaseArray(resArr);
    }

    @Override
    public Object[] toArray() {
        return this.smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Applied given function to given SmartArray:)";
    }

    @Override
    public int size() {
        return this.smartArray.size();
    }
}
