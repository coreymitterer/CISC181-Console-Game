package org.example;
public class BoardSquare {
    // properties of BoardSquare
    private boolean isEmpty; // Whether the board square is taken
    private Unit unit; // Represents the unit located on the square
    private String squareColor; // represents the color of the square
    private boolean isSpecialSquare; // represents whether a specific square is the special square

    // Constructor that sets the square color
    public BoardSquare(String squareColor) {
        this.squareColor = squareColor;
        this.isEmpty = true;
        this.unit = null;
        this.isSpecialSquare = false;
    }

    // Getters
    public boolean isEmpty() {
        return isEmpty;
    }

    public Unit getUnit() {
        return unit;
    }

    public String getSquareColor() {
        return squareColor;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
        this.isEmpty = false;
    }

    // Setters
    public void setSpecialSquare(boolean isSpecialSquare){
        this.isSpecialSquare = isSpecialSquare;
    }

    /**
     * This method updates the Unit to null, removing the Unit from the square
     * 
     * @return Unit: the Unit that is on this square
     */
    public Unit removeUnit() {
        Unit removedUnit = this.unit;
        this.unit = null;
        this.isEmpty = true;
        return removedUnit;
    }

    public String toString() {
        if (isEmpty()) {
            if(this.isSpecialSquare){
                return "---X---";
            }else {
                return "-------";
            }
        } else {
            return "-" + unit.toString() + "-";
        }
    }
}
