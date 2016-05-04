# 1. Kompilacja i uruchamianie
```bash
javac MojaKlasa.java
```
Powyższe wywołanie kompiluje MojaKlasa.java do MojaKlasa.class.

**Ważne!** Plik wyjściowy nie jest plikiem wykonywalnym. `javac` kompiluje klasę do bytecodu javy.
Aby uruchomić program należy użyć:
```bash
java MojaKlasa
```

Jeśli nasz kod używa jakichś bibliotek musimy je dołączyć przy kompilacji i przy uruchomieniu. Służy do tego opcja `-classpath` (w skrócie `-cp`):

```bash
$ javac -classpath lib.jar MyClass.java
```
```bash
$ javac -cp lib.jar MyClass.java
```
```bash
$ javac -cp ".;lib.jar;/path/to/lib/dir/*" MyClass
```

# 2. "Uruchamialne" klasy
Metoda `main` z C/C++ ma swój odpowiednik w Javie w postaci metody:
```java
public static void main(String[] args)
```
lub
```java
public static void main(String... args)
```

gdzie `args` jest tablicą parametrów.

# 3. Wypisywanie na standardowe wyjście
Obiekt zapewniający dostep do *stdout* to `System.out`. Odpowiednik dla *stderr*: `System.err`.

Aby wypisać tekst na standardowe wyjście możemy użyć np:
```java
System.out.println("tekst do wypisania");

```

# 4. IDE
Polecam IntelliJ IDEA. Za darmo można używać wersji Community Edition.

Przy pomocy wydziałowego maila można ubiegać się o akademicką licencję na Ultimate Edition.

https://www.jetbrains.com/idea/#chooseYourEdition


# 5. * Maven
Generowanie projektu:
```bash
mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app
 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

Kod źródłowy umieszczamy w `src/main/java`.
Testy w `src/test/java`.

Jeśli potrzebujemy jakiejś biblioteki, dodajemy ją do sekcji `dependencies` w pliku `pom.xml`.

Np żeby użyć `com.google.guava:guava` dodajemy:
```xml
...
<dependencies>
  ...
  <dependency>
    <groupId>com.google.guava</groupId>
    <artifactId>guava</artifactId>
    <version>19.0</version>
  </dependency>
</dependencies>
...
```


Wyszukiwarka bibliotek (przeszukuje standardowe repozytorium): http://search.maven.org/
