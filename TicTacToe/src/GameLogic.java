import java.util.Scanner;

public class GameLogic {
    public static final char X_FIELD = 'X';

    public static final char O_FIELD = 'O';

    static Scanner scanner = new Scanner(System.in);

    public static boolean checkWin(char playerField){
        //   0 1 2
        // 0 * * *
        // 2 * * *
        // 3 * * *

        if(Field.map[0][0] == playerField && Field.map[0][1] == playerField && Field.map [0][2] == playerField) return true;
        if(Field.map[1][0] == playerField && Field.map[1][1] == playerField && Field.map [1][2] == playerField) return true;
        if(Field.map[2][0] == playerField && Field.map[2][1] == playerField && Field.map [2][2] == playerField) return true;

        if(Field.map[0][0] == playerField && Field.map[1][0] == playerField && Field.map [2][0] == playerField) return true;
        if(Field.map[0][1] == playerField && Field.map[1][1] == playerField && Field.map [2][1] == playerField) return true;
        if(Field.map[0][2] == playerField && Field.map[1][2] == playerField && Field.map [2][2] == playerField) return true;

        if(Field.map[0][0] == playerField && Field.map[1][1] == playerField && Field.map [2][2] == playerField) return true;
        if(Field.map[0][2] == playerField && Field.map[1][1] == playerField && Field.map [2][0] == playerField) return true;

        return false;
    }

    public static boolean checkDraft(){
        for(int i = 0; i < Field.MAP_SIZE; i++) {
            for (int j = 0; j < Field.MAP_SIZE;j++) {
                if(Field.map[i][j] == Field.EMPTY_FIELD){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= Field.MAP_SIZE || y >= Field.MAP_SIZE) {
            return false;
        }
        if (Field.map[y][x] != Field.EMPTY_FIELD) {
            return false;
        }
        return true;
    }

    public static void humanTurn() { // ход человека
        int x, y;
        do {
            System.out.println("Ход игрока. Введите координаты вашего хода X Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        Field.map[y][x] = X_FIELD;
    }

    public static void aiTurn() { // ход компьютера
        int x, y;
        System.out.println("Ход компьютера");
        do {
            x = (int)(Math.random() * Field.MAP_SIZE); // генерирует ход компьютера
            y = (int)(Math.random() * Field.MAP_SIZE);
        } while (!isCellValid(x, y));
        Field.map[y][x] = O_FIELD;
    }

}


