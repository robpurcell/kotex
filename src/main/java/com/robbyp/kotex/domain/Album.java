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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class Album {
    private String title;
    private List<Artist> musicians = new ArrayList<>();
    private List<Track> tracks = new ArrayList<>();

    public Album() {
    }

    public Album(String title, List<Artist> artists) {
        this.title = title;
        this.musicians = artists;
    }

    public Album(String title, List<Track> tracks, List<Artist> musicians) {
        this.title = title;
        this.tracks = tracks;
        this.musicians = musicians;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Stream<Artist> getMusicians() {
        return musicians.stream();
    }

    public void setMusicians(List<Artist> musicians) {
        this.musicians = musicians;

    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    @Override
    public String toString() {
        return "Album{" +
            "title='" + title + '\'' +
            '}';
    }
}
