# Unit Testing Übung

## Lernziele

- Bugs durch gezielte Unit Tests aufdecken
- Setup und Teardown mit `@BeforeEach` und `@AfterEach` verwenden
- Abhängigkeiten durch manuelles Mocking und Mockito ersetzen

## Ausführen

```bash
./gradlew test
```

Die Testergebnisse finden Sie unter `build/reports/tests/test/index.html`.

## Aufgaben

| Aufgabe | Datei | Thema |
|---------|-------|-------|
| 1 | `Aufgabe1_BugFindingTest.java` | Bugs in `BankingService` finden |
| 2 | `Aufgabe2_SetupTeardownTest.java` | Setup/Teardown mit Dateien |
| 3 | `Aufgabe3_MocksTest.java` | Mocking von Hand und mit Mockito |

Jede Testdatei enthält fertige Beispiele und mit `TODO` markierte Stellen, die Sie implementieren sollen. Suchen Sie nach `fail("Test noch nicht implementiert")`.

## Tipps

- Lesen Sie die JavaDoc der zu testenden Klassen, bevor Sie Tests schreiben.
- Vergleichen Sie dokumentiertes Verhalten mit tatsächlichem Verhalten.
- Ein `@Disabled`-Test dient als Referenz — nicht als Lösung.

## Bonus

- Ersetzen Sie den manuellen Mock in Aufgabe 3 durch Mockito (auskommentiertes Beispiel am Ende der Datei).
- Schreiben Sie einen parametrisierten Test mit `@ParameterizedTest` für `BankingService.transfer`.
