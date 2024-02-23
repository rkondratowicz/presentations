<p align='center'>
    <img src="https://github.com/rkondratowicz/springonion/assets/2472141/e28e8f06-86e6-4244-aee1-adfd06b1063d" alt="logo"/>
</p>

# springonion
Opinionated Spring + Onion Architecture template

The project is organised using the clean/onion/haxagonal architecture and contains 3 modules:
- `domain` - a place for entities and business logic. Does not have dependencies on other modules
- `application` - connects intrastructure wit the domain. Defines ports (interfaces) that are implemented in the infrastructure module. Has a dependency on the domain module.
- `infrastructure` - the outer layer of the app. Used for communication with the outside world (web APIs, DBs, queues, etc.)

# What's included
- Java 21
- Gradle
- Lombok
- Spring Boot
- AssertJ
- Mockito
- `.editorconfig`
