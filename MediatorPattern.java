import java.util.ArrayList;
import java.util.List;

interface ChatMediator {
  void sendMessage(String message, User user);
}

class ChatRoom implements ChatMediator {

  private List<User> users = new ArrayList<User>();

  @Override
  public void sendMessage(String message, User user) {
    // TODO Auto-generated method stub
    for (User u : users) {
      if (u != user) {
        u.receiveMessage(message);
      }
    }
  }

  public void addUser(User user) {
    users.add(user);
  }

}

class User {
  private String username;
  private ChatMediator mediator;

  public User(String username, ChatMediator mediator) {
    this.username = username;
    this.mediator = mediator;
  }

  public void sendMessage(String message) {
    mediator.sendMessage(message, this);
  }

  public void receiveMessage(String message) {
    System.out.println(username + ": " + message);
  }
}

public class MediatorPattern {
  public static void main(String[] args) throws Exception {
    ChatRoom chatRoom = new ChatRoom();
    User user1 = new User("user1", chatRoom);
    User user2 = new User("user2", chatRoom);
    User user3 = new User("user3", chatRoom);

    chatRoom.addUser(user1);
    chatRoom.addUser(user2);
    chatRoom.addUser(user3);

    user1.sendMessage("test");
    user2.sendMessage("just me");
  }
}
