public class Move {
    private int moveQuantity;
    private int moveFrom;
    private int moveTo;

    public Move(int moveQuantity, int moveFrom, int moveTo) {
        this.moveQuantity = moveQuantity;
        this.moveFrom = moveFrom;
        this.moveTo = moveTo;
    }

    public int getMoveQuantity() {
        return moveQuantity;
    }

    public void setMoveQuantity(int moveQuantity) {
        this.moveQuantity = moveQuantity;
    }

    public int getMoveFrom() {
        return moveFrom;
    }

    public void setMoveFrom(int moveFrom) {
        this.moveFrom = moveFrom;
    }

    public int getMoveTo() {
        return moveTo;
    }

    public void setMoveTo(int moveTo) {
        this.moveTo = moveTo;
    }
}
