package dk.easv.bll.bot;

import dk.easv.bll.field.IField;
import dk.easv.bll.game.IGameState;
import dk.easv.bll.move.IMove;
import dk.easv.bll.move.Move;

import java.util.Random;

public class MathiasBot implements IBot{
    Random rand = new Random();

    int[][] preferredMoves = {
            {rand.nextInt(3), rand.nextInt(3)}, {rand.nextInt(3), rand.nextInt(3)}, {rand.nextInt(3), rand.nextInt(3)}, {rand.nextInt(3), rand.nextInt(3)}, //Corners ordered across
            {rand.nextInt(3), rand.nextInt(3)}, {rand.nextInt(3), rand.nextInt(3)}, {rand.nextInt(3), rand.nextInt(3)}, {rand.nextInt(3), rand.nextInt(3)}, //Outer Middles ordered across
            {rand.nextInt(3), rand.nextInt(3)}};

    private static final String BOTNAME = "MathiasBot";
    @Override
    public IMove doMove(IGameState state) {
        for (int[] move : preferredMoves) {
            if (state.getField().getMacroboard()[move[0]][move[1]].equals(IField.AVAILABLE_FIELD)) {
                for (int[] newMove : preferredMoves) {
                    int x = move[0] * 3 + newMove[0];
                    int y = move[1] * 3 + newMove[1];
                    if (state.getField().getBoard()[x][y].equals(IField.EMPTY_FIELD)) {
                        return new Move(x, y);
                    }
                }
            }
        }
        return state.getField().getAvailableMoves().get(0);
    }

    @Override
    public String getBotName() {
        return BOTNAME;
    }
}
