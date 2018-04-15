# Wątki

# HTTP i servlety

Najłatwiej "wystawić" servlet http korzystając z jednego z serwerów webowych.

Jednym z serwerów, który można uruchomić z `main`a jest *jetty* (https://www.eclipse.org/jetty/)

Potrzebne zależności:
```xml
<dependency>
  <groupId>org.eclipse.jetty</groupId>
  <artifactId>jetty-server</artifactId>
  <version>${jetty.version}</version>
</dependency>
<dependency>
  <groupId>org.eclipse.jetty</groupId>
  <artifactId>jetty-servlet</artifactId>
  <version>${jetty.version}</version>
</dependency>
```

Przykładowy `main`:
```java
public static void main(String[] args) throws Exception {
    Server server = new Server(8080);
    ServletHandler handler = new ServletHandler();
    server.setHandler(handler);

    handler.addServletWithMapping(MySerlet.class, "/*");
    server.start();

    server.join();
}
```

Implementacja servletu powinna rozszerzać `HttpServlet`.

Aby obsłużyć zapytanie `GET` przedefiniowujemy metodę `doGet(...)`, dla `POST` - `doPost(...)` i.t.d.


Więcej:
http://www.eclipse.org/jetty/documentation/current/embedding-jetty.html#_embedding_servlets

Jak pisać servlety: http://www.oracle.com/technetwork/java/servlet-142430.html

Więcej informacji o HTTP: https://en.wikipedia.org/wiki/Hypertext_Transfer_Protocol

## Zadania

### Hello web!
Napisz servlet, który przy wywołaniu metody GET zwróci "Hello web!".

Korzystając z Jetty wystaw servlet na porcie 8080.

Uruchom przeglądarkę i wejdź na http://localhost:8080

Zweryfikuj, że wyświetlono "Hello web"

### simpleREST
Napisz i wystaw servlet, który obsłuży metody w następujący sposób:

- POST: doda tekst przesłany jako *zawartość* do kolekcji
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

Do serializacji i deserializacji JSONa możesz użyć biblioteki opisanej w https://github.com/michalszynkiewicz/javaclasses-pl/tree/master/05-serializacja-i-pliki#serializacja-do-json

Żeby zdeserializować przychodzący tekst możesz użyć:
```
mapper.readerFor(Entity.class).readValue(...)
```
gdzie `mapper` jest typu `ObjectMapper`.

### * jsonREST
Dodaj obsługę zapytań:
- `GET /*id*`, które zwraca tylko jeden element kolekcji, ten o zadanym identyfikatorze
- `DELETE /*id*`, które usuwa element kolekcji o zadanym identyfikatorze

Zmodyfikuj rozwiązanie tak, żeby dane były zapisywane do bazy danych.

### Static content server
Napisz program, który przyjmuje jeden argument wejściowy - ścieżkę do katalogu.
Następnie, na porcie 8081, wystawi servlet, który będzie "podawał" pliki leżące w danym katalogu.

Np, dla katalogu z zawartością: `index.html`, `home.html`, `myphoto.jpg` i zapytania:
`GET http://localhost:8081/index.html`, zwróci zawartość pliku `index.html` (analogicznie dla `GET .../home.html` i `GET .../myphoto.jpg`)

# * Log Aggreagtor - dodaktowe zadanie domowe (bez punktów)
Poczytaj trochę o RESTful Web-Services i JAX-RS, np :
- https://en.wikipedia.org/wiki/Representational_state_transfer
- https://en.wikipedia.org/wiki/Java_API_for_RESTful_Web_Services
- http://yarpo.pl/2012/07/29/rest-ciekawszy-sposob-na-komunikacje-client-server/
- https://docs.oracle.com/javaee/7/tutorial/jaxrs003.htm#GIPZZ

Utwórz system zbierający wpisy i udostępniający je przez RESTowe API.

Projekt powinien wykorzystywać Spring Boota i wystawiać RESTowe API napisane przy użyciu JAX-RS.
Szkielet projektu możesz wygenerować korzystając z https://start.spring.io/ dodając do *dependencies* Jersey (JAX-RS).

Obsłuż następujące zapytania:
- `GET <adres serwera>:<port>/log-entries` - pobierające wszystkie wpisy zapisane do tej pory
- `POST <adres serwera>:<port>/log-entries` - wstawiający nowy wpis

Dane mogą być przechowywane w pamięci (tj jako pole w jednej z klas projektu).

Wpis (*log entry*) powinien zawierać datę i tekst.

Dodatkowo, możesz dodać do wpisu listę tagów (np "tag": ["windows", "java"]) i parametr (*query param*) `tag` do `GET .../log-entries`, który pozwoli na pobranie wpisów z zadanym tagiem.
