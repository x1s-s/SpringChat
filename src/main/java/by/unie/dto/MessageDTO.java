package by.unie.dto;

import by.unie.chat.Message;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
@Data
@Component("messageDTO")
public class MessageDTO {
    private String text;
    private String name;
    private Date date;

    public MessageDTO() {
    }

    public MessageDTO(String text, String name, Date date) {
        this.text = text;
        this.name = name;
        this.date = date;
    }

    public static MessageDTO from(Message message){
        return new MessageDTO(message.getText(),message.getAuthor().getName(),message.getDate());
    }
}
