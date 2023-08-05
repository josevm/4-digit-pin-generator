# 4-digit PINs Generator

This library generates random 4-digit PINs. Compatible with Java v10 and above.

> **Note:** The implementation in this library is not Thread-safe. 

## Usage

1. Compile the library using the following command:

```bash
mvn clean install package
```

Requirements:
- [Maven](https://maven.apache.org/download.cgi) v3.6.3 or above
- [OpenJDK](https://openjdk.java.net/install/) v10 or above (`pom` currently configured to Java 17)

2. Add/move the compiled jar (`pin-generator-0.0.1.jar` in the `/target` folder) to your project's classpath.

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