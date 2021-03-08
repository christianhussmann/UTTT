package dk.easv.bll.bot;

public class ChristiansBot extends LocalPrioritisedListBot {
        private static final String BOTNAME="Christians Bot";

        public ChristiansBot() {
            int[][] pref = {
                    {1, 1}, {2, 2}, {0, 2}, {2, 0},
                    {0, 1}, {2, 1}, {1, 0}, {1, 2},
                    {1, 1}};
            super.preferredMoves = pref;
        }

        @Override
        public String getBotName() {
            return BOTNAME;
        }



    }

