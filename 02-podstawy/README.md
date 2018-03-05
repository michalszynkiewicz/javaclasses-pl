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

# 4. Fabryka
Przykładem wzorca, w którym wykorzystujemy interfejsy jest Fabryka (Factory), która działa w następujący sposób:


```java
public interface Worker {
  void run();
}
```

```java
public class LocalWorker {
  public void run() {
    ...
  }
}
```

```java
public class RemoteWorker {
  public void run() {
    ...
  }
}
```

```java
public enum WorkerType {
  LOCAL,
  DISTRIBUTED
}
```

```java
public class WorkerFactory {
  public static Worker createWorker(WorkerType type) {
    switch(type) {
      case LOCAL:
        return new LocalWorker();
      case DISTRIBUTED:
        return new RemoteWorker();
      default:
        throw new IllegalArgumentException("Unsupported worker type: " + type);
    }
  }
}
```

Sposób użycia:
```java
Worker w = WorkerFactory.createWorker(type);
w.run();
```

# 5. Zadania

## Agregator

Napisz program o parametrach:

typ_agregacji a1, a2, a3, a4, a5, a6, a7, a8, a9...

gdzie typ_agregacji należy do zbioru {+, *}


W zależności od typu agregacji (+, *), program ma wypisać zagregowane (zsumowane, pomnożone) argumenty.


Żeby ułatwić rozszerzanie programu, utwórz interfejs (interface) Aggregator i dwie implementacje, wybierane na podstawie typu agregacji.

Np:

| Wejście: | Wyjście |
|------ | ----- |
|+ 5 12 4 23 | 44|
|* 3 12 1 | 36|

## Stos i Odwrotna Notacja Polska

Zaimplementuj stos - strukturę z następującymi metodami:
- `push` - wkłada element na stos
- `pop` - zwraca element ostatnio odłożony na stos i usuwa go ze stosu
- `isEmpty` - sprawdza czy stos jest pusty

Implementację oprzyj na LinkedList, nie używając metody `LinkedList#pollLast`.

Napisz program, który ze standardowego wejścia wczyta wyrażenie zapisane w ONP (https://pl.wikipedia.org/wiki/Odwrotna_notacja_polska)
