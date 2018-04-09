# IO

## I. Stare

Jeśli chcemy coś uruchomić w nowym wątku, tworzymy obiekt implementujący `Runnable`, podajemy go w konstruktorze `Thread` i uruchamiamy przez `Thread#start()`.

Aby zaczekać na koniec działania wątku, użyj `Thread#join()`

Przykład w javadoku: https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html

Przy pracy z watkami często potrzebujemy synchronizacji.
Do synchronizacji służą np *locki*: https://docs.oracle.com/javase/tutorial/essential/concurrency/newlocks.html

Alternatywą dla *locków* jest użycie `synchronized`: https://docs.oracle.com/javase/tutorial/essential/concurrency/locksync.html, https://docs.oracle.com/javase/tutorial/essential/concurrency/syncmeth.html

## II. Executor
Alternatywą dla bezpośredniego użycia `Thread` jest wykorzystanie `Executor` i `ExecutorService`:
https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ExecutorService.html

### 1. Wyścig
Utwórz implementację klasy `Runnable`. W metodzie `run()` wypisz na ekran nazwę aktualnego wątku (`Thread.currentThread().getName()`)

Użyj konstruktora wątka poniżej żeby utworzyć 3 wątki z określonymi nazwami (np. wątek 1, wątek 2, wątek 3) wykorzystujące w/w implementację `Runnable`

https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html#Thread-java.lang.Runnable-java.lang.String-

Uruchom program.

Zmodyfikuj swoją implementację Runnable tak, żeby w pętli wypisywała 100 razy:
nazwa-wątka: numer-iteracji-pętli

Co się zmieni jeśli na początku każdej iteracji pętli dodasz `Thread.sleep(10)`.

## 2. Wyścig + Executor
Przerób rozwiązanie zadania *Wyścig* tak, żeby korzystały z Executor.
W rozwiązaniu tego zadania wątek może mieć automatycznie wygenerowaną nazwę.

### 3. Silnia

Napisz program który iteracyjnie oblicza silnię.

Następnie przerób go tak, żeby dzielił przedział 1..n na 5 kawałków i obliczał iloczyny tych kawałków w 5 wątkach.

Następnie wypisz na ekran wynik.
