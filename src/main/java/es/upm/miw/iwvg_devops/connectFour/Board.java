package es.upm.miw.iwvg_devops.connectFour;

import es.upm.miw.iwvg_devops.connectFour.utils.Direction;

import java.util.ArrayList;
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

    boolean isConnectFour(Color color) {
        int TOKENS_TO_WIN = 4;
        List<Direction> directions = this.getDirections(color);
        if (directions.size() < TOKENS_TO_WIN-1) {
            return false;
        }
        for (int i = 0; i < directions.size() - 1; i++) {
            if (directions.get(i) != directions.get(i + 1)) {
                return false;
            }
        }
        return !directions.get(0).isNull();
    }

    private List<Direction> getDirections(Color color) {
        assert !color.isNull();

        List<Direction> directions = new ArrayList<>();
        List<Coordinate> coordinates = this.getCoordinates(color);
        if (!coordinates.isEmpty()) {
            for (int i = 0; i < coordinates.size() - 1; i++) {
                directions.add(coordinates.get(i).getDirection(coordinates.get(i + 1)));
            }
        }
        return directions;
    }

    List<Coordinate> getCoordinates(Color color) {
        assert !color.isNull();

        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = 0; i < Coordinate.ROW_SIZE; i++) {
            for (int j = 0; j < Coordinate.COLUMN_SIZE; j++) {
                if (this.getColor(new Coordinate(i, j)) == color) {
                    coordinates.add(new Coordinate(i, j));
                }
            }
        }
        return coordinates;
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
