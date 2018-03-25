# Info
## Pliki

Podstawowymi klasami służącymi do operacji na plikach są `File` i `Path`.

`File` można wykorzystać do tworzenia, usuwania, zmiany nazwy pliku itp.

`Path` można wykorzystać m.in. do trawersowania po systemie plików.

Można utworzyć obiekt klasy `File` z obiektu klasy `Path` przy pomocy metody `Path#toFile()`, zaś w drugą stronę przy pomocy: `File#toPath()`.

Więcej: https://docs.oracle.com/javase/tutorial/essential/io/fileio.html

Javadoki:
- https://docs.oracle.com/javase/8/docs/api/java/io/File.html
- https://docs.oracle.com/javase/8/docs/api/java/nio/file/Path.html

## Strumienie
Strumieni używamy między innymi do pisania do plików i czytania z plików.

Dane wczytujemy z `InputStream`, zaś wpisujemy do `OutputStream`.

Dla plików implementacjami w/w są odpowiednio `FileInputStream` i `FileOutputStream`.

**UWAGA:** Strumienie trzeba zamykać

Strumienie można tworzyć z obiektów `File` podając pliki w konstruktorze lub z obiektów `Path` przez `Files#newInputStream`, `Files#newOutputStream`

Więcej o strumieniach: https://docs.oracle.com/javase/tutorial/essential/io/streams.html

## Zapisywanie obiektów
Javowe obiekty możemy zapisywać np do plików przy pomocy `ObjectOutputStream` (ten strumień przyjmuje jako argument konstruktora inny strumień)

Analogicznie, do odczytu możemy wykorzystać `ObjectInputStream`.

Obiekt, który chcemy zserializować musi implementować interfejs `Serializable`.

https://docs.oracle.com/javase/tutorial/essential/io/objectstreams.html


## Serializacja do JSON
Opisana wyżej serializacja daje w wyniku dane binarne, co za tym idzie, nieczytelne dla człowiekal

Jeśli chcemy serializować obiekty do formy czytelnej dla człowieka możemy użyć np formatu XML lub JSON.

Dobrą i szybką biblioteką do przetwarzania JSONa jest jackson.

Aby dodać jacksona do projektu mavenowego wystarczy dodać zależność (najnowszą wersję zależności znajdź na http://search.maven.org):

```xml
  <dependencies>
     <dependency>
         <groupId>com.fasterxml.jackson.core</groupId>
         <artifactId>jackson-databind</artifactId>
         <version>...</version>
     </dependency>
  </dependencies>
```

Wystarczy utworzyć obiekt klasy `ObjectMapper` i użyć jego metod `readValue` i `writer().writeValue()`.

**UWAGA** domyślnie `ObjectMapper` wymaga *propertiesów* (setterów i getterów).

# Zadania

## 1. Tekst do pliku
Napisz program który utworzy plik /tmp/tresczadania.txt i zapisze do niego treść tego zadania.

## 2. Zapisz i odczytaj
Utwórz klasę `Container` z dwoma polami: `date` typu `Date` oraz `content` typu `String`.

Niech plikiem, na którym będzie działał program będzie `/tmp/container.bin`.

Napisz program, który:

1. jeśli plik istnieje, wczyta z pliku i zdeserializuje obiekt typu `Container`, a następnie wypisze na ekran wartości pól z datą i zawartością,

2. utworzy nowy obiekt typu `Container`  (lub użyje ponownie istniejący), ustawi datę na aktualną i tekst na dowolny.

3. zapisze obiekt z punktu 2. do pliku.

Przy pierwszym uruchomieniu nie będzie pliku. W tym wypadku program powinien utworzyć plik i pominąć kroki 1. i 2.

Uruchom program kilkukrotnie. Obejrzyj zawartość pliku.

## 3. Zapisz i odczytaj JSON
Zastąp zapisywanie i odczytywanie danych w formie binarnej, zapisem i odczytem w postaci tekstowej jako JSON.
Sprawdź co jest w pliku.

## 4. Shell
Napisz prosty shell.
Program powinien pobierać od użytkownika następujące komendy:

- `pwd` - wypisuje ścieżkę do aktualnego katalogu
- `ls` - wypisuje katalogi i pliki z aktualnego katalogu
- `cd nazwa_katalogu` - zmienia aktualny katalog na zadany
- * `ls wyrażenie` - wypisuje katalogi i pliki z danego katalogu, których nazwy spełniają zadane wyrażenie (patrz: https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html)
- * `cat nazwa_pliku` - wypisuje na ekran zawartość danego pliku

Rozwiązaniem zadania niech będzie klasa EasyShell. Klasa powinna mieć pole `workingDirectory` ustawione początkowo na aktualny katalog (katalog, w którym uruchomiono program).

Do rozwiązania można użyć albo *nowych* klas z `java.nio` - `Path` i `Files`, albo oprzeć je na `File`.

# Zadanie domowe
Napisz program, który uruchomiony w pewnym katalogu utworzy plik index.json zawierający listę elementów danego katalogu
opisaną w następujący sposób:
```json
[
{
  "name": "src",
  "type": "directory"
},
{
  "name": "pom.xml",
  "type": "file"
}
]
```

Napisz test do rozwiązania. Test powinien utworzyć katalog a w nim kilka plików i katalogów i sprawdzić czy index.json generowany dla niego jest prawidłowy.
