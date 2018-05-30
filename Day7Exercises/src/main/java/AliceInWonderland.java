
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author emmastout
 */
public class AliceInWonderland {

    public static void main(String[] args) {
        String example = "Alice was beginning to get very tired of sitting by her sister on the\n"
                + "bank, and of having nothing to do. Once or twice she had peeped into the\n"
                + "book her sister was reading, but it had no pictures or conversations in\n"
                + "it, \"and what is the use of a book,\" thought Alice, \"without pictures or\n"
                + "conversations?\"\n"
                + "So she was considering in her own mind (as well as she could, for the\n"
                + "day made her feel very sleepy and stupid), whether the pleasure of\n"
                + "making a daisy-chain would be worth the trouble of getting up and\n"
                + "picking the daisies, when suddenly a White Rabbit with pink eyes ran\n"
                + "close by her.\n"
                + "There was nothing so very remarkable in that, nor did Alice think it so\n"
                + "very much out of the way to hear the Rabbit say to itself, \"Oh dear! Oh\n"
                + "dear! I shall be too late!\" But when the Rabbit actually took a watch\n"
                + "out of its waistcoat-pocket and looked at it and then hurried on, Alice\n"
                + "started to her feet, for it flashed across her mind that she had never\n"
                + "before seen a rabbit with either a waistcoat-pocket, or a watch to take\n"
                + "out of it, and, burning with curiosity, she ran across the field after\n"
                + "it and was just in time to see it pop down a large rabbit-hole, under\n"
                + "the hedge. In another moment, down went Alice after it!\n"
                + "[Illustration]\n"
                + "The rabbit-hole went straight on like a tunnel for some way and then\n"
                + "dipped suddenly down, so suddenly that Alice had not a moment to think\n"
                + "about stopping herself before she found herself falling down what seemed\n"
                + "to be a very deep well.\n"
                + "Either the well was very deep, or she fell very slowly, for she had\n"
                + "plenty of time, as she went down, to look about her. First, she tried to\n"
                + "make out what she was coming to, but it was too dark to see anything;\n"
                + "then she looked at the sides of the well and noticed that they were\n"
                + "filled with cupboards and book-shelves; here and there she saw maps and\n"
                + "pictures hung upon pegs. She took down a jar from one of the shelves as\n"
                + "she passed. It was labeled \"ORANGE MARMALADE,\" but, to her great\n"
                + "disappointment, it was empty; she did not like to drop the jar, so\n"
                + "managed to put it into one of the cupboards as she fell past it.";

        String alice = "Alice";
        int numAlices = 0;

        List<String> myList = new ArrayList<>(Arrays.asList(example.split(" ")));

        for (String word : myList) {
            System.out.println(word);
            if (word.equals(alice) || word.equals("Alice,") || word.equals("Alice.") || word.equals("Alice;")) {
                numAlices++;
            }
        }
        
        System.out.println("Alices: " + numAlices);
    }

}
