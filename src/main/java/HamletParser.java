import java.io.File;
import java.io.IOException;
import java.io.StringBufferInputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public void changeHammletToLeon() {
        Pattern pattern = Pattern.compile("Hamlet");
        Matcher matcher = pattern.matcher(hamletData);
        StringBuffer sb = new StringBuffer();
        String replacementText = "Leon";

        while (matcher.find()){
            matcher.appendReplacement(sb, replacementText);
        }
        hamletData = matcher.appendTail(sb).toString();

        pattern = Pattern.compile("HAMLET");
        matcher = pattern.matcher(hamletData);
        sb = new StringBuffer();
        String replacement2 = "LEON";
        while(matcher.find()) {
            matcher.appendReplacement(sb, replacement2);
        }
        hamletData = matcher.appendTail(sb).toString();

    }

    public void changeHoratioToTariq() {
        Pattern pattern = Pattern.compile("Horatio");
        Matcher matcher = pattern.matcher(hamletData);
        StringBuffer sb = new StringBuffer();
        String replacementText = "Tariq";

        while (matcher.find()){
            matcher.appendReplacement(sb, replacementText);
        }
        hamletData = matcher.appendTail(sb).toString();

        pattern = Pattern.compile("HORATIO");
        matcher = pattern.matcher(hamletData);
        sb = new StringBuffer();
        String replacement2 = "TARIQ";
        while(matcher.find()) {
            matcher.appendReplacement(sb, replacement2);
        }
        hamletData = matcher.appendTail(sb).toString();
    }


    public int findHamlet() {
        Pattern pattern = Pattern.compile("Hamlet", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletData);
        return (int) matcher.results().count();
    }
}
