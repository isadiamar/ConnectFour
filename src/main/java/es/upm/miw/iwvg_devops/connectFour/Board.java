package es.upm.miw.iwvg_devops.connectFour;

import es.upm.miw.iwvg_devops.connectFour.types.Color;
import es.upm.miw.iwvg_devops.connectFour.types.Error;
import es.upm.miw.iwvg_devops.connectFour.types.Message;
import es.upm.miw.iwvg_devops.connectFour.utils.Direction;

import java.util.List;

public class Board {
    private final Color[][] colors;

    Board() {
        this.colors = new Color[Coordinate.ROW_SIZE][Coordinate.COLUMN_SIZE];
        this.reset();
    }

    void reset() {
        for (int i = 0; i < Coordinate.ROW_SIZE; i++) {
            for (int j = 0; j < Coordinate.COLUMN_SIZE; j++) {
                this.colors[i][j] = Color.NULL;
            }
        }
    }

    void putToken(int column, Color color) {
        assert column >= 0 && column <= Coordinate.COLUMN_SIZE;

        if (!colors[0][column].isNull()) {
            Error.COLUMN_NOT_VALID.writeln();
        }

        for (int i = Coordinate.ROW_SIZE - 1; i >= 0; i--) {
            if (isEmpty(new Coordinate(i, column))) {
                this.colors[i][column] = color;
                break;
            }
        }
    }

    private Color getColor(Coordinate coordinate) {
        assert !coordinate.isNull();

        return this.colors[coordinate.getRow()][coordinate.getColumn()];
    }

    boolean isOccupied(Coordinate coordinate, Color color) {
        return this.getColor(coordinate) == color;
    }

    boolean isEmpty(Coordinate coordinate) {
        return this.isOccupied(coordinate, Color.NULL);
    }

    public boolean isConnectFour(Color color) {

        return checkDirection(color, Direction.VERTICAL) || checkDirection(color, Direction.HORIZONTAL) ||
                checkDirection(color, Direction.MAIN_DIAGONAL) || checkDirection(color, Direction.INVERSE_DIAGONAL);
    }

    public boolean checkDirection(Color color, Direction direction) {
        boolean res = false;

        List<Direction> rowInit = List.of(Direction.MAIN_DIAGONAL);
        List<Direction> row = List.of(Direction.VERTICAL, Direction.INVERSE_DIAGONAL);
        List<Direction> column= List.of(Direction.HORIZONTAL, Direction.MAIN_DIAGONAL, Direction.INVERSE_DIAGONAL);

        for (int i = loopHelper(direction, rowInit); i < (this.colors.length - loopHelper(direction, row)); i++) {
            for (int j = 0; j < this.colors[0].length - loopHelper(direction, column); j++) {
                if (this.colors[i][j] == color &&
                        this.colors[i + direction.getRow()][j + direction.getColumn()] == color &&
                        this.colors[i + 2 * direction.getRow()][j + 2 * direction.getColumn()] == color &&
                        this.colors[i + 3 * direction.getRow()][j + 3 * direction.getColumn()] == color) {
                    res = true;
                    break;
                }
            }
        }
        return res;
    }

    private int loopHelper(Direction currentDirection, List<Direction> expectedDirections) {
        int res = 0;
        if (expectedDirections.contains(currentDirection)) {
            res = 3;
        }
        return res;
    }

    void write() {
        Message.HORIZONTAL_LINE.writeln();
        for (int i = 0; i < Coordinate.ROW_SIZE; i++) {
            Message.VERTICAL_LINE.write();
            for (int j = 0; j < Coordinate.COLUMN_SIZE; j++) {
                this.getColor(new Coordinate(i, j)).write();
                Message.VERTICAL_LINE.write();
            }
            System.out.println();
        }
        Message.HORIZONTAL_LINE.writeln();
    }
}
