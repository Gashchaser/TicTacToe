import java.util.Scanner;

public class GameLogic {
    public final char X_FIELD = 'X';

    public final char O_FIELD = 'O';
    Scanner scanner = new Scanner(System.in);
    Field Field = new Field();

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
        for (int i = 0; i < Field.MAP_SIZE; i++) {
            for (int j = 0; j < Field.MAP_SIZE; j++) {
                if (Field.map[i][j] == Field.EMPTY_FIELD) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= Field.MAP_SIZE || y >= Field.MAP_SIZE) {
            return true;
        }
        if (Field.map[y][x] != Field.EMPTY_FIELD) {
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
            x = (int) (Math.random() * Field.MAP_SIZE); // генерирует ход компьютера
            y = (int) (Math.random() * Field.MAP_SIZE);
        } while (isCellValid(x, y));
        Field.map[y][x] = O_FIELD;
    }

    public void Start() {
        Field.Init();
        Field.printMap();
        while (true) {
                humanTurn();
                Field.printMap();
                if (checkWin(X_FIELD)) {
                    System.out.println("Игра завершена. Победил игрок");
                    break;
                }
                if (checkDraft()) {
                    System.out.println("Игра завершена. Ничья");
                    break;
                }
                aiTurn();
                Field.printMap();
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
