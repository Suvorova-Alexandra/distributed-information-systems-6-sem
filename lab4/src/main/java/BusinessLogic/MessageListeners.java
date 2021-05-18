package BusinessLogic;

import DataAccess.MessageRepositoryImpl;
import DataAccess.models.MessageRepository;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.*;

@MessageDriven(name = "MessageListenerImpl", activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/ExpiryQueue")
})
public class MessageListeners implements MessageListener {
    private MessageRepository repository=MessageRepositoryImpl.getInstance();

    @Override
    public void onMessage(Message receivedMessage) {
        TextMessage receivedTextMessage;
        try {
            if (receivedMessage instanceof TextMessage) {
                receivedTextMessage = (TextMessage) receivedMessage;
                String[] receivedStringMessage = receivedTextMessage.getText().split("\n");

                ArrayList<String> sortedMessages = new ArrayList<>(Arrays.asList(receivedStringMessage));
                sortedMessages.addAll(repository.getMessages());
                try {
                    List<String> result = sortList(sortedMessages);
                    repository.saveMessages(result);
                } finally {
                    System.out.println("--------------------------------------------------");
                    for (String mess : repository.getMessages())
                        System.out.println("Sorted message from server: " + mess);
                    System.out.println("--------------------------------------------------");
                }
            }
        } catch (Throwable te) {
            te.printStackTrace();
        }
    }

    private List<String> sortList(List<String> unsortedMessages) {
        Collections.sort(unsortedMessages, (o1, o2) -> {
            if (o1.length() > o2.length()) {
                return 1;
            } else {
                if (o1.length() < o2.length()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        return unsortedMessages;
    }
}
