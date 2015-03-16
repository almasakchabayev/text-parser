package com.epam.aa.parser;

import com.epam.aa.parser.model.Composite;

import java.util.regex.Pattern;

public class Runner {
    public static void main(String[] args) {
        String text = "Licensed to the Apache Software Foundation , under one or more" +
                "  contributor license agreements...  See the NOTICE file distributed with" +
                "  this work for additional information regarding copyright ownership." +
                "  The ASF licenses this file to You under the Apache License, Version 2.0; " +
                "  you may not use this file except in compliance with" +
                "  the License.\n" +
                "  Another paragraph \n" +
                "  Unless required by applicable law or agreed to in writing, software" +
                "  distributed under the License is distributed on an AS IS BASIS," +
                "  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied." +
                "  See the License for the specific language governing permissions and" +
                "  limitations under the License.";

        Composite textComposite = Composite.parse(text);
//        textComposite.print();
//        System.out.println(textComposite);
        System.out.println(textComposite.stringify());
//        Pattern
    }
}
