
/**
 * Class Sudoku.
 * This class constructs a standard sudoku template.
 * @author Dor Elbaz
 * @version 28.11.21
 */
public class Sudoku
{
    private Square3x3[][] sudoku;

    /**
     * First constructor for objects of class Sudoku.
     * Constructs a new sudoku grid and defaults its values to -1.
     */
     public Sudoku()
    {
        sudoku = new Square3x3[3][3];
        
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                sudoku[i][j] = new Square3x3();
            }
        }  
    }
    
    /**
     * Second constructor for objects of class Sudoku.
     * Constructs a new sudoku grid with the specified Square3x3 matrix.
     * @param square3x3array The matrix that holds the values for the sudoku grid.
     */    
     public Sudoku(Square3x3[][] square3x3array)
    {
        sudoku = new Square3x3[3][3];
        
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                sudoku[i][j] = new Square3x3(square3x3array[i][j]);
            }
        }
    }
    
    /**
     * Returns true if the given template is solved correctly, false - otherwise.
     * @return true if the template is solved correctly.
     */
    public boolean isValid()
    {
        /*Each boolean matrix represents the 9 rows/cols in a sudoku grid and the 9 (between 1 and 9) numbers it should contain in each row/col. 
         *The 0th position in each row is not in use.*/
        boolean validRows[][] = new boolean[9][10];
        boolean validCols[][] = new boolean[9][10];
        int c = 0;
        
        /*This loop goes by 3 square3x3 objects (so 3 rows in the sudoku template).*/
        for (int i = 0; i < 3; i++)
        {
            /*This loop goes by each sudoku row/col individually (3 at a time).*/
            for (int j = 0; j < 3; j++)
            {
                 /*Goes by a single sudoku row.*/
                 examine_Row(i, j, validRows[c]);
                 
                 /*Goes by a single sudoku col.*/
                 examine_Col(i, j, validCols[c]); 
                 
                 /*c is used to mark the respective row/col we examine in the sudoku grid.
                  For example, for c = 0, we'll examine the 0th row of the sudoku grid,
                  that is made up of the 0th rows of the first 3 square3x3 objects.*/
                 c++;
            }
        }
        
        /*Examining the boolean matrices. There should be in each row 9 truths (marking the presence of 1-9) and 1 false (0th position not in use).*/
         if (!examine_Validity(validRows, validCols))
        {
            return false;
        }          
    
        return true;
    }
    
    /**
     * Examines a sudoku row.
     * @param r The row to be examined.
     * @param row_Constant The constant row of the square matrices.
     * @param vr The boolean array to be filled.
     */
     private void examine_Row(int r, int row_Constant, boolean[] vr)
    {
        /*By examining each row of the 3 square3x3 objects, that together compose the sudoku's row, and fills the boolean array accordingly.
          For example r = 0, row_Constant = 0, we'll examine: sudoku[0][0] 0th row, sudoku[0][1] 0th row, sudoku[0][2] 0th row, 
          and the rows compose the 0th row of the sudoku's grid. */
        for (int j = 0; j < 3; j++)
        {
            sudoku[r][j].whosThereRow(row_Constant, vr);
        }
    }
    
    /**
     * Examines a sudoku column.
     * @param c The column to be examined.
     * @param col_Constant The constant column of the square matrices.
     * @param vc The boolean array to be filled.
     */
     private void examine_Col(int c, int col_Constant, boolean[] vc)
    {
        /*By examining each col of the 3 square3x3 objects, that together compose the sudoku's col, and fills the boolean array accordingly.
          For example c = 0, col_Constant = 0, we'll examine: sudoku[0][0] 0th col, sudoku[1][0] 0th col, sudoku[2][0] 0th col,
          and the cols compose the 0th col of the sudoku's grid.*/
        for (int i = 0; i < 3; i++)
        {
            sudoku[i][c].whosThereCol(col_Constant, vc);
        }
    }
    
    /**
     * Examines the validity of the boolean matrices. Returns true if each row in the matrices hold exactly 9 truths, false - otherwise.
     * @param vr The matrix representing the values of the sudoku's rows.
     * @param vc The matrix representing the values of the sudoku's columns.
     * @return true if both matrices rows hold exactly 9 truths.
     */
    private boolean examine_Validity(boolean[][] vr, boolean[][] vc)
    {
        /*We examine each cell in the matrices simultaneously (since they are of the same size). If we detect a single false, we return false and
          the sudoku template is invalid, else we return true and it is valid.*/
        for (int i = 0; i < 9; i++)
        {
            for (int j = 1; j < 10; j++)
            {
                if (!vr[i][j] || !vc[i][j])
                {
                    return false;
                }                
            }
        }
        
        return true;
    }

}
