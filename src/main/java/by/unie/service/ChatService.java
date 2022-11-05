package by.unie.service;

import by.unie.chat.Chat;
import by.unie.chat.User;
import by.unie.dto.MessageDTO;

import java.util.List;

public interface ChatService {
    Chat getChat(long id);
    List<User> getUsers(long id);
    List<MessageDTO> getMessages(long id);
    Long addChat(Chat chat);
    void addMessage(String message,long id, String name);
    void addUser(User user);

    void addUserToChat(long id, String name);
}
