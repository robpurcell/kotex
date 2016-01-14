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

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class ArtistsTest {

    @Test
    public void testGetArtistWhenOneExists() {
        Artists artists = new Artists(ArtistsFactory.slayer);

        assertThat(artists.getArtist(0).map(Artist::getName), equalTo(Optional.of("Jeff")));
    }

    @Test
    public void testGetArtistNameWhenOneExists() {
        Artists artists = new Artists(ArtistsFactory.slayer);

        assertThat(artists.getArtistName(0), equalTo(Optional.of("Jeff")));
    }

    @Test
    public void testGetArtistNameWhenIndexIsOutOfBounds() {
        Artists artists = new Artists(ArtistsFactory.slayer);

        assertThat(artists.getArtistName(10), equalTo(Optional.empty()));
    }

    @Test
    public void testLongestName() {
        Stream<String> names = Stream.of("John Lennon", "Paul McCartney",
                                         "George Harrison", "Ringo Starr", "Pete Best", "Stuart Sutcliffe");

//        String longestName = names.reduce("", (acc, name) ->    );

//        assertThat(longestName, equalTo("Stuart Sutcliffe"));
    }

    @Test
    public void testWordCount() {
        // Given
        Stream<String> names = Stream.of("John", "Paul", "George", "John", "Paul", "John");

        // When
//        Map<String, Integer> result = names.

        Map<String, Integer> expected =
            ImmutableMap.<String, Integer>builder()
                .put("John", 3)
                .put("Paul", 2)
                .put("George", 1).build();

//        assertThat(result, equalTo(expected));
    }
}
