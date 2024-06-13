package org.example.lib;

import org.example.constructors.AmazingService;
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
        final var amazingService = new AmazingService(null, null, null);
        final var modernPerson = new ModernPerson(null, null, null, null);
        final var oldschoolPerson = new OldschoolPerson(null, null, null, null);
    }
}
