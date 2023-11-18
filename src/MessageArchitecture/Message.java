package MessageArchitecture;

public class Message {
    public Object origin;
    public String topic;
    public String payload;

    public Message(Object origin, String topic, String payload) {
        this.origin = origin;
        this.topic = topic;
        this.payload = payload;
    }

    public String toString() {
        return "origin:" + origin + "\ntopic:" + topic + "\npayload:" + payload;
    }
}

