package by.unie.service;

import by.unie.chat.Chat;
import by.unie.chat.Message;
import by.unie.chat.User;
import by.unie.dto.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatServiceImp implements ChatService {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Chat getChat(int id) {
        return entityManager.find(Chat.class, id);
    }

    @Override
    public List<User> getUsers(int id) {
        return entityManager.find(Chat.class, id).getUser();
    }

    @Override
    public List<MessageDto> getMessages(int id) {
        return entityManager.find(Chat.class, id).getMessage().stream().map(MessageDto::from).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void addChat(Chat chat) {
        entityManager.persist(chat);
    }

    @Transactional
    @Override
    public void addMessage(String text, int id, String name) {
        User user = (User) entityManager.createNativeQuery("select * from users where users.name = :name", User.class).setParameter("name",name).getSingleResult();
        Message message = new Message(user, text, new Date());
        Chat chat = entityManager.find(Chat.class, id);
        chat.getMessage().add(message);
        entityManager.persist(message);
        entityManager.merge(chat);
    }

    @Transactional
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public boolean addUserToChat(int id, String name) {
        User user = (User) entityManager.createNativeQuery("select * from users where users.name = :name", User.class).setParameter("name",name).getSingleResult();
        System.out.println(user);
        if (user != null) {
            Chat chat = entityManager.find(Chat.class, id);
            chat.getUser().add(user);
            entityManager.merge(chat);
            return true;
        } else {
            return false;
        }
    }
}

