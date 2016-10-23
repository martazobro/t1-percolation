import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[] openedCells;
    private int amountOfRows;
    private final WeightedQuickUnionUF weightedQuickUnionUF;


    public Percolation(int n) {
        // create n-by-n grid, with all sites blocked
        if (n < 1) {
            throw new IllegalArgumentException("Cannot be less then 1");
        }
        weightedQuickUnionUF = new WeightedQuickUnionUF(n);

        amountOfRows = n;
        int numberOfCells = n * n + 2;

        openedCells = new boolean[numberOfCells];
        openedCells[0] = true;

    }

    private void checkIndex(int index) {
        if (index < 1 || index > amountOfRows) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

    }

    public void open(int row, int col) {
        // open site (row, col) if it is not open already
        checkIndex(row);
        checkIndex(col);
        int newOpenedCell = getCellIndex(row, col);
        openedCells[newOpenedCell] = true;
        if (row == 1){
            weightedQuickUnionUF.union(newOpenedCell, 0);
        }
        if (row > 1 && isOpen(row - 1, col)) {
            weightedQuickUnionUF.union(newOpenedCell, getCellIndex(row - 1, col));
        }
        if (row < amountOfRows && isOpen(row + 1, col)) {
            weightedQuickUnionUF.union(newOpenedCell, getCellIndex(row + 1, col));
        }
        if (col > 1 && isOpen(row, col - 1)) {
            weightedQuickUnionUF.union(newOpenedCell, getCellIndex(row, col - 1));
        }
        if (col < amountOfRows && isOpen(row, col + 1)) {
            weightedQuickUnionUF.union(newOpenedCell, getCellIndex(row, col + 1));
        }
    }

    public boolean isOpen(int row, int col) {
        // is site (row, col) open?
        checkIndex(row);
        checkIndex(col);

        return openedCells[getCellIndex(row, col)];
    }

    public boolean isFull(int row, int col) {
        // is site (row, col) full?
        checkIndex(row);
        checkIndex(col);
        int cellIndex = getCellIndex(row, col);
        return weightedQuickUnionUF.connected(0, cellIndex);
    }

    private int getCellIndex(int row, int col) {
        return (row - 1) * amountOfRows + col;
    }

    public boolean percolates() {
        // does the system percolate?
        for (int col = 1; col <= amountOfRows; col++) {
            if (isFull(amountOfRows, col)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
