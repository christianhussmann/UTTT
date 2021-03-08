package dk.easv.bll.bot;

public class NakkerLocalPrio extends LocalPrioritisedListBot {
    private static final String BOTNAME="NakkerLocalPrio";

    public NakkerLocalPrio() {
        int[][] pref = {
                {0, 0}, {0, 1}, {0, 2}, {2, 2},
                {1, 0}, {2, 0}, {1, 2}, {2, 1},
                {1,1}};
        super.preferredMoves = pref;
    }

    @Override
    public String getBotName() {
        return BOTNAME;
    }



}