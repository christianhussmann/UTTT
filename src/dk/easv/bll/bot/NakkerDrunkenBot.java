package dk.easv.bll.bot;

public class NakkerDrunkenBot extends LocalPrioritisedListBot {
        private static final String BOTNAME="NakkerDrunkenBot";

        public NakkerDrunkenBot() {
            int[][] pref = {
                    {0, 2}, {1, 1}, {2, 0}, {1, 2},
                    {0, 1}, {1, 0}, {2, 1}, {0, 0},
                    {2, 2}};
            super.preferredMoves = pref;
        }

        @Override
        public String getBotName() {
            return BOTNAME;
        }



    }

