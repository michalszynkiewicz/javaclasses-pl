# Komentarze: Javadoc
Javadoc jest sposobem komentowania kodu, który możemy przekształcić w *ładną* dokumentację, taką jak: https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html

Javadoki można umieszczać na poziomie klasy, pól i metod. Są to komentarze blokowe, które zaczynają się od `/**`

Np:

```java
/**
* Constructs an empty list with the specified initial capacity.
*
* @param  initialCapacity  the initial capacity of the list
* @throws IllegalArgumentException if the specified initial capacity
         is negative
*/
public ArrayList(int initialCapacity) {
```

Dostępne tagi:
http://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html#CHDJFCCC


## Zadanie

W rozwiązaniu ostatniego z zadań z *7-wątki-i-http*, które udało Ci się zrobić, dodaj *javadoki* do klas i metod napisanych przez Ciebie.

Następnie wykonaj w konsoli polecenie:
```bash
$ mvn javadoc:javadoc
```

Poszukaj w katalogu target wygenerowanych plików html. Otwórz wygenerowany *javadoc* w przeglądarce.


# Testowanie: JUnit

### Ogólne zasady:
- Testujemy głównie przypadki brzegowe.
- Metody testujące, podobnie jak kod powinny być krótkie i łatwe do czytania
- jedna metoda testująca powinna testować tylko jeden przypadek (pozwala to łatwiej znaleźć problem)
- Z reguły do przetestowania metod jednej klasy, piszemy jedną klasę testującą.


## JUnit
Quickstart: https://github.com/junit-team/junit4/wiki/Getting-started

Aby korzystać z junit należy dodać go do `<dependencies>` w `pom.xml`.

### Metody testujące
Metody testujące określone zachowania adnotujemy `@Test`.
Jedna z konwencji mówi, żeby ich nazwy zaczynać od `should`. Np:
```java
@Test
public void shouldAddValidElement(){...}
```

### Inicjalizacja testuj
Jeśli potrzebujemy wykonać jakieś przygotowania dla każdego z testów w danej klasie testującej:
- jeśli inicjalizacja ma być wykonana raz dla całej klasy, tworzymy publiczną, statyczną metodę inicjalizującą i adnotujemy ją `@BeforeClass`
- jeśli inicjalizacja ma być wykonana dla każdej z metod testujących, tworzymy publiczną metodę inicjalizującą i adnotujemy ją `@Before`

## Zadanie
Napisz testy do klasy, która jest odpowiedzialna za przechowywanie elementów w programie wystawiającym proste RESTowe API.
