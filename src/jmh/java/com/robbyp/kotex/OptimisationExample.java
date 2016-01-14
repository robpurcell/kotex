package com.robbyp.kotex;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.concurrent.TimeUnit.NANOSECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;


@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 5, time = 1, timeUnit = SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = SECONDS)
@Fork(1)
@OutputTimeUnit(NANOSECONDS)
@State(Scope.Thread)
public class OptimisationExample {

    public static void main(String[] ignore) throws IOException, RunnerException {
        Options opt = new OptionsBuilder()
            .include(".*" + OptimisationExample.class.getSimpleName() + ".*")
            .build();

        new Runner(opt).run();
    }

    private List<Integer> linkedListOfNumbers;
    private List<Integer> arrayListOfNumbers;


    @Setup
    public void init() {
        linkedListOfNumbers = new LinkedList<>();
        addNumbers(linkedListOfNumbers);

        arrayListOfNumbers = new ArrayList<>();
        addNumbers(arrayListOfNumbers);
    }

    private void addNumbers(List<Integer> container) {
        IntStream.range(0, 1_000_000)
            .forEach(container::add);
    }

    @Benchmark
    public int slowSumOfSquares() {
        return linkedListOfNumbers.parallelStream()
            .map(x -> x * x)
            .reduce(0, (acc, x) -> acc + x);
    }

    @Benchmark
    public int mediumSumOfSquares() {
        return arrayListOfNumbers.parallelStream()
            .map(x -> x * x)
            .reduce(0, (acc, x) -> acc + x);
    }

    @Benchmark
    public int fastSumOfSquares() {
        return arrayListOfNumbers.parallelStream()
            .mapToInt(x -> x * x)
            .sum();
    }


}
