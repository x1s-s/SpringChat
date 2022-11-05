package by.unie.dao;

import by.unie.chat.Chat;
import by.unie.chat.Message;
import by.unie.chat.User;
import by.unie.dao.repositories.ChatRepository;
import by.unie.dao.repositories.MessageRepository;
import by.unie.dao.repositories.UserRepository;
import by.unie.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChatDAOIml implements ChatDAO {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Chat getChat(long id) {
        return chatRepository.findById(id).get();
    }

    @Override
    public List<User> getUsers(long id) {
        return chatRepository.findById(id).get().getUsers();
    }

    @Override
    public List<MessageDTO> getMessages(long id) {
        return chatRepository.findById(id).get().getMessages().
                stream().map(MessageDTO::from).collect(Collectors.toList());
    }

    @Override
    public Long addChat(Chat chat) {
        return chatRepository.save(chat).getId();
    }

    @Override
    public void addMessage(String message, long id, String name) {
        chatRepository.findById(id).get().getMessages().add(new Message(userRepository.findByName(name), message, new Date()));
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void addUserToChat(long id, String name) {
        chatRepository.findById(id).get().getUsers().add(userRepository.findByName(name));
    }
}
