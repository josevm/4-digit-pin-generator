# 4-digit PINs Generator

This library generates random 4-digit PINs. Compatible with Java v10 and above.

> **Note:** The implementation in this library is not Thread-safe. 

## Usage

1. [Download the artifact from the `build-lib` action](https://github.com/josevm/4-digit-pin-generator/actions)
or compile the library using the following command:

```bash
mvn clean install package
```

Requirements:
- [Maven](https://maven.apache.org/download.cgi) v3.6.3 or above
- [OpenJDK](https://openjdk.java.net/install/) v10 or above (`pom` currently configured to Java 17)

2. Add the downloaded/compiled jar (`pin-generator-0.0.1.jar`) to your project's dependency, e.i.:

```xml
<dependency>
    <groupId>org.lib.generators</groupId>
    <artifactId>pin-generator</artifactId>
    <version>0.0.1</version>
    <scope>system</scope>
    <systemPath>${basedir}/<<path_to>>/pin-generator-0.0.1.jar</systemPath>
</dependency>
```

3. Use the following example code to generate 1000 random 4-digit PINs:

```java
import org.generator.pins.FourDigitPinGenerator;
import org.generator.pins.PinGenerator;

public class Main {
    public static void main(String[] args) {
        PinGenerator pinGenerator = new FourDigitPinGenerator();

        System.out.println(pinGenerator.generate(1000));
    }
}
```

## Run Tests

```bash
mvn clean test
```