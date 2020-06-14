#include<stdio.h>
#include<stdlib.h>
#include<malloc.h>
#define N 8

int isSafe(int x, int y, int sol[N][N])
{
    return (x>=0 && y>=0 && x<N && y<N && sol[x][y]==-1);
}

void displayTourOfKnight(int sol[N][N])
{
    for(int i=0;i<N;i++)
    {
        for(int j=0;j<N;j++)
            printf("%d ",sol[i][j]);
        printf("\n");
    }
}

int solveKnightTour(int x, int y, int move, int dx[N], int dy[N], int sol[N][N])
{
    int i, nextXmove, nextYmove;
    if(move == N*N)
        return 1;
    else
    {
        for(i=0;i<N;i++)
        {
            nextXmove = x + dx[i];
            nextYmove = y + dy[i];

            if(isSafe(nextXmove, nextYmove, sol))
            {
                sol[nextXmove][nextYmove] = move;
                //Now recursivelly call other moves
                if(solveKnightTour(nextXmove, nextYmove, move+1, dx, dy, sol)==1)
                    return 1;
                else
                    //We need to do backtrack make the current solution vector as -1
                    sol[nextXmove][nextYmove] = -1;

            }
        }
    }
    return 0;
}

void findTheTour()
{
    int sol[N][N];
    //Fill the solution array with -1
    for(int i=0;i<N;i++)
    {
        for(int j=0;j<N;j++)
            sol[i][j] = -1;
    }
    
    //Intitialize the x and y moves in two vectors
    int dx[8] = {2,1,-1,-2,-2,-1,1,2};
    int dy[8] = {1,2,2,1,-1,-2,-2,-1};
    
    //Start with (0,0) so in solution insert as 0th move
    sol[0][0] = 0;

    //Check whether the tour is possible or not
    if(solveKnightTour(0,0,1,dx,dy,sol)==0)
        printf("Not possible to cover all cells.\n");
    else
        displayTourOfKnight(sol);
}

int main()
{
    findTheTour();
}
