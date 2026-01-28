"""Processes files in a temporary directory."""

from pathlib import Path


class TempFileProcessor:
    """Processes files in a temporary directory."""

    def __init__(self, temp_dir):
        self._temp_dir = Path(temp_dir)

    def process_file(self, filename, content):
        """Write content to a file in the temporary directory."""
        self._temp_dir.joinpath(filename).write_text(content)

    def read_file(self, filename):
        """Read the content of a file from the temporary directory."""
        return self._temp_dir.joinpath(filename).read_text()

    @property
    def temp_dir(self):
        """Return the temporary directory used by this processor."""
        return self._temp_dir
