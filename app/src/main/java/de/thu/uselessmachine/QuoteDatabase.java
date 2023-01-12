package de.thu.uselessmachine;

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

        public static XtremeObject getRandomXtreme() {
            return XTREME[(int) (Math.random() * XTREME.length)];
        }

}
