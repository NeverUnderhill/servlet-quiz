public class QuestionData {
    private String id;
    private String quiz_id;
    private String text;
    private String[] answers;
    private String[] correcc;
    private int time;

    public QuestionData(String _id, String _quiz_id, String _text, int _time){
        id = _id;
        quiz_id = _quiz_id;
        text = _text;
        time = _time;
        answers = new String[8];
        correcc = new String[8];
    }
    
    public String getId(){return id;}
    public void setId(String _id){id = _id;}
    
    public String getQuizId(){return quiz_id;}
    public void setQuizId(String _quiz_id){quiz_id = _quiz_id;}
    
    public String getText(){return text;}
    public void setText(String _text){text = _text;}

    public String getAnswer(int i){return answers[i];}
    public void setAnswer(int i, String _answer){answers[i] = _answer;}

    public String getCorrecc(int i){return correcc[i];}
    public void setCorrecc(int i, String _correcc){correcc[i] = _correcc;}
}
