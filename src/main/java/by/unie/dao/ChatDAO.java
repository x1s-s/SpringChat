package by.unie.dao;

import by.unie.chat.Chat;
import by.unie.chat.User;
import by.unie.dto.MessageDto;

import java.util.List;

public interface ChatDAO {
    Chat getChat(long id);
    List<User> getUsers(long id);
    List<MessageDto> getMessages(long id);
    Long addChat(Chat chat);
    void addMessage(String message,long id, String name);
    void addUser(User user);
    void addUserToChat(long id, String name);
}
