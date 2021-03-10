package dk.easv.bll.bot;

import dk.easv.bll.field.IField;
import dk.easv.bll.game.IGameState;
import dk.easv.bll.move.IMove;
import dk.easv.bll.move.Move;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UltimateHmmBot3000 extends LocalPrioritisedListBot {
    private static final String BOTNAME = "Ultimate Hmm Bot 3000";

    public UltimateHmmBot3000() {
        Random rand = new Random();

        int[][] pref = {
                {0, 2}, {0, 0}, {2, 2}, {2, 0},
                {rand.nextInt(3), rand.nextInt(3)}, {rand.nextInt(3), rand.nextInt(3)}, {rand.nextInt(3), rand.nextInt(3)}, {rand.nextInt(3), rand.nextInt(3)},
                {rand.nextInt(3), rand.nextInt(3)}};
        super.preferredMoves = pref;
    }


    @Override
    public IMove doMove(IGameState state) {
        List<IMove> winMoves = getWinnerMoves(state);
        if(!winMoves.isEmpty())
            return winMoves.get(0);

        //Find a macroboard to play in bro
        for (int[] move : preferredMoves) {
            if (state.getField().getMacroboard()[move[0]][move[1]].equals(IField.AVAILABLE_FIELD))
            {
                List<IMove> winningMoves = getWinnerMoves(state);
                if(!winMoves.isEmpty())
                    return winMoves.get(0);

                //find move to play
                for (int[] selectedMove : preferredMoves) {
                    int x = move[0] * 3 + selectedMove[0];
                    int y = move[1] * 3 + selectedMove[1];
                    if (state.getField().getBoard()[x][y].equals(IField.EMPTY_FIELD))
                    {
                        return new Move(x, y);
                    }
                }
            }
        }

        return state.getField().getAvailableMoves().get(0);
    }

    private boolean isWinningMove(IGameState state, IMove move, String player) {
        String[][] board = state.getField().getBoard();
        boolean isRowWin = true;
        //Checks the row for you bro
        int startX = move.getX()-(move.getX()%3);
        int endX = startX + 2;
        for (int x = startX; x <= endX; x++) {
            if (x != move.getX())
                if (!board[x][move.getY()].equals(player))
                    isRowWin = false;
        }
        boolean isColumnWin=true;
        //Checks the Columns for you bro
        int startY = move.getY()-(move.getY()%3);
        int endY = startY + 2;
        for(int y = startY; y <= endY; y++){
            if (y!=move.getY())
                if (!board[move.getX()][y].equals(player))
                    isColumnWin = false;
        }

        boolean isDiagWin = true;

        //Diagonal checking left-top to right-bottom
        if(!(move.getX()==startX && move.getY()==startY))
            if(!board[startX][startY].equals(player))
                isDiagWin=false;
        if(!(move.getX()==startX+1 && move.getY()==startY+1))
            if(!board[startX+1][startY+1].equals(player))
                isDiagWin=false;
        if(!(move.getX()==startX+2 && move.getY()==startY+2))
            if(!board[startX+2][startY+2].equals(player))
                isDiagWin=false;

        boolean isOppositeDiagWin = true;
        //Diagonal checking left-bottom to right-top
        if(!(move.getX()==startX && move.getY()==startY+2))
            if(!board[startX][startY+2].equals(player))
                isOppositeDiagWin=false;
        if(!(move.getX()==startX+1 && move.getY()==startY+1))
            if(!board[startX+1][startY].equals(player))
                isOppositeDiagWin=false;
        if(!(move.getX()==startX+2 && move.getY()==startY))
            if(!board[startX+2][startY].equals(player))
                isOppositeDiagWin=false;

            return isColumnWin || isDiagWin || isOppositeDiagWin || isRowWin;
    }





    //Compile a list of all available winning moves
    private List<IMove> getWinnerMoves(IGameState state) {
        String player = "1";
        if (state.getMoveNumber() % 2 == 0)
            player = "0";

        List<IMove> available = state.getField().getAvailableMoves();

        List<IMove> winningMoves = new ArrayList<>();
        for (IMove move : available) {
            if (isWinningMove(state, move, player))
                winningMoves.add(move);
        }
        return winningMoves;
    }




    @Override
    public String getBotName() {
        return BOTNAME;
    }
}