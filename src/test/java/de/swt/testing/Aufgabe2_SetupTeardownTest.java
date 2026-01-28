package de.swt.testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Aufgabe 2: Setup und Teardown mit {@code @BeforeEach} und {@code @AfterEach}
 *
 * <p>Die Klasse {@link TempFileProcessor} arbeitet mit Dateien in einem temporären
 * Verzeichnis. Für jeden Test muss ein frisches Verzeichnis bereitstehen, und nach
 * jedem Test sollten die Dateien aufgeräumt werden.
 *
 * <p>In dieser Aufgabe ist das Setup bereits implementiert. Schreiben Sie weitere Tests
 * und beantworten Sie die Frage zum Teardown.
 */
class Aufgabe2_SetupTeardownTest {

    @TempDir
    Path tempDir;

    private TempFileProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new TempFileProcessor(tempDir);
    }

    @AfterEach
    void tearDown() throws IOException {
        // Aufräumen: Alle Dateien im temp-Verzeichnis löschen
        try (var files = Files.list(tempDir)) {
            for (Path file : files.toList()) {
                Files.deleteIfExists(file);
            }
        }
    }

    @Test
    void writeAndReadFile() throws IOException {
        processor.processFile("test.txt", "Hello World");

        String content = processor.readFile("test.txt");
        assertEquals("Hello World", content);
    }

    @Test
    void overwriteFileReplacesContent() throws IOException {
        processor.processFile("data.txt", "old content");
        processor.processFile("data.txt", "new content");

        String content = processor.readFile("data.txt");
        assertEquals("new content", content);
    }

    // ========================================================================
    // TODO: Schreiben Sie weitere Tests für TempFileProcessor.
    // ========================================================================

    @Test
    void todoCountLines() throws IOException {
        // TODO: Schreiben Sie eine Datei mit mehreren Zeilen und prüfen Sie,
        //       dass readFile den gesamten Inhalt inklusive Zeilenumbrüche zurückgibt.
        //       Tipp: Verwenden Sie "line1\nline2\nline3" als Inhalt.
        fail("Test noch nicht implementiert");
    }

    @Test
    void todoEmptyFile() throws IOException {
        // TODO: Was passiert, wenn eine leere Datei geschrieben und gelesen wird?
        fail("Test noch nicht implementiert");
    }

    @Test
    void todoReadNonExistentFile() {
        // TODO: Was passiert, wenn eine Datei gelesen wird, die nicht existiert?
        //       Welche Exception wird geworfen?
        fail("Test noch nicht implementiert");
    }

    // ========================================================================
    // Frage: Warum ist das tearDown() in diesem Fall eigentlich nicht zwingend
    // nötig? Was macht @TempDir automatisch?
    // ========================================================================
}
