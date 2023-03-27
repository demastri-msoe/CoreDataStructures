package junitexample;

import java.util.List;

public class FindFirstElementInArray {

    public String findEltInArray(List<String> list, String target ) {
        for(String e: list) {
            if( e == target )
                return e;
        }
        return null;
    }
}
