import com.google.gson.Gson;
import com.google.gson.JsonParser;

import javax.naming.Context;
import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Arrays;
import java.util.Random;


/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class App {

    public static void main(String[] args) {

        System.out.println(getTrumpQuotes());


    }

    public static String getTrumpQuotes(){

        try{
            URL url = new URL("https://api.whatdoestrumpthink.com/api/v1/quotes/random");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");


            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));


            String inputLine = in.readLine();

            while (inputLine != null){

                String text = inputLine.substring(11, inputLine.indexOf("nlp_attributes")-3);
                String[] tags = new String[0];
                Authors quote = new Authors(tags, "Donald Trump", "0", text);
                addToJson(quote);
                return quote.toString();

            }
            in.close();


        }catch(MalformedURLException e){
            System.out.println("FIX YO URL" + e);
        }catch (ProtocolException e){

            System.out.println("SEEMS LIKE SOMETHING DIDN'T COME BECK" + e);
        }catch (IOException e){
            System.out.println("Check your connection? exception: " + e + "\nIn the meantime, here's another quote ");
            int storedRandom = 0;
            storedRandom = randomGenerator();
            Authors[] quotes = getJsonFile();
            System.out.println(quotes[storedRandom].toString() + " Index Number: " + storedRandom);

        }
        return null;
    }


    public static Authors[] getJsonFile(){
        // create a path for our json file
        Path path = Paths.get("assets/recentquotes.json");

        // using BufferedReader to read path/file
        try(BufferedReader reader = Files.newBufferedReader(path)){
            Gson gson = new Gson();
            Authors[] jsonAuthor = gson.fromJson(reader, Authors[].class);

            return jsonAuthor;

        }catch(IOException e){

        }
        return null;
    }

    public static int randomGenerator(){
        Random randomNum = new Random();
        return randomNum.nextInt(10);
    }

    public static String addToJson(Authors quote) {

        Authors[] quotes = getJsonFile();
        for (Authors inputQuote : quotes){
            if (inputQuote.text.contains(quote.text)){
                return null;
            }
        }

        Authors[] newQuote = new Authors[quotes.length + 1];
        for (int i = 0; i < quotes.length + 1; i++) {
            if (i == quotes.length) {
                newQuote[i] = quote;
            } else {
                newQuote[i] = quotes[i];
            }
        }

        Gson gson = new Gson();
        String json = (gson.toJson(newQuote));
        return writeToJson(json);

    }


    public static String writeToJson(String json){
        try (FileWriter file = new FileWriter("./assets/recentquotes.json")){
            file.write(json);

        } catch (IOException e) {
        }

        return null;
    }

}
