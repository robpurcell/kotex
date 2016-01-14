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

import com.robbyp.kotex.domain.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;


public class StreamTestFour {

    public static void main(String[] args) {
        Performance p = new PerformanceImpl("Bloodstock",
                                            Arrays.asList(
                                                new Artist("Slayer",
                                                           ArtistsFactory.slayer,
                                                           "California"),
                                                new Artist("Slipknot",
                                                           Arrays.asList(new Artist("Corey", Collections.emptyList(), "Wisconsin"),
                                                                         new Artist("Mike", Collections.emptyList(), "Wisconsin")),
                                                           "Idaho")
                                            )
        );

        System.out.println(p.getAllMusicians().collect(Collectors.toList()));
    }

    public static void printTrackLengthStatistics(Album album) {
        IntSummaryStatistics trackLengthStats =
            album.getTracks().stream()
                .mapToInt(Track::getLength)
                .summaryStatistics();

        System.out.printf("Max: %d, Min: %d, Ave: %f, Sum: %d",
                          trackLengthStats.getMax(),
                          trackLengthStats.getMin(),
                          trackLengthStats.getAverage(),
                          trackLengthStats.getSum());
    }
}
