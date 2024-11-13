package boardgame;

public class Board {
    private int rows;
    private int cols;
    private Piece[][] pieces;

    public Board(int rows, int cols) {
        if (rows < 1 || cols < 1) {
            throw new BoardException("Invalid board length");
        }
        this.rows = rows;
        this.cols = cols;
        pieces = new Piece[rows][cols];
    }

    public int getRows() {
        return rows;
    }


    public int getCols() {
        return cols;
    }


    public Piece piece(int row , int col) {
        if(!positionExists(row,col)){
            throw new BoardException("Invalid position");
        }
        return pieces[row][col];

    }
    public Piece piece(Position pos) {
        if(!positionExists(pos)){
            throw new BoardException("Invalid position");
        }
        return pieces[pos.getRow()][pos.getCol()];
    }

    public void placePiece(Piece piece, Position pos) {
        if(thereIsAPiece(pos)){
            throw new BoardException("There is already a piece in the board " + pos);
        }
        pieces[pos.getRow()][pos.getCol()] = piece;
        piece.position = pos;
    }
    private boolean positionExists(int row, int col) {
       return row >=0 && row < rows && col >=0 && col < cols;
    }

    public boolean positionExists(Position pos) {
        return positionExists(pos.getRow(), pos.getCol());
    }
    public boolean thereIsAPiece(Position pos) {
        if(!positionExists(pos)){
            throw new BoardException("Invalid position");
        }
       return  piece(pos) != null;
    }

}
