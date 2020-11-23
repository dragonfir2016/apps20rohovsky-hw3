package ua.edu.ucu;

import java.util.Arrays;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.FilterDecorator;
import ua.edu.ucu.smartarr.SmartArray;
import ua.edu.ucu.smartarr.SortDecorator;
import ua.edu.ucu.smartarr.MapDecorator;
import ua.edu.ucu.smartarr.DistinctDecorator;


public class SmartArrayApp {

    public static Integer[]
    filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object oM, Object oT) {
                return ((Integer) oM) - ((Integer) oT);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
    findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {

        MyPredicate secondYearHighGPA = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student) t).getYear() == 2
                        && ((Student) t).getGPA() >= 4;
            }
        };

        MyComparator sortBySurname = new MyComparator() {
            @Override
            public int compare(Object oOne, Object oTwo) {
                return ((Student) oOne).getSurname().compareTo(((Student) oTwo)
                        .getSurname());
            }
        };

        MyFunction returnNameSurname = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return ((Student) t).getSurname() + " "
                        + ((Student) t).getName();
            }
        };
        SmartArray studentsList = new BaseArray(students);

        studentsList = new DistinctDecorator(studentsList);
        studentsList = new FilterDecorator(studentsList, secondYearHighGPA);
        studentsList = new SortDecorator(studentsList, sortBySurname);
        studentsList = new MapDecorator(studentsList, returnNameSurname);
        Object[] result = studentsList.toArray();
        return Arrays.copyOf(result, result.length, String[].class);
    }
}
