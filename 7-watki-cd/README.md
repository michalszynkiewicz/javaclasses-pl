# Wątki

## Omówienie zadań domowych

## Executor
Alternatywą dla bezpośredniego użycia `Thread` jest wykorzystanie `Executor` i `ExecutorService`:
https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ExecutorService.html

## Zadanie
Przerób rozwiązanie zadania *Wyścig* z poprzedniego tygodnia tak, żeby korzystały z Executor

# HTTP i servlety

Najłatwiej "wystawić" servlet http korzystając z jednego z serwerów webowych.

Jednym z serwerów, który można uruchomić z `main`a jest *undertow* (http://undertow.io).

Biblioteka, którą należy dodać do zależności projektu to io.undertow:undertow-servlet (najlepiej użyć najnowszej wersji stabilnej - tj nie będąccej wersją Alpha, Beta, M*)

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

### simple jsonREST
Utwórz klasę `Entity` z polami `id`, `firstname`, `lastname`.

Zmodyfikuj rozwiązanie powyższego zadania tak, aby:
- serwlet deserializował tekst przychodzący (w POST) do obiektu klasy Entity.
- metoda GET zwracała tekst zserializowany do JSONa.

### jsonREST
Zmodyfikuj rozwiązanie poprzedniego zadania tak, żeby dane były zapisywane do bazy danych.

Dodaj obsługę zapytania `GET /*id*`, które zwraca tylko jeden element kolekcji, ten o zadanym identyfikatorze.
