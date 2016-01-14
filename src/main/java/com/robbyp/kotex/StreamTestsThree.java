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

import com.robbyp.kotex.domain.Artist;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamTestsThree {

    public static void main(String[] args) {

        List<Artist> artists = Arrays.asList(
            new Artist("The Strange", Arrays.asList(new Artist("James", new ArrayList<>(), "Belleville")), "Oakville"),
            new Artist("Bob Goes Fishing",
                       Arrays.asList(
                           new Artist("Bill", new ArrayList<>(), "Belleville"),
                           new Artist("Simon", new ArrayList<>(), "Belleville")
                       ), "Toronto")
        );

        int totalMembers = 0;
        for (Artist artist : artists) {
            Stream<Artist> members = artist.getMembers();
            totalMembers += members.count();
        }
        System.out.println(totalMembers);

        System.out.println(artists
                               .stream()
                               .flatMap(Artist::getMembers)
                               .collect(Collectors.toList())
        );

        System.out.println(
            "RoBisAwesomE".chars()
                .filter(Character::isUpperCase)
                .count()
        );

        List<String> l = Arrays.asList("RoBisAwesomE", "Rob", "LaLaLa");
        System.out.println(maxUpper(l));

    }

    private static Optional<String> maxUpper(List<String> xs) {
        return xs.stream()
            .max(Comparator.comparing(String::length));
    }
}
