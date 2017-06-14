
public class TweetWithSentiment {

    private String textFile;
    private String cssClassSentiment;

    public TweetWithSentiment() {
    }

    public TweetWithSentiment(String line, String cssClass) {
        super();
        this.textFile = line;
        this.cssClassSentiment = cssClass;
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