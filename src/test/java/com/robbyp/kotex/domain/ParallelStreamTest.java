// Copyright 2016 Purcell Informatics Limited
//
// See the LICENCE file distributed with this work for additional
// information regarding copyright ownership.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.


package com.robbyp.kotex.domain;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class ParallelStreamTest {
    private static int sequentialSumOfSquares(IntStream range) {
        return range
            .map(x -> x * x)
            .sum();
    }

    private static int parallelSumOfSquares(IntStream range) {
        return range
            .map(x -> x * x)
            .parallel()
            .sum();
    }

    public static int sequentialMultiplyThrough(List<Integer> linkedListOfNumbers) {
        return linkedListOfNumbers.stream()
            .reduce(5, (acc, x) -> x * acc);
    }

    public static int parallelMultiplyThrough(List<Integer> linkedListOfNumbers) {
        return 5 * linkedListOfNumbers.stream()
            .parallel()
            .reduce(1, (acc, x) -> x * acc);
    }

    @Test
    public void testSequentialSumOfSquares() {
        List<Integer> ints = getIntegers();

        int sequentialResult = sequentialSumOfSquares(ints.stream().mapToInt(i -> i));
        int parallelResult = parallelSumOfSquares(ints.stream().mapToInt(i -> i));

        assertThat(sequentialResult, equalTo(parallelResult));
    }

    @NotNull
    private List<Integer> getIntegers() {
        int size = new Random().nextInt(10);
        List<Integer> ints = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            ints.add(i, new Random().nextInt(100));
        }
        return ints;
    }

    @Test
    public void testMuliplyThrough() {
        List<Integer> ints = getIntegers();

        int sequentialResult = sequentialMultiplyThrough(ints);
        int parallelResult = parallelMultiplyThrough(ints);

        assertThat(sequentialResult, equalTo(parallelResult));

    }
}
