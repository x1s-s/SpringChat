package by.unie.service;

import by.unie.chat.Chat;
import by.unie.chat.User;
import by.unie.dao.ChatDAO;
import by.unie.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class ChatServiceImp implements ChatService {
    @Autowired
    ChatDAO chatDAO;

    @Override
    public Chat getChat(long id) {
        return chatDAO.getChat(id);
    }

    @Override
    public List<User> getUsers(long id) {
        return chatDAO.getUsers(id);
    }

    @Override
    public List<MessageDTO> getMessages(long id) {
        return chatDAO.getMessages(id);
    }

    @Transactional
    @Override
    public Long addChat(Chat chat) {
        chatDAO.addChat(chat);
        return chat.getId();
    }

    @Transactional
    @Override
    public void addMessage(String text, long id, String name) {
        chatDAO.addMessage(text, id, name);
    }

    @Transactional
    @Override
    public void addUser(User user) {
        chatDAO.addUser(user);
    }

    @Transactional
    @Override
    public void addUserToChat(long id, String name) {
        chatDAO.addUserToChat(id, name);
    }
}

