package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    //  Размеры поля
    private static final int FIELD_WIDTH = 4;

    //  Поле из плиточек
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];

    //  Текущий счёт
    protected int score = 0;

    //  Максимальный вес плитки на игровом поле
    protected int maxTile = 2;

    private Stack<Integer> previousScores = new Stack<>();
    private Stack<Tile[][]> previousStates = new Stack<>();

    private boolean isSaveNeeded =true;

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    //  Заполняем поле пустыми плиточками :)
    public Model() {
        resetGameTiles();
    }

    /**
     * Создаёт поле с пустыми плитками и
     * вызывает метод addTile(), который
     * изменяет значения одной из плиток на
     * 2 или 4.
     */
    protected void resetGameTiles() {
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }

        for (int i = 0; i < 2; i++) {
            addTile();
        }
    }

    /**
     * Меняет значение одной из пустых
     * плиток на 2 или 4, вероятность,
     * что выпадет 2 = 90%, 4 = 10%,
     * т.е соотношение 1:9, на 9 двоек
     * приходится 1 четвёрка
     */
    private void addTile() {
        List<Tile> tiles = getEmptyTiles();
        if (tiles.size() != 0) {
            Tile tile = tiles.get((int) (tiles.size() * Math.random()));
            tile.value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    /**
     * Смотрит, какие плитки пустые,
     * добавляет их в список и возвращает
     * его, для дальнейших операций.
     *
     * @return лист пустых плиток
     */
    private List<Tile> getEmptyTiles() {
        List<Tile> tiles = new ArrayList<Tile>();

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].getValue() == 0) {
                    tiles.add(gameTiles[i][j]);
                }
            }
        }

        return tiles;
    }


    /**
     * Сжатие одного ряда влево
     * @param tiles
     * @return
     */
    private boolean compressTiles(Tile[] tiles) {
        boolean compress = false;

        for (int i = 1; i < tiles.length; i++) {
            for (int j = 1; j < tiles.length; j++) {
                if (tiles[j - 1].isEmpty() && !tiles[j].isEmpty()) {
                    compress = true;
                    tiles[j - 1] = tiles[j];
                    tiles[j] = new Tile();
                }
            }
        }

        return compress;
    }

    /**
     * Сложение клеток
     *
     * @param tiles
     * @return
     */
    private boolean mergeTiles(Tile[] tiles) {
        boolean isChanged = false;
        for (int j = 0; j < 3; j++) {
            if (tiles[j].getValue() != 0 && tiles[j].getValue() == tiles[j + 1].getValue()) {
                tiles[j].setValue(tiles[j].getValue() * 2);
                tiles[j + 1].setValue(0);
                if (tiles[j].getValue() > maxTile) maxTile = tiles[j].getValue();
                score += tiles[j].getValue();
                isChanged = true;

            }
        }

        if (isChanged) {
            Tile temp;
            for (int j = 0; j < 3; j++) {
                if (tiles[j].getValue() == 0 && tiles[j + 1].getValue() != 0) {
                    temp = tiles[j];
                    tiles[j] = tiles[j + 1];
                    tiles[j + 1] = temp;
                }
            }
        }

        return isChanged;
    }


    /**
     *
     */
    protected void left() {
        if (isSaveNeeded) saveState(gameTiles);
        boolean isChanged = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                isChanged = true;
            }
        }
        if (isChanged) {
            addTile();
        }

    }

    public void up() {
        saveState(gameTiles);
        rotate();
        rotate();
        rotate();
        left();
        rotate();
    }

    public void right() {
        saveState(gameTiles);
        rotate();
        rotate();
        left();
        rotate();
        rotate();

    }

    public void down() {
        saveState(gameTiles);
        rotate();
        left();
        rotate();
        rotate();
        rotate();
    }

    /**
     * классический поворот двумерного массива по часовой стрелке
     */
    private void rotate() {
        Tile[][] rotateGameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                rotateGameTiles[j][FIELD_WIDTH - 1 - i] = gameTiles[i][j];
            }
        }
        gameTiles = rotateGameTiles;
    }

    public boolean canMove() {
        if (!getEmptyTiles().isEmpty())
            return true;

        for (Tile[] gameTile : gameTiles) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTile[j].value == gameTile[j - 1].value)
                    return true;
            }
        }

        for (int j = 0; j < gameTiles.length; j++) {
            for (int i = 1; i < gameTiles.length; i++) {
                if (gameTiles[i][j].value == gameTiles[i - 1][j].value)
                    return true;
            }
        }

        return false;
    }

    public void saveState(Tile[][] tiles) {
        Tile[][] newTile = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                newTile[i][j] = new Tile();
            }
        }
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                newTile[i][j].value = tiles[i][j].value;
            }
        }
        previousStates.push(newTile);
        previousScores.push(score);
        this.isSaveNeeded = false;
    }

    public void rollback() {
        if (previousScores.isEmpty() | previousStates.isEmpty()) return;
        score = previousScores.pop();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j].value = previousStates.peek()[i][j].value;
            }
        }
        gameTiles = previousStates.pop();
    }


    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;

        switch (n) {
            case 0:
                left();
                break;
            case 1:
                up();
                break;
            case 2:
                right();
                break;
            case 3:
                down();
                break;
        }
    }

    public boolean hasBoardChanged() {
        int sum1 = 0;
        int sum2 = 0;
        if (!previousStates.isEmpty()) {
            Tile[][] prevGameTiles = previousStates.peek();
            for (int i = 0; i < FIELD_WIDTH; i++) {
                for (int j = 0; j < FIELD_WIDTH; j++) {
                    sum1 += gameTiles[i][j].value;
                    sum2 += prevGameTiles[i][j].value;
                }
            }
        }
        return sum1 != sum2;
    }

    public MoveEfficiency getMoveEfficiency(Move move){
        move.move();
        MoveEfficiency moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        if (!hasBoardChanged())
            moveEfficiency = new MoveEfficiency(-1, 0, move);

        rollback();

        return moveEfficiency;
    }

    public void autoMove(){
        PriorityQueue<MoveEfficiency> moveEfficiencies = new PriorityQueue<>(4, Collections.reverseOrder());

        moveEfficiencies.offer(getMoveEfficiency(this::left));
        moveEfficiencies.offer(getMoveEfficiency(this::up));
        moveEfficiencies.offer(getMoveEfficiency(this::right));
        moveEfficiencies.offer(getMoveEfficiency(this::down));

        moveEfficiencies.peek().getMove().move();
    }
}
