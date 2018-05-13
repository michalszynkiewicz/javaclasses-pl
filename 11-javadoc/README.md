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

W rozwiązaniu [zadania domowego z plików](https://github.com/michalszynkiewicz/javaclasses-pl/tree/master/05-serializacja-i-pliki#zadanie-domowe), dodaj *javadoki* do klas i metod napisanych przez Ciebie.

Następnie wykonaj w konsoli polecenie:
```bash
$ mvn javadoc:javadoc
```

Poszukaj w katalogu target wygenerowanych plików html. Otwórz wygenerowany *javadoc* w przeglądarce.



