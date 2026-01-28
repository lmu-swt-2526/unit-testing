# Unit Testing mit pytest

## Setup

```bash
python3 -m venv .venv
source .venv/bin/activate
pip install -r requirements.txt
```

## Tests ausführen

```bash
# Alle Tests einer Aufgabe ausführen
pytest tests/test_aufgabe1_bug_finding.py

# Einen einzelnen Test ausführen
pytest tests/test_aufgabe1_bug_finding.py::test_transfer_small_amount

# Alle Tests ausführen
pytest
```

## Aufgaben

| Aufgabe | Datei | Thema |
|---------|-------|-------|
| 1 | `test_aufgabe1_bug_finding.py` | Bug-Finding mit Unit Tests |
| 2 (Beispiel) | `test_aufgabe2_beispiel.py` | Setup/Teardown mit Fixtures |
| 2 (Aufgabe) | `test_aufgabe2_aufgabe.py` | Fixtures selbst implementieren |
| 3 (Beispiel) | `test_aufgabe3_beispiel.py` | Manuelles Mocking |
| 3 (Aufgabe) | `test_aufgabe3_aufgabe.py` | Mocking selbst implementieren |

## Linting

```bash
ruff check src/ tests/
ruff format src/ tests/
```
