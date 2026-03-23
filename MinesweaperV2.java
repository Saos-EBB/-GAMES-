import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MinesweaperV2 {

    // Map-Werte als Konstanten
    static final int MINE        = 0;
    static final int SAFE_SMALL  = 1; // 1x1 aufdecken
    static final int SAFE_MED    = 2; // 3x3 aufdecken
    static final int SAFE_LARGE  = 3; // 5x5 aufdecken
    static final int REVEALED    = 4;
    static final int REVEALED_MINE = 5;

    static final char[] ROWS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

    // Farben
    static final String FG_BRIGHT_RED   = "\u001B[91m";
    static final String FG_BRIGHT_GREEN = "\u001B[92m";
    static final String RESET           = "\u001B[0m";

    static final String BOOOM = FG_BRIGHT_RED + """
            U DIED ...
            ███████████████████████████
            ███████▀▀▀░░░░░░░▀▀▀███████
            ████▀░░░░░░░░░░░░░░░░░▀████
            ███│░░░░░░░░░░░░░░░░░░░│███
            ██▌│░░░░░░░░░░░░░░░░░░░│▐██
            ██░└┐░░░░░░░░░░░░░░░░░┌┘░██
            ██░░└┐░░░░░░░░░░░░░░░┌┘░░██
            ██░░┌┘▄▄▄▄▄░░░░░▄▄▄▄▄└┐░░██
            ██▌░│██████▌░░░▐██████│░▐██
            ███░│▐███▀▀░░▄░░▀▀███▌│░███
            ██▀─┘░░░░░░░▐█▌░░░░░░░└─▀██
            ██▄░░░▄▄▄▓░░▀█▀░░▓▄▄▄░░░▄██
            ████▄─┘██▌░░░░░░░▐██└─▄████
            █████░░▐█─┬┬┬┬┬┬┬─█▌░░█████
            ████▌░░░▀┬┼┼┼┼┼┼┼┬▀░░░▐████
            █████▄░░░└┴┴┴┴┴┴┴┘░░░▄█████
            ███████▄░░░░░░░░░░░▄███████
            ██████████▄▄▄▄▄▄▄██████████
            ███████████████████████████
            ...WANNA TRY AGAIN ?
            """ + RESET;


    static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random randy = new Random();

        ArrayList<String> inputs = new ArrayList<>();
        int[][] map = new int[10][10];

        int mines   = fillMap(map, randy);
        int green   = 100 - mines;
        int checked = 0;
        boolean alive = true;

        System.out.println("\n\n\nDu rätst wo keine Mienen sind, wenn du falsch wählst spreng ich dich : )");

        while (alive) {

            printMap(map);

            String userInput = readInput(scan, inputs);

            int x = userInput.charAt(0) - 'A';
            int y = userInput.charAt(1) - '0';

            if (map[x][y] == REVEALED) {
                System.out.println("Schon aufgedeckt!");
                continue;
            }

            // Radius je nach Feldwert
            int radius = switch (map[x][y]) {
                case SAFE_LARGE -> 2;
                case SAFE_MED   -> 1;
                case SAFE_SMALL -> 0;
                case MINE -> {
                    System.out.println(BOOOM);
                    alive = false;
                    yield 0;
                }
                default -> 0;
            };

            if (!alive) break;

            // Felder im Radius aufdecken
            for (int i = -radius; i <= radius; i++) {
                if (x + i < 0 || x + i >= map.length) continue;
                for (int j = -radius; j <= radius; j++) {
                    if (y + j < 0 || y + j >= map.length) continue;

                    int val = map[x + i][y + j];
                    if (val == MINE) {
                        map[x + i][y + j] = REVEALED_MINE;
                        mines--;
                    } else if (val > MINE && val <= SAFE_LARGE) {
                        map[x + i][y + j] = REVEALED;
                        checked++;
                    }
                }
            }

            if (checked == green || mines == 0) {
                System.out.println("U WON!");
                alive = false;
                break;
            }

            float prozent = (float) checked / green * 100;
            System.out.printf("%nDu hast %2d/%2d (%.2f%%) gecheckt. Noch %3d Mienen im Game.%n%n",
                    checked, green, prozent, mines);
        }
    } // mainEnte


    // Eingabe lesen und validieren
    static String readInput(Scanner scan, ArrayList<String> inputs) {
        while (true) {
            String input = scan.next().toUpperCase();
            if (input.matches("[A-J][0-9]") && !inputs.contains(input)) {
                inputs.add(input);
                return input;
            }
            System.out.println("Ungültige Eingabe oder schon versucht – nochmal!");
        }
    }


    // Map befüllen (kein Cheat-Print)
    static int fillMap(int[][] map, Random randy) {
        int mines = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = randy.nextInt(4);
                if (map[i][j] == MINE) mines++;
            }
        }
        return mines;
    }


    // Map anzeigen
    static void printMap(int[][] map) {
        System.out.println("\n   0  1  2  3  4  5  6  7  8  9");
        for (int i = 0; i < map.length; i++) {
            System.out.print(ROWS[i] + " ");
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == REVEALED) {
                    System.out.print(FG_BRIGHT_GREEN + "[X]" + RESET);
                } else if (map[i][j] == REVEALED_MINE) {
                    System.out.print(FG_BRIGHT_RED + "[X]" + RESET);
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println(" " + ROWS[i]);
        }
        System.out.println("   0  1  2  3  4  5  6  7  8  9\n       Wo ist keine Mine?");
    }

} // classEnte
