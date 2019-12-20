public class AnswerData {
    private String id;
    private String question_id;
    private String text;
    private boolean correct;

    public AnswerData(String _id, String _question_id, String _text, boolean _correct){
        id = _id;
        question_id = _question_id;
        text = _text;
        correct = _correct;
    }
    
    public String getId(){return id;}
    public void setId(String _id){id = _id;}
    
    public String getQuizId(){return question_id;}
    public void setQuizId(String _question_id){question_id = _question_id;}
    
    public String getText(){return text;}
    public void setText(String _text){text = _text;}
    
    public boolean getCorrect(){return correct;}
    public void setCorrect(boolean _correct){correct = _correct;}
}
