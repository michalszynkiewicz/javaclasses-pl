# Swing

## WYSIWYG
W Idei, utwórz projekt.

Podobnie jak nową klasę, możesz utworzyć Swingowy formularz lub okno "dialogowe" wybierając New > GUI Form lub New > Dialog.

Aby wyświetlić formularz (GUI Form) możesz np w utworzonym automatycznie panelu (`JPanel`) ustawić `field name`, następnie przejść do utworzonej klasy i napisać metodę `main`, która utworzy `JFrame` z panelem i je wyświetli (patrz sekcja **Główne okno** poniżej)

## Kod

[Tutorial](https://docs.oracle.com/javase/tutorial/uiswing/)

### Główne okno
[JFrame](https://docs.oracle.com/javase/tutorial/uiswing/components/frame.html)

### JPanel i rozmieszczanie elementów
JPanel to "worek" na elementy. Elemnty można rozmieszczać "ręcznie" - ustawiając ich rozmiar i pozycję. Można też użyć do tego "layoutów".

[JPanel](https://docs.oracle.com/javase/tutorial/uiswing/components/panel.html)
[Layouty](https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html)

### Reagowanie na zdarzenia
Aby obsłużyć zdarzenie, implementujemy pewien interfejs i rejestrujemy swoją implementację w swingowym obiekcie, np dla JButtona:
```java
JButton button = new JButton("My button");
button.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
          doSomething();
    }

});
```

[Tutorial](https://docs.oracle.com/javase/tutorial/uiswing/events/index.html)

# Zadania

## Formularz
Napisz program wyświetlający formularz z polami z imieniem, nazwiskiem, e-mailem i hasłem.
Dodaj guzik, po naciśnięciu którego dane zostaną wypisane do konsoli.


## Pliki w katalogu
Napisz program który wyświetli wszystkie pliki z katalogu w którym został uruchomiony

## midnight commander
Do powyższego dodaj możliwość przejścia do innego katalogu przez kliknięcie.
Przejście do innego katalogu powinno skutkować wyświetleniem zawartości nowego katalogu.
