package program;

public class Question {
    public String title;
    public String text;
    public String answer;
    public String asker;
    public String askDate;
    public String feedback;
    public String category;

    @Override
    public String toString() {
        return  "\"" + title + "\"," +
                "\"" +  text + "\"," +
                "\"" +  answer + "\"," +
                "\"" +  asker + "\"," +
                "\"" +  askDate + "\"," +
                "\"" +  feedback + "\"," +
                "\"" +  category + "\",";
    }
}
