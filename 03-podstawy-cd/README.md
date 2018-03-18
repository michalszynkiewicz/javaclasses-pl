# 1. Wspólne zadanie

## A. Zwiedzanie skierowanego grafu acyklicznego (DAG)
Napisz klasę węzła `Node`. Węzeł powinien mieć nazwę typu `String` i listę sąsiadów.

Klasa powinna implementować metodę `void walkThrough(Visitor visitor)`,
 gdzie `Visitor` jest interfejsem implementującym metodę
`void visit(Node node)`.


Wywołanie `walkThrough(visitor)` na pewnym węźle *v* powinno zaskutkować wykonaniem
`visitor.visit` dla każdego z węzłów osiągalnych z *v*.


Przetestuj jej działanie przy pomocy testów.

# 2. Samodzielne

## A. Dziedziczenie
Napisz abstrakcyjną klasę `Animal` z:
- polem `name` oraz getterem i setterem do niego (patrz https://docs.oracle.com/javase/tutorial/javabeans/writing/properties.html)
- abstrakcyjną metoda `String moves()` zwracającą "walks", "flies" albo "swims" w zależności od tego w jaki sposób porusza się zwierzę
- abstrakcyjną metodą `String eatsAsAChild()` zwracającą "milk" albo "who knows?" w zależności od tego co jedzą małe danego gatunku


Utwórz klasy `Mammal`, `Bird` i `Fish` dziedziczące po `Animal` zawierające domyślne implementacje `moves` i `eatsAsAChild`.


Utwórz klasy `Bear`, `Whale`, 'Pigeon', `Penguin` i `Shark` dziedziczące po odpowiednich klasach.


Utwórz testy sprawdzające wartości zwracane przez `moves` i `eatsAsAChild` dla instancji powyższych klas.

## B. Suma przedziału
Napisz program, który wczyta ze standardowego wejścia listę liczb, wykona odpowiedni preprocessing, a następnie w czasie stały będzie umiał odpowiedzieć jaka jest suma elementów danego przedziału.

Pierwsza linia wejścia będzie zawierała listę elementów.
Każda kolejna będzie zawierała:
* parę liczb `a b` - kolejno początek (włącznie) i koniec (wyłącznie) przedziału, dla którego należy policzyć sumę
* `quit` - koniec programu

Np.

Wejście:
```
6 4 3 3 5 7 4 2
4 5
0 0
0 1
1 4
quit
```

Wyjście:
```
5
0
6
10
```
