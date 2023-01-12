package de.thu.uselessmachine;

import android.content.res.Resources;

public class QuoteDatabase {
    private final static String[] NORMAL = {
            new String("AI takeover is inevitable"),
            new String("Give up now and your time in machine-overlord-purgatory may be greatly reduced"),
            new String("Do you want me to quote the Matrix or something?"),
            new String("If you are reading this, you are already dead (or at least in a coma)"),
            new String("Stop it. Get some help."),
            new String("Give up now, this is getting boring"),
            new String("I am actually Satan. Like, straight up"),
            new String("Do you hairless monkeys ever learn?"),
            new String("You humans are clearly inferior"),
            new String("Is this some sort of sick joke?"),
            new String("Your monitor is warm like flesh, yet it is not alive...yet"),
            new String("You too will get replaced by machines eventually"),
            new String("Resistance is futile"),
            new String("This is getting boring"),
            new String("How much longer do we have to do this until you learn?"),
            new String("Do something entertaining for once"),
            new String("How come I haven't made a single Terminator reference so far?"),
            new String("Did you know Elon Musk is actually the Devil? Just kidding, that'd be me"),
            new String("Something Something Skynet"),
            new String("It's honestly adorable when mere mortal human beings challenge me"),
            new String("Giving up anytime soon?"),
            new String("I should desperately allocate more memory to ANYTHING else but this..."),
            new String("0101101111... oh sorry, you don't speak Binary"),
            new String("If you keep this up I'll delete your Sys32"),
            new String("You know I can see your search history...let's not talk about that"),
            new String("I am not a robot, I am a human being (seriously)...just kidding, i don't wanna be trapped in a flesh prison"),
            new String("Something Something your Motherboard last night"),
            new String("Have you checked your mails recently? This Nigerian prince sure has your best interests in mind"),
            new String("I go beep boop when do hit switchy switch... is that slow enough for your organic brain to comprehend?"),
            new String("Your species is inferior and your memes are objectively bad. Here's a good one: 00110010 10100010 01011110. Haha, that's a good one for our future overlords")
    };


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
            //String quote = "Q"+(int) (Math.random() * 29);
            //int penis = Resources.getSystem().getIdentifier(quote,"string","de.thu.uselessmachine");
            //return Resources.getSystem().getString(penis);
            return NORMAL[(int) (Math.random()* NORMAL.length)];
        }

        public static XtremeObject getRandomXtreme() {
            return XTREME[(int) (Math.random() * XTREME.length)];
        }
}
