# Minesweaper V2

A terminal-based Minesweeper game built in Java — focused on game logic, input validation, and a radius-based reveal system.

![Java](https://img.shields.io/badge/Java-21-orange) ![Status](https://img.shields.io/badge/Status-Playable-green) ![Type](https://img.shields.io/badge/Type-Game-blue)

---

## About the Project

A text-based Minesweeper clone written in Java.  
The main goal was to practice logic design, clean input handling, and working with 2D arrays.

The map is randomly generated each game. Fields hide different reveal radii — one wrong move and you're blown up.

---

## Features

- Radius-based reveal system — safe fields reveal 1×1, 3×3, or 5×5 areas
- Random map every game — no two games are the same
- Duplicate input prevention — already-tried fields are blocked
- Progress tracking — see how many fields you've cleared each turn
- ASCII explosion screen on death 💀

---

## How to Play

Fields are addressed by **letter + number** (e.g. `A3`, `G7`).

```
   0  1  2  3  4  5  6  7  8  9
A [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ] A
B [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ] B
...
```

Each turn: type a coordinate and press Enter.  
Depending on what's hidden under the field, a different area gets revealed:

| Field type | Reveal area |
|---|---|
| Safe (small) | 1×1 |
| Safe (medium) | 3×3 |
| Safe (large) | 5×5 |
| Mine | 💥 Game over |

🟢 Green `[X]` = safe field revealed  
🔴 Red `[X]` = mine (you lost)

---

## Project Structure

```
src/
└── MinesweaperV2.java      # Game loop, map logic, input, rendering
```

---

## Getting Started

**Requirements**
- Java 21 or higher

**Run the project**
```bash
javac MinesweaperV2.java
java MinesweaperV2
```

---

## OOP Concepts Used

This project was built to practice core Java fundamentals:

- **2D arrays** — map state stored and manipulated as `int[][]`
- **Constants** — map values defined as `static final int` for readability
- **Input validation** — regex-based check with duplicate prevention via `ArrayList`
- **Switch expressions** — clean radius selection based on field value
- **ANSI colors** — terminal output with color-coded field states

---

## Author

Kevin SCHABERL
Built as a learning project to practice Java fundamentals.
