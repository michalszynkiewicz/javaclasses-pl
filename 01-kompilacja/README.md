# Wprowadzenie

## 0. Środowisko pracy
Zachęcam do używania Linuksa i własnych komputerów.

### Instalacja Javy
Na zajęciach będziemy używać Javy 8, aby ją zainstalować:
- wybierz archiwum tar.gz dla Java SE Development Kit dla Linuksa x64 [na tej stronie](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- zaakceptuj licencję i pobierz plik
- wypakuj archiwum do katalogu domowego:
```
tar -xf <nazwa-pliku>.tar.gz
```
- dodaj ściężkę do katalogu zawierającego plik `java` do zmiennej `PATH`, np edytując plik `~/.profile`:
```
vim ~/.profile
```
poprzez dodanie następującej linii:
```
export PATH="$PATH:/pełna/ścieżka/do/katalogu/zawierającego/java"
```

## 1. Podstawy języka
[Tutoriale z podstaw Javy](https://docs.oracle.com/javase/tutorial/java/index.html)

[Specyfikacja API Javy (javadoc)](https://docs.oracle.com/javase/8/docs/api/index.html)

Składnia Javy przypomina składnię C/C++.
Kod, który piszemy w Javie musi być częścią klasy lub interfejsu.

Klasy/interfejsy możemy grupować w pakiety.
Klasa może mieć pola i metody.

Pola, metody i klasy mogą mieć poziomy dostępu/zasięgu: https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html


## 2. Kompilacja i uruchamianie
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

## 3. "Uruchamialne" klasy
Metoda `main` z C/C++ ma swój odpowiednik w Javie w postaci metody:
```java
public static void main(String[] args)
```
lub
```java
public static void main(String... args)
```

gdzie `args` jest tablicą parametrów.

## 4. Wypisywanie na standardowe wyjście
Obiekt zapewniający dostep do *stdout* to `System.out`. Odpowiednik dla *stderr*: `System.err`.

Aby wypisać tekst na standardowe wyjście możemy użyć np:
```java
System.out.println("tekst do wypisania");
// albo:
System.out.printf("liczba: %d", 23);
```

## 5. Środowisko programistyczne (IDE)
Polecam IntelliJ IDEA. Za darmo można używać wersji Community Edition.

Przy pomocy wydziałowego maila można ubiegać się o akademicką licencję na Ultimate Edition.

https://www.jetbrains.com/idea/#chooseYourEdition


## 6. * Maven
### Instalacja
- pobierz archiwum `-bin.tar.gz` lub `-bin.zip` z https://maven.apache.org/download.cgi
- rozpakuj
- dodaj do `PATH` ścieżkę do katalogu w którym znajduje się plik `mvn` (patrz Instalacja Javy)

### Generowanie projektu:
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


# Zadania
## A. Tabliczka mnożenia - wspólne zadanie
Napisz program, który dla zadanego `n` wypisze tabliczkę mnożenia do `n*n`, np:
```
  1  2  3  4  5  6  ... n
1 1  2  3  4  5  6  ... n
2 2  4  6  8  10 12 ... 2*n
...
                    ... n*n
```

Program powinien wczytywać `n` jako parametr wywołania, n.p.:
```
java TabliczkaMnozenia 13
```

## B. Ilość wyrazów
Napisz program, który [korzystając z `System.console()`](https://docs.oracle.com/javase/tutorial/essential/io/cl.html) wczyta tekst ze standardowego wejścia i wypisze ilość wyrazów w tekście.

[Javadoc dla Console](https://docs.oracle.com/javase/8/docs/api/java/io/Console.html#readLine--)

Wczytany tekst można podzielić na wyrazy np dzięki metodzie `split`:
```
String text = "aiosdjfo adsf oaijsdf asd f";
String[] splitText = text.split("\\s+");
```
Więcej informacji o wyrażeniach regularnych akceptowanych przez `String::split` [jest tutaj](https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html)

## C. Łączenie list

Napisz program, który połączy dwie posortowane listy liczb w jedną posortowaną listę.

Nową listę można stworzyć np w następujący sposób:
```java
List<Integer> lista = new ArrayList<>();
```
Aby utworzyć listę z pewnymi elementami (np w celu przetestowania rozwiązania) można wykorzystać metodę statyczną:
```java
Arrays.asList(1, 4, 5, 3)
```

Klasy `List`, `ArrayList` i `Arrays` są w pakiecie `java.util`, aby z nich skorzystać należy je zaimportować, np:
```java
import java.util.List;
```

[Javadoc dla List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)

## D. DFS: Minimalny osiągalny węzeł
Zaimplementuj DFS i znajdź najmniejszy element osiągalny z `0` w grafie.

Wejście:
[wartość wierzchołka i] [lista sąsiadów wierzchołka i]

Np:
```
345 1 4
53 0 5
0
99 4 5
8 0 3 5
-12 1 3 4
```

Wyjście dla powyższego przykładu: `-12`
