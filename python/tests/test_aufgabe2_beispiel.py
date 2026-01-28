"""Beispiel: Setup und Teardown mit pytest Fixtures

Die Klasse TempFileProcessor arbeitet mit Dateien in einem temporären
Verzeichnis. Vor jedem Test wird ein frischer Processor erstellt, nach jedem Test
werden alle Dateien im temporären Verzeichnis gelöscht.

In pytest übernehmen *Fixtures* die Rolle von ``@BeforeEach`` und ``@AfterEach``.
Eine Fixture ist eine Funktion mit dem Decorator ``@pytest.fixture``, die ein
Testobjekt bereitstellt. Code vor dem ``yield`` entspricht dem Setup, Code danach
dem Teardown.

Siehe auch:
    https://docs.pytest.org/en/stable/how-to/fixtures.html
    https://docs.pytest.org/en/stable/how-to/tmp_path.html

``tmp_path`` ist eine eingebaute pytest-Fixture, die für jeden Test ein eigenes
temporäres Verzeichnis bereitstellt. pytest kümmert sich automatisch um das
Aufräumen — ein manuelles Teardown ist hier nicht nötig, wird aber zur
Veranschaulichung gezeigt.
"""

import pytest

from src.temp_file_processor import TempFileProcessor


@pytest.fixture
def processor(tmp_path):
    """Erstellt einen TempFileProcessor mit einem temporären Verzeichnis.

    Code vor ``yield``: Setup (entspricht @BeforeEach).
    Code nach ``yield``: Teardown (entspricht @AfterEach).
    """
    proc = TempFileProcessor(tmp_path)
    yield proc
    # Aufräumen: Alle Dateien im temp-Verzeichnis löschen
    for file in tmp_path.iterdir():
        file.unlink(missing_ok=True)


def test_write_and_read_file(processor):
    # Arrange
    filename = "test.txt"
    expected_content = "Hello World"
    processor.process_file(filename, expected_content)

    # Act
    content = processor.read_file(filename)

    # Assert
    assert content == expected_content


def test_overwrite_file_replaces_content(processor):
    # Arrange
    filename = "data.txt"
    expected_content = "new content"
    processor.process_file(filename, "old content")
    processor.process_file(filename, expected_content)

    # Act
    content = processor.read_file(filename)

    # Assert
    assert content == expected_content
