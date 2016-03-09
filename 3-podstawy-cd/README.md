# 1. Wspólne zadanie

## A. DFS: Minimalny osiągalny węzeł
Zaimplementować DFS i znaleźć najmniejszy element osiągalny z `0` w grafie.

Wejście:
[wartość wierzchołka i] [lista sąsiadów wierzchołka i]

Np:
```
345 1,4
53 0,5
0
99 4,5
8 0,3,5
-12 1,3,4
```

Wyjście dla powyższego przykładu: `-12`

## B. DFS: Visitor i ilość osiągalnych węzłów
Zmodifykować implementację tak, aby wykorzystywała wzorzec Visitor ("odwiedzający") (https://en.wikipedia.org/wiki/Visitor_pattern)

Wykorzystać wprowadzone zmiany aby obliczyć ilość wierzchołków dostępnych z wierzchołka `0`.

# 2. Samodzielne

## A. Suma przedziału
Napisz program, który wczyta ze standardowego wejścia listę liczb, wykona odpowiedni preprocessing, a następnie w czasie stały będzie umiał odpowiedzieć jaka jest suma elementów danego przedziału.

Pierwsza linia wejścia będzie zawierała listę elementów.
Każda kolejna będzie zawierała:
* parę liczb a b - kolejno początek(włącznie) i koniec(wyłącznie) przedziału, dla którego należy policzyć sumę
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

## B. Sortowanie zależności
Na system YYY składa się wiele modułów. Niektóre moduły zależą od siebie.
Moduł `X` zależny od modułu `Y` może zostać uruchomiony dopiero, gdy moduł `Y` będzie uruchomiony.

Napisz program, który wczyta definicje modułów i poda prawidłową kolejność uruchamiania modułów lub zwróci błąd.

Każda z linii wejścia programu będzie składała się z jednej definicji modułu:
[nazwa_modułu] moduł_od_którego_zależy_1,moduł_od_którego_zależy_2,moduł_od_którego_zależy_3

Np.

Wejście:
```
modułA
modułB
modułC modułA, modułB
```

Przykładowe wyjście:

```
modułA
modułB
modułC
```

## C. B+=JSON
Zamiast wczytywania definicji modułów ze standardowego wejścia, wczytaj definicje z pliku w formacie JSON.

Wywołanie programu powinno mieć postać: `java DependencySorter input.json`, gdzie plik `input.json` będzie wyglądał w następujący sposób (dla danych takich jak w B):
```json
{
  "modules": [
    {"name": "modułA"},
    {"name": "modułA"},
    {"name": "modułA", "dependencies": ["modułA", "modułB"]}
  ]
}
```
