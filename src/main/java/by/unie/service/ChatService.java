package by.unie.service;

import by.unie.chat.Chat;
import by.unie.chat.Message;
import by.unie.chat.User;
import by.unie.dto.MessageDto;

import java.util.List;

public interface ChatService {
    Chat getChat(int id);
    List<User> getUsers(int id);
    List<MessageDto> getMessages(int id);
    Integer addChat(Chat chat);
    void addMessage(String message,int id, String name);
    void addUser(User user);

    boolean addUserToChat(int id, String name);
}
