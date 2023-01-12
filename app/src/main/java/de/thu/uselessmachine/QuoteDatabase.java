package de.thu.uselessmachine;

import android.content.res.Resources;

public class QuoteDatabase {

        private final static XtremeObject[] XTREME = {
                new XtremeObject("Bing Chilling", "bing_chilling"),
                new XtremeObject("Have you heard of the hit game Amongus?", "amongus"),
                new XtremeObject("Stop calling me", "saul_goodman"),
                new XtremeObject("Jesse, we need to call Saul", "heisenberg"),
                new XtremeObject("It's Morbin Time!", "morbius"),
                new XtremeObject("Look at the tasteful thickness", "patrick_bateman"),
                new XtremeObject("Imagine using Linux lmao", "linux_user"),
                new XtremeObject("Get in the damn robot Shinji", "shinji"),
                new XtremeObject("天恩門廣場大屠殺", "ccp"),
                new XtremeObject("Cope harder", "gigachad")

        };

        public static String getRandomQuoteNormal() {
            int quote = (int) (Math.random() * 29);
            return getResourceString(quote);
        }

        public static XtremeObject getRandomXtreme() {
            return XTREME[(int) (Math.random() * XTREME.length)];
        }

        private static String getResourceString (int rand){
            switch (rand){
                case 1: return Resources.getSystem().getString(R.string.Q1);
                case 2: return Resources.getSystem().getString(R.string.Q2);
                case 3: return Resources.getSystem().getString(R.string.Q3);
                case 4: return Resources.getSystem().getString(R.string.Q4);
                case 5: return Resources.getSystem().getString(R.string.Q5);
                case 6: return Resources.getSystem().getString(R.string.Q6);
                case 7: return Resources.getSystem().getString(R.string.Q7);
                case 8: return Resources.getSystem().getString(R.string.Q8);
                case 9: return Resources.getSystem().getString(R.string.Q9);
                case 10: return Resources.getSystem().getString(R.string.Q10);
                case 11: return Resources.getSystem().getString(R.string.Q11);
                case 12: return Resources.getSystem().getString(R.string.Q12);
                case 13: return Resources.getSystem().getString(R.string.Q13);
                case 14: return Resources.getSystem().getString(R.string.Q14);
                case 15: return Resources.getSystem().getString(R.string.Q15);
                case 16: return Resources.getSystem().getString(R.string.Q16);
                case 17: return Resources.getSystem().getString(R.string.Q17);
                case 18: return Resources.getSystem().getString(R.string.Q18);
                case 19: return Resources.getSystem().getString(R.string.Q19);
                case 20: return Resources.getSystem().getString(R.string.Q20);
                case 21: return Resources.getSystem().getString(R.string.Q21);
                case 22: return Resources.getSystem().getString(R.string.Q22);
                case 23: return Resources.getSystem().getString(R.string.Q23);
                case 24: return Resources.getSystem().getString(R.string.Q24);
                case 25: return Resources.getSystem().getString(R.string.Q25);
                case 26: return Resources.getSystem().getString(R.string.Q26);
                case 27: return Resources.getSystem().getString(R.string.Q27);
                case 28: return Resources.getSystem().getString(R.string.Q28);
                case 29: return Resources.getSystem().getString(R.string.Q29);
                default: return "Error";
            }
        }
}
