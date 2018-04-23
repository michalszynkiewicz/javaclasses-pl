# Sockety

Materiały:
- [Czytanie i pisanie z/do socketów](https://docs.oracle.com/javase/tutorial/networking/sockets/readingWriting.html)
- [Serwer](https://docs.oracle.com/javase/tutorial/networking/sockets/clientServer.html)

## Almost http client

Korzystając z `Socket`, napisz program który wyśle zapytanie na zadany URL i pobierze treść strony.

Tekst który należy wysłać żeby otrzymać odpowiedź od serwera http wyglądać może np tak:
```
GET /index.html HTTP/1.1\r\nHost: www.google.com\r\n\r\n
```

Serwer http odpowiada na żądania na porcie 80. Tj, aby pobrać stronę z google.com, należy połączyć się z hostem google.com i portem 80.

Pamiętaj, żeby po zakończeniu pisania zapytania do socketa (np do `PrintWritera`), wywołać `flush`.

## Web page server
Korzystając z `ServerSocket`, napisz program, który będzie nasłuchiwał na porcie 8383 i przy każdej próbie kontaktu (`serverSocket.accept`), do utworzonego socketa będzie wpisywał treść prostej strony.

Odpowiednią odpowiedź HTTP możesz skonstruować np w następujący sposób:
```java
String content = "<html>\n" +
                 "<body>\n" +
                 "  <h1>it works!</h1>\n" +
                 "</body>\n" +
                 "</html>";
out.write("HTTP/1.1 200 OK\r\n" +
          "Content-Type: text/html; charset=UTF-8\r\n" +
          "Content-Encoding: UTF-8\r\n" +
          "Content-Length: " + content.getBytes("UTF-8").length + "\r\n" +
          "\r\n" +
          content +
          "\r\n\r\n"
```

Otwórz przeglądarkę i przejdź na http://localhost:8383

## Simple chat
Napisz dwa programy, `ChatServer` i `ChatClient`.

`ChatServer`:
- uruchamiany z jednym parametrem, numerem portu
- nasłuchuje na zadanym numerze portu i wypisuje na ekran treść wiadomości które czyta

`ChatClient`:
- uruchamiany z trzema parametrami: nazwą hosta lub numerem IP, portem oraz tekstem do wysłania (podawanym w cudzysłowie)
- łączy się z zadanym hostem i portem i wysyła zadanym tekst.

Uruchom serwer. Spróbuj wysłać do niego wiadomość. Wyślij wiadomość do kolegi/koleżanki
