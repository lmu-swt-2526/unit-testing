package de.swt.testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Aufgabe 2: Setup und Teardown selbst implementieren
 *
 * <p>Diese Testklasse testet {@link TempFileProcessor}. Das Feld {@code processor}
 * ist bereits deklariert, aber es fehlen {@code @BeforeEach} und {@code @AfterEach}.
 *
 * <p>Ihre Aufgaben:
 * <ol>
 *   <li>Implementieren Sie eine {@code @BeforeEach}-Methode, die {@code processor}
 *       mit dem temporären Verzeichnis {@code tempDir} initialisiert.</li>
 *   <li>Implementieren Sie eine {@code @AfterEach}-Methode, die alle Dateien im
 *       temporären Verzeichnis nach jedem Test löscht.</li>
 * </ol>
 *
 * <p>Schauen Sie sich {@link Aufgabe2_BeispielTest} als Referenz an.
 */
class Aufgabe2_AufgabeTest {

    @TempDir
    Path tempDir;

    private TempFileProcessor processor;

    // TODO: Implementieren Sie eine @BeforeEach-Methode, die processor initialisiert.

    // TODO: Implementieren Sie eine @AfterEach-Methode, die alle Dateien aufräumt.

    @Test
    void readFileReturnsCorrectContent() throws IOException {
        // Dieser Test schlägt fehl, solange setUp() nicht implementiert ist.
        // Arrange
        String filename = "aufgabe.txt";
        String expectedContent = "Setup und Teardown funktionieren";
        processor.processFile(filename, expectedContent);

        // Act
        String content = processor.readFile(filename);

        // Assert
        assertEquals(expectedContent, content);
    }
}
