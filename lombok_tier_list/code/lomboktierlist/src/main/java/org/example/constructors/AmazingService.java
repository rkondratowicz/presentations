package org.example.constructors;

import static org.example.lib.Lib.*;

public class AmazingService {

    private final RulesEngine rulesEngine;
    private final Calculator calculator;
    private final AwesomeDependency awesomeDependency;

    public AmazingService(
        RulesEngine rulesEngine,
        Calculator calculator,
        AwesomeDependency awesomeDependency
    ) {
        this.rulesEngine = rulesEngine;
        this.calculator = calculator;
        this.awesomeDependency = awesomeDependency;
    }

    public void doStuff() {
        // my amazing code using the dependencies goes here
        rulesEngine.x();
        awesomeDependency.y();
        calculator.z();
    }
}
