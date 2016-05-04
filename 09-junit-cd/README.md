# JUnit - c.d.

[//]: # ( TODO: ZA TRUDNE ZADANIE!!! )

Patrz punkt Testowanie: JUnit w zajęciac 8-junit-i-javadoc

## TDD
Jedna z praktyk pisania programów.

Piszemy w niej równolegle testy i kod produkcyjny.

Iteracyjnie:
- jeśli aktualnie testy *przechodzą*, napisz kolejny kawałek testu
- jeśli testy nie *przechodzą* - napisz kawałek kodu produkcyjnego, tak żeby przechodziły

Piszemy tylko tyle kodu produkcyjnego, ile jest potrzebne żeby testy przechodziły.

http://butunclebob.com/ArticleS.UncleBob.TheThreeRulesOfTdd


## Zadanie: Zależności


Korzystając z TDD rozwiąż poniższe zadanie.

Projekt składa się z modułów. Niektóre z modułów zależą od innych.
Budowanie projektu polega na zbudowaniu wszystkich jego modułów w takiej kolejności, że
żaden moduł nie jest budowany zanim nie zostaną zbudowane wszystkie jego zależności.

Napisz program, który wczyta z pliku definicje modułów a następnie:

- sprawdzi czy istnieje cykl zależności między modułami - jeśli tak, wypisze: `znaleziono cykl` i zakończy swe działanie

- w p.p. wypisze jedną z prawidłowych kolejności budowania projektu
