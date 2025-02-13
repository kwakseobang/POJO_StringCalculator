package org.kwakmunsu.stringCalculator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class ArrayConverter {

    public static  Queue<Integer> convertStringArrayToIntegerQueue(String[] nums){

        List<Integer> list = Arrays.stream(nums)
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());

        Queue<Integer> queue = new LinkedList<>(list);

        return queue;

    }

}
