package by.unie.dto;

import by.unie.chat.Message;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
@Data
@Component("messageDto")
public class MessageDto {
    private String text;
    private String name;
    private Date date;

    public MessageDto() {
    }

    public MessageDto(String text, String name, Date date) {
        this.text = text;
        this.name = name;
        this.date = date;
    }

    public static MessageDto from(Message message){
        return new MessageDto(message.getText(),message.getAuthor().getName(),message.getDate());
    }
}
