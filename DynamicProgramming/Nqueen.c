#include<stdio.h>
#include<stdlib.h>
#define N 8

int isSafe(int board[N][N], int row, int col)
{
    //Check for the left side of current row for any queens
    for(int i=0;i <col;i++)
    {
        if(board[row][i] == 1)
            return 0;
    }

    //Check on the upper diagonal (left side only because no queens on right)
    for(int i=row,j=col; i>=0 && j>=0; i--, j--)
    {
        if(board[i][j]==1)
            return 0;
    }

    //Check for the lower diagonal (Here also left side only)
    for(int i=row,j=col; i<N && j>=0; i++, j--)
    {
        if(board[i][j]==1)
            return 0;
    }

    return 1;
}

int solveNQueen(int board[N][N], int column)
{
    //If all queens are kept then exit
    if(column >= N)
        return 1;
    
    for(int i=0; i<N; i++)
    {
        //Check if the current placement is safe or not?
        if(isSafe(board, i, column))
        {
            //Place the queen
            board[i][column] = 1;

            //Placing all the queens recursively
            if(solveNQueen(board, column+1))
                return 1;
            
            //Else Backtrack by making the position as 0
            board[i][column] = 0;
        }
    }
    return 0;
}

void printBoard(int board[N][N])
{
    for(int i=0;i<N;i++)
    {
        for(int j=0;j<N;j++)
            printf("%d ",board[i][j]);
        printf("\n");
    }
}

int main()
{
    int board[N][N];

    for(int i=0;i<N;i++)
    {
        for(int j=0;j<N;j++)
            board[i][j] = 0;
    }

    if(solveNQueen(board,0)== 0)
        printf("No Solution");

    printBoard(board);
}