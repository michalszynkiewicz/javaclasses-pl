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

Aby dodać jacksona do projektu mavenowego wystarczy dodać zależność:

```xml
  <dependencies>
     <dependency>
         <groupId>com.fasterxml.jackson.core</groupId>
         <artifactId>jackson-databind</artifactId>
         <version>2.7.3</version>
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

Napisz program:
1. który wczyta z pliku i zdeserializuje obiekt typu `Container`
2. wypisze na ekran wartości pól z datą i zawartością,
3. utworzy nowy obiekt typu `Container`  (lub użyje ponownie istniejący), ustawi datę na aktualną i tekst na dowolny.
4. zapisze obiekt z punktu 3. do pliku.

Przy pierwszym uruchomieniu nie będzie pliku. W tym wypadku program powinien utworzyć plik i pominąć kroki 1. i 2.

Uruchom program kilkukrotnie. Obejrzyj zawartość pliku.

## 3. Zapisz i odczytaj JSON
Zastąp zapisywanie i odczytywanie danych w formie binarnej, zapisem i odczytem w postaci tekstowej (np JSON)
