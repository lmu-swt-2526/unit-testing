package de.swt.testing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Processes files in a temporary directory.
 */
public class TempFileProcessor {

    private final Path tempDir;

    public TempFileProcessor(Path tempDir) {
        this.tempDir = tempDir;
    }

    /**
     * Writes content to a file in the temporary directory.
     *
     * @param filename the name of the file
     * @param content the content to write
     * @throws IOException if writing fails
     */
    public void processFile(String filename, String content) throws IOException {
        Files.writeString(tempDir.resolve(filename), content);
    }

    /**
     * Reads the content of a file from the temporary directory.
     *
     * @param filename the name of the file
     * @return the file content
     * @throws IOException if reading fails
     */
    public String readFile(String filename) throws IOException {
        return Files.readString(tempDir.resolve(filename));
    }

    /**
     * Returns the temporary directory used by this processor.
     */
    public Path getTempDir() {
        return tempDir;
    }
}
