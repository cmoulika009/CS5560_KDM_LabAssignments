/**
 * Created by Moulika on 6/13/2017.
 */

public class SentimentfrmTextFile {

    private String textFile;
    private String cssClassSentiment;

    public SentimentfrmTextFile() {
    }

    public SentimentfrmTextFile(String textFile, String cssClassSentiment) {
        super();
        this.textFile = textFile;
        this.cssClassSentiment = cssClassSentiment;
    }

    public String getLine() {
        return textFile;
    }

    public String getCssClass() {
        return cssClassSentiment;
    }

    @Override
    public String toString() {

        return "Sentiment of File \n [Text File Content \n" + textFile + ",\n Sentiment Analyzed for text File=" + cssClassSentiment + "]";
    }
}