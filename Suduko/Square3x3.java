
/**
 * Class Square3x3.
 * This class constructs a 3 by 3 square matrix.
 * @author Dor Elbaz
 * @version 28.11.21
*/
public class Square3x3
{   
    private int[][] square;
    
    /**
     * Constructor for objects of class Square3X3. Constructs and initializes a 2-dimensional 
     * array of the size 3X3, with the values of –1 in each cell. 
     */
     public Square3x3()
    {
        square = new int[3][3];
        
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                square[i][j] = -1;
            }
        }
    }
    
    /*Note, that the user matrix might be uneven, hence why we first construct a default matrix.*/
    /**
     * Constructs a 2-dimensional array of the size 3X3, whose values are taken from the given 
     * array. If the given array’s size is bigger than 3X3, only the first 3X3 cells are taken. If the 
     * given array is smaller, the rest of the cells are initialized to –1.
     * @param array The array to be copied.
     */
     public Square3x3(int[][] array)
    {
        square = new int[3][3];
        int rows;
        
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                 square[i][j] = -1;
            }
        }
      
        if (array.length >= 3)
        {
            rows = 3;
        }
        else 
        {
            rows = array.length;
        }

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (j < array[i].length)
                {
                    square[i][j] = array[i][j];
                }
            }                             
        }          
    }
    
    /** Copy constructor. Constructs a 2-dimensional array of the size 3X3, whose values are 
     * taken from the array of the given Square3x3 object.
     * @param other The Square3x3 object from which to construct the new Square3x3 object.*/
     public Square3x3(Square3x3 other)
    {
        square = new int[3][3];
        
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
               square[i][j] = other.square[i][j];
            }
        }
    }
    
    
    /**
     * Returns the value in the (row, col) cell. If the row and/or col are out of the 
     * array bounds, returns –1. Legal values for row/col are 0,1,2.
     * @param row The row of the desired cell.
     * @param col The column of the desired cell.
     * @return The (row, column) cell's value.
     */
     public int getCell(int row, int col)
    {
         if ((row < 0 || 2 < row) || (col < 0 || 2 < col))
        {
             return -1;
        }
        else
        {
             return square[row][col];
        }
    }
    
    
    /**
     * Sets the cell (row, col) in the array to the given value. If the row and/or col 
     * are out of the array bounds – does nothing. Legal values for row/col are 
     * 0,1,2. 
     * @param row The row of the desired cell.
     * @param col The column of the desired cell.
     * @param value The value to be set.
     */
     public void setXY(int row, int col, int value)
    {
         if (0 <= row && row <= 2 && 0 <= col && col <= 2)
        {
             square[row][col] = value;
        }
        return;
    }
    
    /**
     * Returns a string representation of the matrix.
     * @return A string representing the matrix. 
     * For example: 
     * 4   2   4
     * 8   3   5
     * 7   6   2
     */
     public String toString()
    {
        return square[0][0] + "\t" + square[0][1] + "\t" + square[0][2] + "\n" +
               square[1][0] + "\t" + square[1][1] + "\t" + square[1][2] + "\n" +
               square[2][0] + "\t" + square[2][1] + "\t" + square[2][2] + "\n";
    }
    
    /**
     * Returns true if all the numbers between 1 and 9 are present within a given matrix, false - otherwise.
     * @return true if all numbers are present.
     */
     public boolean allThere()
    {
        boolean present[] = new boolean[10];
        int truths = 0;
        
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (1 <= square[i][j] && square[i][j] <= 9)
                {
                    present[square[i][j]] = true;
                }
            }
        }
        
        for (int i = 0; i < 10; i++)
        {
            if (present[i])
            {
                truths++;
            }
        }
        
        if (truths == 9)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /*For example, the given row contains: {1,2,3}
      It will fill the first, second and third positions within the array with true.*/
    /**
     * Checks what values are within a given row, and fills the boolean array accordingly.
     * @param row The row to be checked.
     * @param values The boolean array to be filled.
     */
     public void whosThereRow(int row, boolean[] values)
    {       
        for (int j = 0; j < 3; j++)
        {          
            if (1 <= square[row][j] && square[row][j] <= 9)
            {
                values[square[row][j]] = true;
            }
        }      
    }
    
    /**
     * Checks what values are within a given column, and fills the boolean array accordingly.
     * @param col The column to be checked.
     * @param values The boolean array to be filled.
     */
     public void whosThereCol(int col, boolean[] values)
    {
        for (int i = 0; i < 3; i++)
        {
            if (1 <= square[i][col] && square[i][col] <= 9)
            {
                values[square[i][col]] = true;
            }
        }
    }
    
}
