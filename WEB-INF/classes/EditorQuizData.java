public class EditorQuizData {
    private String id;
    private String name;
    private String editor;

    public EditorQuizData(String _id, String _name){
        id = _id;
        name = _name;
    }

    public EditorQuizData(String _id, String _name, String _editor){
        id = _id;
        name = _name;
        editor = _editor;
    }

    public String getName(){return name;}
    public void setName(String _name){name = _name;}
    
    public String getId(){return id;}
    public void setId(String _id){id = _id;}

    public String getEditor(){return editor;}
    public void setEditor(String _editor){editor = _editor;}
}
