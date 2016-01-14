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

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;


public class Artist {
    private String name;
    private List<Artist> members;
    private String origin;

    public Artist(String name, List<Artist> members, String origin) {
        this.name = name;
        this.members = members;
        this.origin = origin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stream<Artist> getMembers() {
        return members.stream();
    }

    public void setMembers(List<Artist> members) {
        this.members = members;
    }

    public String getNationality() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public boolean isFrom(String potentialOrigin) {
        return Objects.equals(this.origin, potentialOrigin);
    }

    @Override
    public String toString() {
        return "Artist{" +
            "name='" + name + '\'' +
            '}';
    }
}
