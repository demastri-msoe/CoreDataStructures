package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Driver {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(7);
        list.add(11);
        list.add(19);

        System.out.println("Do simple recursion - no returned paths:");
        findAndShowResult(list, 38);
        findAndShowResult(list, 40);

        System.out.println();
        System.out.println("Do recursion - but return and show paths:");
        findAndShowPaths(list, 38);
        findAndShowPaths(list, 40);

        System.out.println();
        System.out.println("Return and show paths for a case with multiple paths:");
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        findAndShowPaths(list, 6);

        System.out.println();
        boolean useRandom = false;
        Random r = new Random();
        list = new ArrayList<>();
        for( int i=1; i<=20; i++) {
            list.add(useRandom ? r.nextInt() : i);
        }
        //int target = useRandom ? r.nextInt() : 3;
        int target = useRandom ? r.nextInt() : 210;

        System.out.println("Timing for 20 options (~2M decisions) without mapping internal state:");
        long startTime = System.nanoTime();
        findAndShowResult(list, target);
        long stopTime = System.nanoTime();
        System.out.println("Time taken: "+((stopTime-startTime)/1_000_000)+"ms");

        System.out.println("Timing for 20 options (~2M decisions) managing internal state:");
        startTime = System.nanoTime();
        findAndShowPaths(list, target);
        stopTime = System.nanoTime();
        System.out.println("Time taken: "+((stopTime-startTime)/1_000_000)+"ms");
    }

    private static void findAndShowResult(List<Integer> list, int target) {
        Recursion r = new Recursion();
        if (!r.groupSum(list, target)) {
            System.out.println("Could not find a path to the sum " + target+ " for the list "
                    + getListString(list));
        } else {
            System.out.println("Successful path(s) exist to the sum " + " for the list "
                    + getListString(list));
        }
    }

    private static void findAndShowPaths(List<Integer> list, int target) {
        Recursion r = new Recursion();
        List<String> paths = r.groupSumWithFeedback(list, target);
        if (paths.size() == 0) {
            System.out.println("Could not find a path to the sum " + target + " for the list "
                    + getListString(list));
        } else {
            System.out.println("Successful paths to the sum " + target + " for the list "
                    + getListString(list) + ":");
            for (String s : paths) {
                boolean wasFirst = true;
                for (int i = 0; i < list.size(); i++) {
                    if (s.charAt(i) == 'X') {
                        if (!wasFirst) {
                            System.out.print("+");
                        }
                        System.out.print(list.get(i));
                        wasFirst = false;
                    }
                }
                System.out.println();
            }
        }
    }

    private static String getListString(List<Integer> l) {
        String outString = "{";
        boolean wasFirstInList = true;
        for (int i : l) {
            if (!wasFirstInList) {
                outString += ", ";
            }
            outString += String.valueOf(i);
            wasFirstInList = false;
        }
        outString += "}";
        return outString;
    }

}

