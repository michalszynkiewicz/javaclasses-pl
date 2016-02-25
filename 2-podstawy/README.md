# 1. Klasy i obiekty
Definicja klasy:

```java
/** MojaKlasa.java */
public class MojaKlasa {
  public static String metodaStatyczna() {
    System.out.println("foo");
  }

  public String metodaObiektu() {
    System.out.println("foo");
  }
}
```

Tworzenie obiektu danej klasy:
```java
MojaKlasa mojObiekt = new MojaKlasa();
```

Przyjmijmy na razie, że każdą klasę tworzymy w osobnym pliku.

# 2. Interfejsy

Interfejs to taki kontrakt. Dzięki interfejsom, możemy pisać części programów niezależnie od konkretnej implementacji. Pozwala to łatwo zmieniać implementację i dokładać nowe implementacje.

Tu trochę o koncepcie interfejsu:
https://docs.oracle.com/javase/tutorial/java/concepts/interface.html

Definiowanie interfejsu:

```java
/** MojInterfejs.java */
public interface MojInterfejs {
  void metodaA();
  String metodaB(Integer[] ints);
}
```

Interfejs implementujemy w następujący sposób:
```java
public class MojaKlasa2 implements MojInterfejs {
  public void metodaA() {
    System.out.println("wywołano metodę A");
  }
  public String metodaB(int [] ints) {
    System.out.println("wywołano metodę B");
    return "to jest metoda B"
  }
}
```

# 3. Fabryka
Przykładem wzorca, w którym wykorzystujemy interfejsy jest Fabryka (Factory), która działa w następujący sposób:


```java
public interface Worker {
  void run();
}
```

```java
public interface LocalWorker {
  public void run() {
    ...
  }
}
```

```java
public interface RemoteWorker {
  public void run() {
    ...
  }
}
```

```java
public enum WorkerType {
  LOCAL,
  DISTRIBUTED
}
```

```java
public class WorkerFactory {
  public static Worker createWorker(WorkerType type) {
    switch(type) {
      case LOCAL:
        return new LocalWorker();
      case DISTRIBUTED:
        return new RemoteWorker();
      default:
        throw new IllegalArgumentException("Unsupported worker type: " + type);
    }
  }
}
```

Sposób użycia:
```java
Worker w = WorkerFactory.createWorker(type);
w.run();
```

# 4. Zadanie: Agregator

Napisz program o parametrach:

typ_agregacji a1, a2, a3, a4, a5, a6, a7, a8, a9...

gdzie typ_agregacji należy do zbioru {+, *}


W zależności od typu agregacji (+, *), program ma wypisać zagregowane (zsumowane, pomnożone) argumenty.


Żeby ułatwić rozszerzanie programu, utwórz interfejs (interface) Aggregator i dwie implementacje, wybierane na podstawie typu agregacji.

Np:

| Wejście: | Wyjście |
|------ | ----- |
|+ 5 12 4 23 | 44|
|* 3 12 1 | 36|
