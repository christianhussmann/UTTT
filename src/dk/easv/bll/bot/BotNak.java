package dk.easv.bll.bot;
import com.sun.source.tree.Tree;
import dk.easv.bll.game.IGameState;

import java.util.List;
import java.util.Random;


public class BotNak extends LocalPrioritisedListBot {
        private static final String BOTNAME = "BotNak";

        public BotNak() {
            Random rand = new Random();

            int[][] pref = {
                    {0, 2}, {0, 0}, {2, 2}, {2, 0},
                    {rand.nextInt(3), rand.nextInt(3)}, {rand.nextInt(3), rand.nextInt(3)}, {rand.nextInt(3), rand.nextInt(3)}, {rand.nextInt(3), rand.nextInt(3)},
                    {rand.nextInt(3), rand.nextInt(3)}};
            super.preferredMoves = pref;
        }

    private boolean isWinOnMicroboard(IGameState state, int startingX, int startingY)
    {
        String[][] board = state.getField().getBoard();
        return isWinOnBoard(board, startingX, startingY);
    }
    private boolean isWin(IGameState state)
    {
        String[][] macroboard = state.getField().getMacroboard();
        return isWinOnBoard(macroboard, 0, 0);
    }

    private boolean isWinOnBoard(String[][] board, int startingX, int startingY)
    {
        for(int x = startingX; x < startingX+3; x++)
        {
            if(isHorizontalWin(board, x, startingY))
            {
                return true;
            }
            for(int y = startingY; y < startingY+3; y++)
            {

                if(isVerticalWin(board, startingX, y))
                {
                    return true;
                }
            }
        }
        return isDiagonalWin(board, startingX, startingY);
    }

    private boolean isHorizontalWin(String[][] board, int startingX, int startingY)
    {
        return ((board[startingX][startingY].equals("0") || board[startingX][startingY].equals("1"))
                && board[startingX][startingY].equals(board[startingX][startingY+1])
                && board[startingX][startingY+1].equals(board[startingX][startingY+2]));
    }

    private boolean isVerticalWin(String[][] board, int startingX, int startingY)
    {
        return ((board[startingX][startingY].equals("0") || board[startingX][startingY].equals("1"))
                && board[startingX][startingY].equals(board[startingX+1][startingY])
                && board[startingX+1][startingY].equals(board[startingX+2][startingY]));
    }

    private boolean isDiagonalWin(String[][] board, int startingX, int startingY)
    {
        if((board[startingX][startingY].equals("0") || board[startingX][startingY].equals("1"))
                && board[startingX][startingY].equals(board[startingX+1][startingY+1])
                && board[startingX+1][startingY+1].equals(board[startingX+2][startingY+2]))
        {
            return true;
        }
        else if((board[startingX][startingY+2].equals("0") || board[startingX][startingY+2].equals("1"))
                && board[startingX][startingY+2].equals(board[startingX+1][startingY+1])
                && board[startingX+1][startingY+1].equals(board[startingX+2][startingY]))
        {
            return true;
        }
        return false;
    }

        @Override
        public String getBotName() {
            return BOTNAME;
        }


    }
