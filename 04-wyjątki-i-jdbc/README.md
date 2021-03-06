# 1. Wyjątki
W Javie błędne wykonanie jsest sygnalizowane wyjątkami. Wyjątki są podklasami klasy `Exception`

Wyjątek może być *kontrolowany* (zwykły) lub *niekontrolowany* (runtime);
- kontrolowane wyjątki: metoda rzucająca taki wyjątek musi go deklarować na poziomie deklaracji metody (`void foo() throws SomeNastyException {...}`).
- wyjątki typu *runtime* nie muszą być deklarowane.

Teoria mówi, że sytuacje błędne, które *mają prawo* się wydarzyć, sygnalizować należy wyjątkami zwykłymi, zaś sytuacje, które nigdy nie powinny się wydarzyć, wyjątkami typu *runtime*.

(W praktyce w dużych systemach używa się głównie wyjątków typu *runtime*, również np dla błędów walidacji, i definiuje się różnego rodzaju *exception handlery*).


Rzucony wyjątek można złapać, służy do tego konstrukcja `try-catch`:
```java
try {
  int a = Integer.valueOf(wczytanyTekst);
} catch (NumberFormatException nfe) {
  System.out.println("wartość nie jest liczbą");
}
```

Rzucanie wyjątku:

```java
throw new RuntimeException("coś jest bardzo źle!");
```

Niektóre zasoby wymagają zamknięcia (wywołania na nich `close()`) po użyciu. Tak jest np z `Statement` z JDBC. Zamknięcia dokonujemy zazwyczaj w bloku `finally`, który może być dodany do `try-catch`:

```java
FileWriter fw = null;
try {
  fw = new FileWriter(...);
  fw.append(...);
} catch(IOException e) {
  throw new RuntimeException("something wrong happened", e);
} finally {
  if (fw != null) {
    fw.close();
  }
}
```

Jeśli takie obiekty implementują interfejs `AutoCloseable`, możemy to napisać w skrócie:
```java
try (FileWriter fw = new FileWriter(...)) {
  fw.append(...);
} catch(IOException e) {
  throw new RuntimeException("something wrong happened", e);
}
```
Powyższa konstrukcja nosi nazwę `try-with-resources` (blok `catch` jest w niej opcjonalny).


## Zadanie: *liczba czy nie*
Napisz program, który wczyta tekst ze standardowego wejścia i wypisze `TAK` jeśli tekst jest liczbą, `NIE` w przeciwnym przypadku.

# 2. JDBC
JDBC to wbudowany w Javę mechanizm *rozmawiania* z bazą danych.

Aby połączyć się z bazą, musimy utworzyć `Connection`: https://docs.oracle.com/javase/tutorial/jdbc/basics/connecting.html

Wykorzystując `Connection` możemy odczytywać i modyfikować dane w bazie danych:
https://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html

https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html


# 3. Zadanie *Premie*
Napisz program wykorzystujący bazę danych, który wczyta ze standardowego wejścia i wykona polecenie:
- `wstaw Imie Nazwisko premia` - wstaw do tabelki `premie` rekord (Imie, Nazwisko, premia)
- `suma` - wypisz sumę premii z wszystkich rekordów
- `usun Imie Nazwisko` - usuwa rekord (Imie, Nazwisko, \_)
- `wyjdz` - kończy działanie programu.

Do rozwiązania zadania użyj bazy danych H2.
Utwórz projekt przez _File > New > Project > Maven_. Do pliku `pom.xml` dodaj zależność od biblioteki h2:
```xml
<dependencies>
  <dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <version>...</version>
  </dependency>
</dependencies>
```
Znajdź najnowszą wersję biblioteki na http://search.maven.org

Po załączeniu biblioteki, połączenie do bazy można zdefiniować dla następującego *URL*:
`jdbc:h2:mem:`. Więcej opcji: http://www.h2database.com/html/features.html#database_url

Klasa, która "porozumiewa się" z bazą danych powinna być inna niż klasa definiująca `main`.
Może nosić nazwę `Repository`.

Pamiętaj o zamykaniu `Statement`ów.

Aby zainicjalizwać tabelę z premiami możesz użyć konstrukcji `CREATE TABLE IF NOT EXISTS...`.

Główna pętla programu może mieć np postać:
```java
public static void main(String[] args) throws SQLException {
    connection = createConnection();
    initDb();

    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] command = line.split(" ");
        switch (command[0]) {
            case "wyjscie":
                System.exit(0);
            case "wstaw":
                wstaw(line);
                System.out.println("wstawiono");
                break;
            case "suma":
                System.out.println(suma());
                break;
        }
    }
}
```
