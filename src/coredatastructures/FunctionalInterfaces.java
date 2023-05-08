package coredatastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FunctionalInterfaces {

    public static class AdditionOperator implements BinaryOperator<Integer> {
        @Override
        public Integer apply(Integer lhs, Integer rhs) {
            return lhs + rhs;
        }
    }

    public static class BiggerThan100 implements Predicate<Integer> {
        @Override
        public boolean test(Integer val) {
            return val > 100;
        }
    }

    public static class ShowResults implements Consumer<String> {
        @Override
        public void accept(String s) {
            System.out.println(s);
        }
    }

    public static <E> void listIterator(List<E> theList, Consumer<E> thingToDo ) {
        for(E e: theList) {
            thingToDo.accept(e);
        }
    }

    public static void evalExpression(Integer a, Integer b,
                                        BinaryOperator<Integer> customOperator,
                                        Predicate<Integer> thisTest,
                                        Consumer<String> mySideEffect) {
        if (thisTest.test(a)) {
            mySideEffect.accept("("+a+","+b+") provided, a passed the test, so f(a,a) = "+ customOperator.apply(a, a));
        } else {
            mySideEffect.accept("("+a+","+b+") provided, a passed the test, so f(a,b) = "+ customOperator.apply(a, b));
        }
    }

    public static void main(String[] args) {

        List<String> myList = new ArrayList<>();
        myList.add("val a");
        myList.add("val b");
        myList.add("val c");

        listIterator(myList, s -> { System.out.println(s); });

        System.out.println();

        final int highRange = 100;

        Integer a = 7;
        Integer b = 10;

        // using classes and defined functions
        evalExpression(a, b, new AdditionOperator(), new BiggerThan100(), new ShowResults());

        // using lambda expressions
        evalExpression(highRange+a, highRange+b,
                (x, y) -> { return x + y; },
                z -> { return z > highRange; },
                s -> { System.out.println(s); }
        );

    }
}
