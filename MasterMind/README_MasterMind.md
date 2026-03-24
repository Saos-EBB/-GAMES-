# MasterMind

A terminal-based Mastermind game built in Java — focused on logic design, colored output, and pin evaluation algorithms.

![Java](https://img.shields.io/badge/Java-21-orange) ![Status](https://img.shields.io/badge/Status-Playable-green) ![Type](https://img.shields.io/badge/Type-Game-blue)

---

## About the Project

A text-based clone of the classic Mastermind board game written in Java.  
The main goal was to practice algorithmic thinking, working with arrays, and building a clean colored terminal UI.

A secret 4-digit code is generated at the start. You have 10 attempts to crack it using pin feedback after each guess.

---

## Features

- Color-coded board — each digit gets its own ANSI color
- Black & white pin feedback — correct position vs. correct digit
- 10 rounds — secret is revealed at the end win or lose
- Input validation — only accepts valid 4-digit codes (1–6)
- ASCII troll screen on defeat 💀

---

## How to Play

Enter a 4-digit code using digits **1 to 6** (e.g. `1234`, `5612`).  
After each guess, pins tell you how close you were:

| Pin | Meaning |
|---|---|
| `#` | Right digit, right position |
| `+` | Right digit, wrong position |

```
+---+---+---+---+------+
| 1 | 2 | 3 | 4 | #++  |
+---+---+---+---+------+
```

Crack the secret code before round 10 runs out — or face the troll.

---

## Project Structure

```
src/
└── MasterMind.java     # Game loop, evaluation, board print, input
```

---

## Getting Started

**Requirements**
- Java 21 or higher

**Run the project**
```bash
javac MasterMind.java
java MasterMind
```

---

## OOP Concepts Used

This project was built to practice core Java fundamentals:

- **2D arrays** — full board state stored as `int[11][6]`
- **Array copying** — `Arrays.copyOf()` to avoid mutating original data in `evaluate()`
- **Switch expressions** — clean color mapping per digit value
- **ANSI colors** — color-coded terminal output for each digit
- **Input validation** — regex-based check with a clean while-loop

---

## Author
Kevin SCHABERL
Built as a learning project to practice Java fundamentals.
