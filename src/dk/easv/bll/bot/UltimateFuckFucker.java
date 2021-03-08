package dk.easv.bll.bot;

public class UltimateFuckFucker extends LocalPrioritisedListBot {
        private static final String BOTNAME="UltimateFuckFucker";

        public UltimateFuckFucker() {
            int[][] pref = {
                    {0, 2}, {0, 0}, {0, 1}, {2, 0},
                    {1, 0}, {1, 1}, {1, 2}, {2, 1},
                    {2, 2}};
            super.preferredMoves = pref;
        }

        @Override
        public String getBotName() {
            return BOTNAME;
        }



    }

