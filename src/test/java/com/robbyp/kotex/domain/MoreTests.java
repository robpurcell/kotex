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
package com.robbyp.kotex.domain;

import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Arrays.equals;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;


public class MoreTests {
    @Test
    public void testMapToUppercase() {
        List<String> collected = Stream.of("a", "b", "hello")
            .map(String::toUpperCase)
            .collect(toList());

        assertEquals(asList("A", "B", "HELLO"), collected);
    }

    @Test
    public void testConcatStream() {
        List<Integer> together = Stream.of(asList(1, 2), asList(3, 4))
            .flatMap(Collection::stream)
            .collect(toList());

        assertEquals(asList(1, 2, 3, 4), together);
    }

}
