public class EditorData {
    private String id;
    private String password;

    public EditorData(String _id, String _password){
        id = _id;
        password = _password;
    }

    public String getName(){return password;}
    public void setName(String _password){password = _password;}
    
    public String getId(){return id;}
    public void setId(String _id){id = _id;}
}
