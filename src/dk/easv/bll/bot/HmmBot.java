package dk.easv.bll.bot;

import java.util.Random;

public class HmmBot extends LocalPrioritisedListBot {
    private static final String BOTNAME="Hmm Bot";

    public HmmBot() {
        Random rand = new Random();

        int[][] pref = {
                {0, 2}, {0, 0}, {2, 0}, {2, 2},
                {rand.nextInt(3), rand.nextInt(3)},  {rand.nextInt(3), rand.nextInt(3)},  {rand.nextInt(3), rand.nextInt(3)},  {rand.nextInt(3), rand.nextInt(3)},
                {rand.nextInt(3), rand.nextInt(3)}};
        super.preferredMoves = pref;
    }


    @Override
    public String getBotName() {
        return BOTNAME;
    }



}
