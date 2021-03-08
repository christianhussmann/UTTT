package dk.easv.bll.bot;

public class SchwanzBot extends LocalPrioritisedListBot {
    private static final String BOTNAME="Schwanz bot";

    public SchwanzBot() {
        int[][] pref = {
                {0, 0}, {0, 2}, {2, 0}, {2, 1}, {1, 1}, {2, 2}};
        super.preferredMoves = pref;
    }

    @Override
    public String getBotName() {
        return BOTNAME;
    }



}
