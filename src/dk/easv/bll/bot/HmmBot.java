package dk.easv.bll.bot;

public class HmmBot extends LocalPrioritisedListBot {
    private static final String BOTNAME="Hmm Bot";

    public HmmBot() {
        int[][] pref = {
                {1, 2}, {0, 0}, {2, 0}, {2, 2},
                {1, 1}, {0, 1}, {1, 2}, {1, 0},
                {2, 1}};
        super.preferredMoves = pref;
    }

    @Override
    public String getBotName() {
        return BOTNAME;
    }



}
