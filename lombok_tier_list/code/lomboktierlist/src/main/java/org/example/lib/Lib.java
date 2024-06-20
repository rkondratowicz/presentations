package org.example.lib;

import org.example.constructors.AmazingService;
import org.example.logging.ClassFour;
import org.example.logging.ClassOne;
import org.example.logging.ClassThree;
import org.example.logging.ClassTwo;
import org.example.records.ModernPerson;
import org.example.records.OldschoolPerson;

public class Lib {

    public interface RulesEngine {
        int x();
    }

    public interface AwesomeDependency {
        int y();
    }

    public interface Calculator {
        int z();
    }

    public interface YetAnotherDep {
        int a();
    }

    public static void foo() {
        // use the classes used in examples do that they don't appear greyed out in IDE
        var amazingService = new AmazingService(null, null, null);
        var modernPerson = new ModernPerson(null, null, null, null);
        var oldschoolPerson = new OldschoolPerson(null, null, null, null);

        var classOne = new ClassOne();
        var classTwo = new ClassTwo();
        var classThree = new ClassThree();
        var classFour = new ClassFour();

        classOne.foo();
        classTwo.foo();
        classThree.foo();
        classFour.foo();
    }
}
