package es.upm.miw.iwvg_devops.connectFour.utils;

import java.util.Random;

public abstract class SquareBoundedCoordinate {
    private Coordinate adaptee;

    public SquareBoundedCoordinate() {
        this.adaptee = NullCoordinate.getInstance();
    }

    public SquareBoundedCoordinate(int row, int column) {
        this.adaptee = new ConcreteCoordinate(row, column);

        assert this.isValid();
    }

    public boolean isNull() {
        return this.adaptee.isNull();
    }

    private boolean isValid() {
        assert !this.adaptee.isNull();

        ConcreteCoordinate concreteCoordinate = (ConcreteCoordinate) this.adaptee;
        return this.getLimits().isIncluded(concreteCoordinate.getRow())
                && this.getLimits().isIncluded(concreteCoordinate.getColumn());
    }

    protected ClosedInterval getLimits() {
        return new ClosedInterval(0, this.getDimension() - 1);
    }

    protected abstract int getDimension();

    public Direction getDirection(SquareBoundedCoordinate coordinate) {
        if (this.equals(coordinate) || this.isNull() || coordinate.isNull()) {
            return Direction.NULL;
        }
        if (this.inInverseDiagonal() && coordinate.inInverseDiagonal()) {
            return Direction.INVERSE_DIAGONAL;
        }
        return this.adaptee.getDirection(coordinate.adaptee);
    }

    public boolean inInverseDiagonal() {
        ConcreteCoordinate coordinate = (ConcreteCoordinate) this.adaptee;
        return coordinate.getRow() + coordinate.getColumn() == this.getDimension() - 1;
    }


    protected abstract String getErrorMessage();

    public void random() {
        Random random = new Random(System.currentTimeMillis());
        this.adaptee = new ConcreteCoordinate(random.nextInt(this.getDimension()), random.nextInt(this.getDimension()));
    }


    public int getRow() {
        assert !this.adaptee.isNull();

        return ((ConcreteCoordinate) this.adaptee).getRow();
    }

    public int getColumn() {
        assert !this.adaptee.isNull();

        return ((ConcreteCoordinate) this.adaptee).getColumn();
    }

}
