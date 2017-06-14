/**
 * Created by Moulika
 */
object MainClass {

  def main(args: Array[String]) {
    val sentimentAnalyzer: SentimentAnalyzer = new SentimentAnalyzer
    val File = scala.io.Source.fromFile("src\\main\\Data\\BBCBlogger.txt").mkString
    val SentimentfrmTextFile: SentimentfrmTextFile = sentimentAnalyzer.findSentiment(File)
    System.out.println(SentimentfrmTextFile)
  }
}
