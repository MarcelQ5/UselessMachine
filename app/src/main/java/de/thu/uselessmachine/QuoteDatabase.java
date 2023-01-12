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
                new XtremeObject("Cope harder", "gigachad"),
                new XtremeObject("This is getting out of hand. Now there are two of them!", "now_there_are_two_of_them"),
                new XtremeObject("Hello there!", "hello_there"),
                new XtremeObject("General Kenobi!", "general_kenobi"),
                new XtremeObject("Won't you take me to funkytown", "funkytown")
        };

        public static XtremeObject getRandomXtreme() {
            return XTREME[(int) (Math.random() * XTREME.length)];
        }
    }
