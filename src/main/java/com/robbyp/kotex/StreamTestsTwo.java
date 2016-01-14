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

import com.robbyp.kotex.domain.Album;
import com.robbyp.kotex.domain.Artist;
import com.robbyp.kotex.domain.Track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamTestsTwo {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        System.out.println(addUp(numbers.stream()));

        List<Artist> allArtists = new ArrayList<>();
        allArtists.add(new Artist("Rob", new ArrayList<>(), "Oakville"));
        allArtists.add(new Artist("Bob", new ArrayList<>(), "Toronto"));
        allArtists.add(new Artist("James", new ArrayList<>(), "Belleville"));
        System.out.println(findNamesAndOrigins(allArtists.stream()));

        List<Album> albums = Arrays.asList(
            new Album("I dream", Arrays.asList(new Track("WooHoo"), new Track("The Commitment"), new Track("Blarney Stone")),
                      Collections.emptyList()),
            new Album("Boy forgets", Arrays.asList(new Track("BooHoo"), new Track("TheThe"), new Track("Smart"), new Track("Simple")),
                      Collections.emptyList())
        );

        System.out.println(findAlbumsWithAtMostThreeTracks(albums.stream()));


    }

    private static int addUp(Stream<Integer> s) {
        return s.reduce(0, (x, y) -> x + y);
    }

    private static List<String> findNamesAndOrigins(Stream<Artist> s) {
        return s.map(artist -> artist.getName() + " is from " + artist.getNationality()).collect(Collectors.toList());
    }

    private static List<Album> findAlbumsWithAtMostThreeTracks(Stream<Album> s) {
        return s
            .filter(a -> a.getTracks().size() <= 3)
            .collect(Collectors.toList());
    }

}
