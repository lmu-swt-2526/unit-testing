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
 * Beispiel: Setup und Teardown mit {@code @BeforeEach} und {@code @AfterEach}
 *
 * <p>Die Klasse {@link TempFileProcessor} arbeitet mit Dateien in einem temporären
 * Verzeichnis. Vor jedem Test wird ein frischer Processor erstellt, nach jedem Test
 * werden alle Dateien im temporären Verzeichnis gelöscht.
 *
 * <p>{@code @BeforeEach} wird vor jedem Test ausgeführt und eignet sich für die
 * Initialisierung gemeinsamer Objekte. {@code @AfterEach} wird nach jedem Test
 * ausgeführt und eignet sich zum Aufräumen von Ressourcen.
 */
class Aufgabe2_BeispielTest {

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
        // Arrange
        String filename = "test.txt";
        String expectedContent = "Hello World";
        processor.processFile(filename, expectedContent);

        // Act
        String content = processor.readFile(filename);

        // Assert
        assertEquals(expectedContent, content);
    }

    @Test
    void overwriteFileReplacesContent() throws IOException {
        // Arrange
        String filename = "data.txt";
        String expectedContent = "new content";
        processor.processFile(filename, "old content");
        processor.processFile(filename, expectedContent);

        // Act
        String content = processor.readFile(filename);

        // Assert
        assertEquals(expectedContent, content);
    }
}
