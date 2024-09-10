public class GameRunner {
    public static void main(String[] args) {
        Field.init();
        Field.printMap();
        while (true) {
            GameLogic.humanTurn();
            Field.printMap();
            if(GameLogic.checkWin(GameLogic.X_FIELD)) {
                System.out.println("Игра завершена. Победил игрок");
                break;
            }
            if(GameLogic.checkDraft()) {
                System.out.println("Игра завершена. Ничья");
                break;
            }
            GameLogic.aiTurn();
            Field.printMap();
            if(GameLogic.checkWin(GameLogic.O_FIELD)) {
                System.out.println("Игра завершена. Победил компьютер");
                break;
            }
            if(GameLogic.checkDraft()) {
                System.out.println("Игра завершена. Ничья");
                break;
            }
        }
    }
}
