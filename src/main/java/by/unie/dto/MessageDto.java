package by.unie.dto;

import by.unie.chat.Message;
import org.springframework.stereotype.Component;

import java.util.Date;

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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static MessageDto from(Message message){
        return new MessageDto(message.getText(),message.getAuthor().getName(),message.getDate());
    }
}
