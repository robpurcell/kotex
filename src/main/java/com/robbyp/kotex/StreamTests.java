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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;


public class StreamTests {

    public static void main(String[] args) {
        List<Artist> allArtists = new ArrayList<>();
        allArtists.add(new Artist("Rob", new ArrayList<>(), "Oakville"));
        allArtists.stream()
            .filter(artist -> {
                System.out.println("Here!");
                return artist.isFrom("London");
            })
            .count();
//        System.out.println(count);

        Album album = new Album();

        Set<String> origins = album.getMusicians()
            .filter(artist -> artist.getName().startsWith("The"))
            .map(artist -> artist.getNationality())
            .collect(toSet());
    }
}
