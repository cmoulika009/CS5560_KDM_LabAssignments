/**
 * Created by Moulika on 6/13/2017.
 */

import edu.stanford.nlp.hcoref.CorefCoreAnnotations;
import edu.stanford.nlp.hcoref.data.CorefChain;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations;
import edu.stanford.nlp.util.CoreMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class QuestionAnsweringSystem {
    public static void main(String args[]) throws IOException {

        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        Set personSet = new HashSet();
        Set locSet = new HashSet();
        Set orgSet = new HashSet();

        String text = readFile("src/main/Data/BBCBlogger.txt");


        Annotation document = new Annotation(text);

        pipeline.annotate(document);

        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);

        for (CoreMap sentence : sentences) {
            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                String nameAndEntity = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);

                if (nameAndEntity.equals("PERSON")) {
                    personSet.add(token);
                }
                if (nameAndEntity.equals("LOCATION")) {
                    locSet.add(token);
                }
                if (nameAndEntity.equals("ORGANIZATION")) {
                    orgSet.add(token);
                }
            }
        }
        System.out.println("\n\n");
        System.out.println("-------Named Entity Recognition----");
        System.out.println("\n\n");
        System.out.println("People");
        System.out.print(personSet);
        System.out.println("\n\n");
        System.out.println("Location");
        System.out.print(locSet);
        System.out.println("\n\n");
        System.out.println("Organization");
        System.out.print(orgSet);
        System.out.println("\n\n");
        System.out.println("Enter question based on above data");
        Scanner sc = new Scanner(System.in);
        String ques = sc.nextLine();
        if(ques.equalsIgnoreCase("Web Blog community is called into support which Bloggers")){
            System.out.println("Iranian bloggers");
        }
        if(ques.equalsIgnoreCase("What is blogsphere")){
            System.out.println("the name for the worldwide community of bloggers");
        }

    }
    public static String readFile(String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }
}

