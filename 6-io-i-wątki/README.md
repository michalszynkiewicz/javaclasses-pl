# A. IO

### 0. Dokończyć zadanie sprzed tygodnia

### 1. easy shell
Napisz prosty shell.
Program powinien pobierać od użytkownika następujące komendy:

- `pwd` - wypisuje ścieżkę do aktualnego katalogu
- `ls` - wypisuje katalogi i pliki z aktualnego katalogu
- `cd nazwa_katalogu` - zmienia aktualny katalog na zadany
- * `ls wyrażenie` - wypisuje katalogi i pliki z danego katalogu, których nazwy spełniają zadane wyrażenie (patrz: https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html)
- * `cat nazwa_pliku` - wypisuje na ekran zawartość danego pliku

Rozwiązaniem zadania niech będzie klasa EasyShell. Klasa powinna mieć pole `workingDirectory` ustawione początkowo na aktualny katalog (katalog, w którym uruchomiono program).

Do rozwiązania można użyć albo *nowych* klas z `java.nio` - `Path` i `Files`, albo oprzeć je na `File`.

# B. Wątki

## I. Stare

Jeśli chcemy coś uruchomić w nowym wątku, tworzymy obiekt implementujący `Runnable`, podajemy go w konstruktorze `Thread` i uruchamiamy przez `Thread#start()`.

Aby zaczekać na koniec działania wątku, użyj `Thread#join()`

Przykład w javadoku: https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html

Przy pracy z watkami często potrzebujemy synchronizacji.
Do synchronizacji służą np *locki*: https://docs.oracle.com/javase/tutorial/essential/concurrency/newlocks.html

Alternatywą dla *locków* jest użycie `synchronized`: https://docs.oracle.com/javase/tutorial/essential/concurrency/locksync.html, https://docs.oracle.com/javase/tutorial/essential/concurrency/syncmeth.html

### 1. Runnable i Thread
Utwórz implementację klasy `Runnable`. W metodzie `run()` wypisz na ekran nazwę aktualnego wątku (`Thread.currentThread().getName()`)

Użyj konstruktora wątka poniżej żeby utworzyć 3 wątki z określonymi nazwami (np. wątek 1, wątek 2, wątek 3) wykorzystujące w/w implementację `Runnable`

Uruchom program.

### 2. Silnia

Napisz program który iteracyjnie oblicza silnię.

Następnie przerób go tak, żeby dzielił przedział 1..n na 5 kawałków i obliczał iloczyny tych kawałków w 5 wątkach.

Następnie wypisz na ekran wynik.

## II. Executor
Alternatywą dla bezpośredniego użycia `Thread` jest wykorzystanie `Executor` i `ExecutorService`:
https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ExecutorService.html


# Zadanie domowe
Przerób rozwiązania zadań z B.I tak, żeby korzystały z Executor
