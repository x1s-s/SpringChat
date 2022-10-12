package by.unie.chat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    @ManyToMany
    @JoinColumn(name = "chat_id")
    private List<User> user;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "chat_id")
    private List<Message> message;

    public Chat(){
        this.user = new ArrayList<>();
        this.message = new ArrayList<>();
    }

    public long getId() {
        return Id;
    }

    public List<User> getUsers() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public List<Message> getMessages() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }
}
