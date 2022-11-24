package dataobject;

public class Message {

    public Message(String dataFile, String jsNode) {
        this.jsNode = jsNode;
    }

    public String getJsNode() {
        return jsNode;
    }
    public String dataFile () {
        return dataFile;
    }

    public void setJsNode(String jsNode) {
        this.jsNode = jsNode;
    }
    public void setDataFile(String dataFile) {
        this.dataFile = dataFile;
    }

    String jsNode;
    String dataFile;

}

