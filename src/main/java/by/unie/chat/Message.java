package by.unie.chat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    @JoinColumn(name = "author_id")
    private User author;
    private String text;
    private Date date;

    public User getAuthor() {
        return author;
    }

    public Message() {
    }

    public Message(User author, String text, Date date) {
        this.author = author;
        this.text = text;
        this.date = date;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }
}
