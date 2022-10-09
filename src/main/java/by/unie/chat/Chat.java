package by.unie.chat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    @ManyToMany
    @JoinColumn(name = "chat_id")
    private List<User> user;
    @OneToMany
    @JoinColumn(name = "chat_id")
    private List<Message> message;

    public Chat(){
        this.user = new ArrayList<>();
        this.message = new ArrayList<>();
    }

    public int getId() {
        return Id;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }
}
