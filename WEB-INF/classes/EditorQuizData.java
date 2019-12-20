public class EditorQuizData {
    private String id;
    private String name;

    public EditorQuizData(String _id, String _name){
        id = _id;
        name = _name;
    }

    public String getName(){return name;}
    public void setName(String _name){name = _name;}
    
    public String getId(){return id;}
    public void setId(String _id){id = _id;}
}
