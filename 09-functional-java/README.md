# Rozszerzenia z Java 8

## Funkcja jako parametr

### Zadanie: Sortowanie listy

Napisz klasę `Pracownik` z polami `pensja` i `imie` i `nazwisko`.

Napisz metodę która posortuje pracowników po kluczu (`nazwisko`, `imie`).
Dopisz metodę która posortuje pracowników po kluczu (`pensja`, `nazwisko`, `imie`).

Zacznij od napisania testów do w/w metod.

Implementując metody:
1. Użyj metody `Collections::sort` albo `List::sort` i stwórz odpowiedni komparator.
1. Zastąp komparator *lambda expression*
1. Przenieś logikę sortującą do metody i zastąp *lambda expression* [referencją do metody](https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html).

## Stream
https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html

**Uwaga!** `Stream` można przejść tylko jeden raz!

### Zadanie: filtrowanie

Do przechowywania danych wykorzystaj klasę `Pracownik` z poprzedniego zadania.

Napisz metodę, która z listy pracowników wybierze listę osób, których pensja jest wyższa niż 3000.

Skorzystaj z metody `stream()` dla kolekcji i m.in. `map` oraz `collect(...)` dla strumieni.

## Zadanie domowe : Czy pierwsza
Korzystając z `IntStream.range` i `findAny` sprawdź czy dana liczba jest pierwsza
