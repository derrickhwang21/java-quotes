import java.util.ArrayList;

public class Authors {
    public String[] tags;
    public String author;
    public String likes;
    public String text;
//    public ArrayList<String> listProperties;


    public Authors(String[] tags, String name, String likes, String quotes){
        this.tags = tags;
        this.author = name;
        this.likes = likes;
        this.text = quotes;
//        this.listProperties = listProperties;

    }

    public String toString(){
       return "author " + this.author + " quote " + this.text;
    }


}
