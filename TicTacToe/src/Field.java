public class Field {

  public static char [][] map;

    public char EMPTY_FIELD = '*';

    public final int MAP_SIZE = 3;



    public void printMap(){
        // 0 1 2 3
        // 1 * * *
        // 2 * * *
        // 3 * * *
        for(int i = 0; i <= MAP_SIZE; i++){
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i=0; i < MAP_SIZE; i++){
            System.out.print((i+1) + " ");
            for(int j = 0; j<MAP_SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void Init() {
        map = new char[MAP_SIZE][MAP_SIZE];
        for(int i = 0; i < MAP_SIZE; i++){
            for(int j = 0; j < MAP_SIZE; j++){
                map[i][j] = EMPTY_FIELD;
            }
        }

    }
}

