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

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class Test {

    static boolean check(Predicate<Integer> predicate) {
        return false;
    }

//    static boolean check(IntPred predicate) {
//        return true;
//    }

    public static void main(String[] args) {
        Function<Long, Long> f = x -> x + 1;
        Supplier<DateFormat> s = () -> new SimpleDateFormat("d-MMM-yyyy");
        ThreadLocal<DateFormat> df = ThreadLocal.withInitial(s);
        System.out.println(df.get().format(new Date()));

        Runnable helloWorld = () -> System.out.println("hello world");

        JButton button = new JButton();
        button.addActionListener(event -> System.out.println(event.getActionCommand()));

        check(x -> x > 5);


    }

}
