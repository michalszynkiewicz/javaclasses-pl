# Zadania
## A. Sortowanie zależności
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

## B. A+=JSON
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
