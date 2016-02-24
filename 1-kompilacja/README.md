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
