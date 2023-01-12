package de.thu.uselessmachine;

public class XtremeObject {
    private final String quote;
    private final String imageName;

    public XtremeObject(String quote, String imagename) {
        this.quote = quote;
        this.imageName = imagename;
    }

    public String getQuote() {
        return quote;
    }

    public String getImageName() {
        return imageName;
    }
}
