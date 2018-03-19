# 1. Wspólne zadanie

## A. Zwiedzanie skierowanego grafu acyklicznego (DAG)
Napisz klasę węzła `Node`. Węzeł powinien mieć nazwę typu `String` i listę sąsiadów.

Klasa powinna implementować metodę `void walkThrough(Visitor visitor)`,
 gdzie `Visitor` jest interfejsem implementującym metodę
`void visit(Node node)`.


Wywołanie `walkThrough(visitor)` na pewnym węźle *v* powinno zaskutkować wykonaniem
`visitor.visit` dla każdego z węzłów osiągalnych z *v*.


Przetestuj jej działanie przy pomocy testów dla `Visitor`a zbierającego nazwy osiągalnych węzłów.

# 2. Samodzielne

## A. Dziedziczenie
Napisz abstrakcyjną klasę `Animal` z:
- polem `name` oraz getterem i setterem do niego (patrz https://docs.oracle.com/javase/tutorial/javabeans/writing/properties.html)
- abstrakcyjną metoda `String moves()` zwracającą "walks", "flies" albo "swims" w zależności od tego w jaki sposób porusza się zwierzę
- abstrakcyjną metodą `String eatsAsAChild()` zwracającą "milk" albo "who knows?" w zależności od tego co jedzą małe danego gatunku


Utwórz klasy `Mammal`, `Bird` i `Fish` dziedziczące po `Animal` zawierające domyślne implementacje `moves` i `eatsAsAChild`.


Utwórz klasy `Bear`, `Whale`, `Pigeon`, `Penguin` i `Shark` dziedziczące po odpowiednich klasach.


Utwórz testy sprawdzające wartości zwracane przez `moves` i `eatsAsAChild` dla instancji powyższych klas.

### A' Enum
Zmień rozwiązanie tak, żeby metody `moves` i `eatsAsAChild` zwracały wartości typu wyliczeniowego (enum).

Patrz https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html

## Zadanie domowe: suma przedziału
Napisz klasę która w konstruktorze przyjmie listę liczb typu Double i będzie implementowała metodę `double subSum(int from, int to)` zwracającą sumę elementów od indeksu `from` (włącznie) do `to` (wyłącznie).


W konstruktorze klasa powinna przygotować odpowiednią strukturę żeby metoda `subSum` działała w czasie stałym.

Napisz testy sprawdzające poprawność obliczania sumy. Sprawdź, między innymi, czy prawidłowe wartości są zwracane dla pustego przedziału i dla całej.

Napisz również test wydajnościowy, który wygeneruje tablice z milionem losowych elementów i sprawdzi czy 1000 odpytań o wartości sumy podprzedziałów (1, 1_000_000 - 1), (2, 1_000_000 - 2), ... nie zajmie więcej niż 500 ms.


Np. dla listy: `6, 4, 3, 3, 5, 7, 4, 2` suma przedziału `(4, 5)` wynosi 5, a przedziału `(0, 0)` wynosi 0.
