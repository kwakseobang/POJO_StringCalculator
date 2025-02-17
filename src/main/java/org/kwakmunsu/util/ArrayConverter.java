package org.kwakmunsu.util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ArrayConverter {

    private ArrayConverter() {
    }

    public static Queue<Integer> toIntegerQueue(String[] parsedOperand) {
        List<Integer> list = Arrays.stream(parsedOperand)
            .mapToInt(Integer::parseInt)
            .boxed().toList();
        return new LinkedList<>(list);
    }

}