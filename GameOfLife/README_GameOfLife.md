# Game of Life

Conway's Game of Life built in Java — a cellular automaton that simulates life, death, and repeating patterns.

![Java](https://img.shields.io/badge/Java-21-orange) ![Status](https://img.shields.io/badge/Status-Running-green) ![Type](https://img.shields.io/badge/Type-Simulation-blue)

---

## About the Project

A terminal-based implementation of Conway's Game of Life written in Java.  
The main goal was to implement the classic cellular automaton rules, build a working animation loop, and detect repeating cycles automatically.

This project pushed me further than anything I had built before. Getting the wrap-around grid, the cycle detection, and the animation timing to all work together took real effort. When it finally ran — cells appearing, dying, and forming patterns on their own — that moment made it clear why coding can become a passion.

---

## Features

- Random starting grid — configurable size and alive probability
- Wrap-around edges — the grid connects on all sides like a torus
- Conway's rules — birth, survival, and death per cell each generation
- Cycle detection — simulation stops automatically when a pattern repeats
- Green block rendering — ANSI color output in the terminal
- Configurable — adjust grid size, speed, and density via constants

---

## How It Works

Each generation, every cell follows four simple rules:

| Condition | Result |
|---|---|
| Live cell with 2 or 3 neighbors | Survives |
| Live cell with < 2 neighbors | Dies (underpopulation) |
| Live cell with > 3 neighbors | Dies (overpopulation) |
| Dead cell with exactly 3 neighbors | Born |

The simulation runs until a pattern repeats or the generation limit is reached.

---

## Configuration

At the top of `GameOfLife.java`:

```java
static final int    ROWS              = 30;     // Grid height
static final int    COLS              = 60;     // Grid width
static final int    MAX_GENERATIONS   = 1000;   // Max simulation steps
static final double ALIVE_PROBABILITY = 0.09;   // Starting density
```

---

## Project Structure

```
src/
└── GameOfLife.java     # Simulation loop, rules, rendering, cycle detection
```

---

## Getting Started

**Requirements**
- Java 21 or higher
- A terminal that supports ANSI color codes

**Run the project**
```bash
javac GameOfLife.java
java GameOfLife
```

---

## OOP Concepts Used

- **2D boolean arrays** — grid state per generation
- **ArrayList** — full generation history for cycle detection
- **Modulo wrap-around** — `(index + size) % size` for seamless edges
- **Static methods** — clean separation of map creation, rules, rendering, and detection
- **ANSI colors** — green block rendering in the terminal

---

## Author

Built as a learning project to practice Java fundamentals.
