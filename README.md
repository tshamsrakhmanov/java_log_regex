Артефакт 2 - ИПР 1 - Java

Прога для анализа лог-файла с использованием regex


```
JAVA_LOG_REGEX [ HELP ]
Usage: java -jar <jar_name> [REGEX] [PATH] [FILE NAME]
[REGEX]{mandatory}
    Regular expression by which each string of log file(s) will be matched
    Matching process performed based on partly-matches, not a full-string
    Correct regex must be provide
[PATH]{mandatory}
    Path to a folder, where log files reside
    In case of missing .log files - program will exit with no result
[FILE NAME]
    Name of a file - with or without extention based on your desires - where to save regex match results
    Multiple runs of the program with the same input - .log files - will lead to fill of the same file with same match results (append mode)

Author: Timur Shamsrakhmanov
Autumn 2024
```