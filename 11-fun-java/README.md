# Zaliczenie
Omówienie kryteriów oceniania

# Rozszerzenia z Java 8

## Funkcja jako parametr

### Zadanie: Sortowanie listy

Napisz klasę `Pracownik` z polami `pensja` i `imie` i `nazwisko`.

Napisz metodę która posortuje pracowników po kluczu (`nazwisko`, `imie`).
Dopisz metodę która posortuje pracowników po kluczu (`pensja`, `nazwisko`, `imie`).

Użyj metody `Collections::sort` albo `List::sort` i stwórz odpowiedni komparator.

Zastąp komparator *lambda expression*

Przenieś logikę sortującą do metody i zastąp *lambda expression* metodą.

## Stream
https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html

**Uwaga!** `Stream` można przejść tylko jeden raz!

### Zadanie: filtrowanie

Utwórz klasę `Osoba` z polami `imie` i `nazwisko` (i konstruktorem pobierającym wartości pól jako parametry).

Z listy pracowników z poprzedniego zadania wybierz liste osób, których pensja jest wyższa niż 3000.

Skorzystaj z metody `stream()` dla kolekcji i m.in. `map` oraz `collect(...)` dla strumieni.

### Zadanie: Czy pierwsza
Korzystając z `IntStream.range` i `findAny` sprawdź czy dana liczba jest pierwsza


# Zadanie
Przejrzyj swój projekt zaliczeniowy i znajdź w nim miejsca, gdzie możesz zastosować rozwiązania z Javy8
