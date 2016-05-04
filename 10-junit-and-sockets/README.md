# JUnit - c.d.

## Zadanie Kalkulator
Utwórz klasę `ModuloCalculator`, która oblicza wartości operacji modulo zadana liczba *n* (liczba powinna być przekazana w konstruktorze).

Zaimplementuj metody
  - `int add(int a, int b)` zwrającą sumę dwóch liczb modulo *n*
  - `int multiply(int a, int b` zwrającą iloczyn dwóch liczb modulo *n*
  - `int negate(int a)` zwrającą zanegowaną modulo *n*
  - `int power(int a, int b)` zwracającą a<sup>b</sup> modulo *n*

Napisz test `ModuloCalculatorTest` testującą powyższe.


# Sockety

Korzystając z https://docs.oracle.com/javase/tutorial/networking/sockets/clientServer.html i https://docs.oracle.com/javase/tutorial/networking/sockets/readingWriting.html
napisz dwie klasy:

1. `Viewer`, która:
  - utworzy `ServerSocket` i będzie nasłuchiwać na przychodzące połączenia (`accept`)
  - dla każdego z połączeń utworzy dedykowany wątek, który będzie odczytywał tekst z `Socket`a i wypisywał na ekran

1. `Agent`, która:
  - połączy się z serwerem - `Viewerem` (utworzy odpowiedni `Socket`)
  - w pętli będzie pobierać tekst ze standardowego wejścia i wpisywać go do `Socket`a

`Viewer` powinien być zbindowany do adresu 0.0.0.0. Powinien pobierać port jako *system property*

`Agent` powinien pobierać adres i port `Viewer`a jako *system property*


Spróbuj połączyć się agentem do viewera kolegi.

Utwórz plik /tmp/my-log.
Wywołaj:
```bash
tail -F /tmp/my-log | java Agent
```
Napisz coś do pliku /tmp/my-log i obserwuj jak zawartość pliku jest wyświetlana przez `Viewer`a
