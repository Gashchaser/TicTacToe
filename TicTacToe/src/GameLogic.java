import java.util.Scanner;

public class GameLogic {
    public final char X_FIELD = 'X';

    public final char O_FIELD = 'O';
    Scanner scanner = new Scanner(System.in);
    Field MAP_SIZE = new Field();
    Field EMPTY_FIELD = new Field();
    Field Init = new Field();
    Field printMap = new Field();

    private boolean checkWin(char playerField) {


        //   0 1 2
        // 0 * * *
        // 2 * * *
        // 3 * * *

        if (Field.map[0][0] == playerField && Field.map[0][1] == playerField && Field.map[0][2] == playerField)
            return true;
        if (Field.map[1][0] == playerField && Field.map[1][1] == playerField && Field.map[1][2] == playerField)
            return true;
        if (Field.map[2][0] == playerField && Field.map[2][1] == playerField && Field.map[2][2] == playerField)
            return true;

        if (Field.map[0][0] == playerField && Field.map[1][0] == playerField && Field.map[2][0] == playerField)
            return true;
        if (Field.map[0][1] == playerField && Field.map[1][1] == playerField && Field.map[2][1] == playerField)
            return true;
        if (Field.map[0][2] == playerField && Field.map[1][2] == playerField && Field.map[2][2] == playerField)
            return true;

        if (Field.map[0][0] == playerField && Field.map[1][1] == playerField && Field.map[2][2] == playerField)
            return true;
        if (Field.map[0][2] == playerField && Field.map[1][1] == playerField && Field.map[2][0] == playerField)
            return true;

        return false;
    }

    private boolean checkDraft() {
        for (int i = 0; i < MAP_SIZE.MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE.MAP_SIZE; j++) {
                if (Field.map[i][j] == EMPTY_FIELD.EMPTY_FIELD) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= MAP_SIZE.MAP_SIZE || y >= MAP_SIZE.MAP_SIZE) {
            return true;
        }
        if (Field.map[y][x] != EMPTY_FIELD.EMPTY_FIELD) {
            return true;
        }
        return false;
    }

    private void humanTurn() {
        int x, y;
        do {
            System.out.println("Ход игрока. Введите координаты вашего хода X Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (isCellValid(x, y));
        Field.map[y][x] = X_FIELD;
    }

    private void aiTurn() {
        int x, y;
        System.out.println("Ход компьютера");
        do {
            x = (int) (Math.random() * MAP_SIZE.MAP_SIZE); // генерирует ход компьютера
            y = (int) (Math.random() * MAP_SIZE.MAP_SIZE);
        } while (isCellValid(x, y));
        Field.map[y][x] = O_FIELD;
    }

    public void Start() {
        Init.Init();
        printMap.printMap();

        while (true) {
                humanTurn();
                printMap.printMap();
                if (checkWin(X_FIELD)) {
                    System.out.println("Игра завершена. Победил игрок");
                    break;
                }
                if (checkDraft()) {
                    System.out.println("Игра завершена. Ничья");
                    break;
                }
                aiTurn();
                printMap.printMap();
                if (checkWin(O_FIELD)) {
                    System.out.println("Игра завершена. Победил компьютер");
                    break;
                }
                if (checkDraft()) {
                    System.out.println("Игра завершена. Ничья");
                    break;
                }
            }
        }
    }


