package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray {
    private final Object[] array;

    public BaseArray(Object[] arr) {
        this.array = arr.clone();
    }

    @Override
    public Object[] toArray() {
        return this.array.clone();
    }

    @Override
    public String operationDescription() {
        return "No operation is currently applied.";
    }

    @Override
    public int size() {
        return this.array.length;
    }
}
