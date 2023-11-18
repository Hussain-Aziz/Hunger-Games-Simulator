package MessageArchitecture;

public interface Subject {
	void registerObserver(Observer o);
	void removeObsever(Observer o);
	void publishMessage(Message m);
}
