# Wątki

## Omówienie zadań domowych

## Executor
Alternatywą dla bezpośredniego użycia `Thread` jest wykorzystanie `Executor` i `ExecutorService`:
https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ExecutorService.html

## Zadanie
Przerób rozwiązanie zadania *Wyścig* z poprzedniego tygodnia tak, żeby korzystały z Executor

# HTTP i servlety

Najłatwiej "wystawić" servlet http korzystając z jednego z serwerów webowych.

Jednym z serwerów, który można uruchomić z `main`a jest *undertow* (http://undertow.io)

Przykład wystawiania servletu:
https://github.com/undertow-io/undertow/blob/master/examples/src/main/java/io/undertow/examples/servlet/ServletServer.java

Jak pisać servlety: http://www.oracle.com/technetwork/java/servlet-142430.html

## Zadania

### Hello web!
Napisz servlet, który przy wywołaniu metody GET zwróci "Hello web!".

Korzystając z undertow lub jetty wystaw servlet na porcie 8080.

Uruchom przeglądarkę i wejdź na http://localhost:8080

Zweryfikuj, że wyświetlono "Hello web"

### simpleREST
Napisz i wystaw servlet, który obsłuży metody w następujący sposób:

- POST: doda tekst przesłany jako *content* do kolekcji
- GET: wypisze listę elementów kolekcji

Żeby wywołać metodę POST możesz użyć:
```bash
curl -d *dane do wysłania* *adres*
```

Do wywołania metody GET można wykorzystać przeglądarkę, `wget` albo `curl`.

Zgodnie z *Single Responsibility Principle* [1], wydziel listę przechowującą dane oraz metody do "zapamiętywania" i "wyciągania" elementów do osobnej klasy.


[1] https://en.wikipedia.org/wiki/Single_responsibility_principle, https://pl.wikipedia.org/wiki/Zasada_jednej_odpowiedzialno%C5%9Bci

### simple jsonREST

Utwórz klasę `Entity` z polami `id`, `firstname`, `lastname`.

Zmodyfikuj rozwiązanie powyższego zadania tak, aby:
- serwlet deserializował tekst przychodzący (w POST) do obiektu klasy Entity.
- metoda GET zwracała tekst zserializowany do JSONa.

Do serializacji i deserializacji JSONa możesz użyć biblioteki opisanej w https://github.com/michalszynkiewicz/javaclasses-pl/tree/master/5-serialization-and-files

### * jsonREST
Dodaj obsługę zapytań:
- `GET /*id*`, które zwraca tylko jeden element kolekcji, ten o zadanym identyfikatorze
- `DELETE /*id*`, które usuwa element kolekcji o zadanym identyfikatorze

Zmodyfikuj rozwiązanietak, żeby dane były zapisywane do bazy danych.

### Static content server
Napisz program, który przyjmuje jeden argument wejściowy - ścieżkę do katalogu.
Następnie, na porcie 8081, wystawi servlet, który będzie "podawał" pliki leżące w danym katalogu.

Np, dla katalogu z zawartością: `index.html`, `home.html`, `myphoto.jpg` i zapytania:
`GET http://localhost:8081/index.html`, zwróci zawartość pliku `index.html` (analogicznie dla `GET .../home.html` i `GET .../myphoto.jpg`)
