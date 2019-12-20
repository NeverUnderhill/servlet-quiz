public class ResultData {
    private String name;
    private String email;
    private String quiz;
    private String points;
    private String max_points;

    public ResultData(String _name, String _email, String _quiz, String _points, String _max_points){
        name = _name;
        email = _email;
        quiz = _quiz;
        points = _points;
        max_points = _max_points;
    }

    public String getName(){return name;}
    public void setName(String _name){name = _name;}
    
    public String getEmail(){return email;}
    public void setEmail(String _email){email = _email;}
    
    public String getQuiz(){return quiz;}
    public void setQuiz(String _quiz){quiz = _quiz;}
    
    public String getPoints(){return points;}
    public void setPoints(String _points){points = _points;}
    
    public String getMaxPoints(){return max_points;}
    public void setMaxPoints(String _max_points){max_points = _max_points;}
    
}
