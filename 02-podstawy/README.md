# 1. Testowanie
# Testowanie: JUnit

### Ogólne zasady:
- Testujemy głównie przypadki brzegowe.
- Metody testujące, podobnie jak kod powinny być krótkie i łatwe do czytania
- jedna metoda testująca powinna testować tylko jeden przypadek (pozwala to łatwiej znaleźć problem)
- Z reguły do przetestowania metod jednej klasy, piszemy jedną klasę testującą.

## JUnit
Quickstart: https://github.com/junit-team/junit4/wiki/Getting-started

Aby korzystać z junit należy dodać go do `<dependencies>` w `pom.xml`.

### Metody testujące
Metody testujące określone zachowania adnotujemy `@Test`.
Jedna z konwencji mówi, żeby ich nazwy zaczynać od `should`. Np:
```java
@Test
public void shouldAddValidElement(){...}
```

### Inicjalizacja testu
Jeśli potrzebujemy wykonać jakieś przygotowania dla każdego z testów w danej klasie testującej:
- jeśli inicjalizacja ma być wykonana raz dla całej klasy, tworzymy publiczną, statyczną metodę inicjalizującą i adnotujemy ją `@BeforeClass`
- jeśli inicjalizacja ma być wykonana dla każdej z metod testujących, tworzymy publiczną metodę inicjalizującą i adnotujemy ją `@Before`

### Przykładowy `pom.xml` z JUnit
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.mycompany</groupId>
  <artifactId>contact-book</artifactId>
  <version>1.0-SNAPSHOT</version>

  <!-- definicja wersji Javy -->
  <properties>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
  </properties>

  <dependencies>
    <!-- JUnit -->
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <scope>test</scope>
    </dependency>
    <!-- fajna bibliteka do sprawdzania czy wyniki spełniają oczekiwane warunki,
    więcej: http://joel-costigliola.github.io/assertj/ -->
    <dependency>
      <groupId>org.assertj</groupId>
      <artifactId>assertj-core</artifactId>
      <version>3.9.1</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
</project>
```

# 2. Klasy i obiekty
Definicja klasy:

```java
/** MojaKlasa.java */
public class MojaKlasa {
  public static String metodaStatyczna() {
    System.out.println("foo");
  }

  public String metodaObiektu() {
    System.out.println("foo");
  }
}
```

Tworzenie obiektu danej klasy:
```java
MojaKlasa mojObiekt = new MojaKlasa();
```

Przyjmijmy na razie, że każdą klasę tworzymy w osobnym pliku.

# 3. Interfejsy

Interfejs to taki kontrakt. Dzięki interfejsom, możemy pisać części programów niezależnie od konkretnej implementacji. Pozwala to łatwo zmieniać implementację i dokładać nowe implementacje.

Tu trochę o koncepcie interfejsu:
https://docs.oracle.com/javase/tutorial/java/concepts/interface.html

Definiowanie interfejsu:

```java
/** MojInterfejs.java */
public interface MojInterfejs {
  void metodaA();
  String metodaB(Integer[] ints);
}
```

Interfejs implementujemy w następujący sposób:
```java
public class MojaKlasa2 implements MojInterfejs {
  public void metodaA() {
    System.out.println("wywołano metodę A");
  }
  public String metodaB(int [] ints) {
    System.out.println("wywołano metodę B");
    return "to jest metoda B"
  }
}
```

# 4. Zadania

## Kontakty
Napisz program, który przechowuje dane kontaktowe.
Kontakt powinien składać się z następujących danych:
- nazwa (np imię i nazwisko)
- telefon
- email
- adres

Po uruchomieniu, program powinien w pętli wczytywać od użytkownika i obsługiwać
następujące polecenia:
- dodaj - prosi użytkownika o podanie danych kontaktu, następnie dodaje kontakt do bazy
- zmien - pobiera takie same dane jak dodaj, zmienia kontakt o danej nazwie
- usun - pobiera od użytkownika nazwę kontaktu i usuwa kontakt o danej nazwie
- wyszukaj - szuka kontaktu po nazwie lub części nazwy.

Program powinien składać się z co najmniej trzech klas: `Kontakt`, `Baza` i `Aplikacja`. `Aplikacja` powinna mieć zdefiniowaną metodę `main`, powinna też obsługiwać komunikację z użytkownikiem.
`Baza` powinna przechowywać wszystkie kontakty i dostarczać metod do (m.in.) dodawania, usuwania i wyszukiwania kontaktów.

Napisz testy JUnitowe do programu tak, żeby pokrycie testami (coverage) klasy `Baza` wynosiło 100%. Pokrycie testami można sprawdzić uruchamiając test przez `Run ... with Coverage`.

## Stos i Odwrotna Notacja Polska

Zaimplementuj stos - strukturę z następującymi metodami:
- `push` - wkłada element na stos
- `pop` - zwraca element ostatnio odłożony na stos i usuwa go ze stosu
- `isEmpty` - sprawdza czy stos jest pusty

Implementację oprzyj na LinkedList, nie używając metody `LinkedList#pollLast`.

Napisz program, który ze standardowego wejścia wczyta wyrażenie zapisane w ONP (https://pl.wikipedia.org/wiki/Odwrotna_notacja_polska)

Przetestuj kod wykorzystując testy JUnitowe.
