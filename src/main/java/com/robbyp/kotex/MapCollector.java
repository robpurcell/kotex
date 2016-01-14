// Copyright 2015 Purcell Informatics Limited
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


package com.robbyp.kotex;

import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;


public class MapCollector implements Collector<String, MapCombiner<String>, Map<String, Integer>> {
    @Override
    public Supplier<MapCombiner<String>> supplier() {
        return MapCombiner::new;
    }

    @Override
    public BiConsumer<MapCombiner<String>, String> accumulator() {
        return MapCombiner::add;
    }

    @Override
    public BinaryOperator<MapCombiner<String>> combiner() {
        return null;
    }

    @Override
    public Function<MapCombiner<String>, Map<String, Integer>> finisher() {
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return null;
    }
}
