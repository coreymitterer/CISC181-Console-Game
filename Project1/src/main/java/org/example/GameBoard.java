package org.example;

public class GameBoard {
    // properties of GameBoard
    private int numRows; // starts at top with row 0
    private int numColumns; // starts at left side with column 0
    private BoardSquare[][] squares; // two-dimensional array of BoardSquare objects


    // Constructor that sets properties numRows and numColumns
    public GameBoard(int numRows, int numColumns){
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.squares = new BoardSquare[numRows][numColumns];
        setUpEmptyBoard();
    }
    public int getNumRows(){
        return numRows;
    }
    public int getNumColumns(){
        return numColumns;
    }
    public BoardSquare[][] getSquares(){
        return squares;
    }

    public boolean inBounds(int rowIndex, int columnIndex){
        return (numRows > rowIndex) && (numColumns > columnIndex) && (rowIndex >= 0) && (columnIndex >= 0) && (rowIndex < 8) && (columnIndex < 8);
    }
    private void setUpEmptyBoard(){
        for (int i = 0; i < this.squares.length; i++){
            for (int j = 0; j < this.squares[i].length; j++) {
                if (i == 0 || i == this.squares.length - 1 || j == 0 || j == this.squares[i].length - 1) {
                    this.squares[i][j] = new BoardSquare("White");
                }else
                    this.squares[i][j] = new BoardSquare("Black");
            }
        }
    }

    

    public BoardSquare findRandomEmptySpace(){
        int numRows = squares.length;
        int numColumns = squares[0].length;
        while (true) {
            int randomRow = (int) (Math.random() * numRows);
            int randomColumn = (int) (Math.random() * numColumns);
            BoardSquare square = squares[randomRow][randomColumn];
            if (square.isEmpty()) {
                return square;
            }
        }
    }


    public String toString(){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :       ");

        for(int col = 0; col < squares[0].length; col++){
            boardString.append(col + "       ");
        }
        boardString.append("\n");
        for(int row = 0; row < squares.length; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < squares[row].length; col++){
                boardString.append(squares[row][col].toString() + " ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }
}
