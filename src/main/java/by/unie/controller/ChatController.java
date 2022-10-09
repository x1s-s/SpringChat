package by.unie.controller;

import by.unie.chat.Chat;
import by.unie.chat.Message;
import by.unie.chat.User;
import by.unie.dto.MessageDto;
import by.unie.service.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    ChatService chatService;


    @GetMapping("/user/{id}")
    public ResponseEntity<List<User>> getUserFromChat(@PathVariable int id) {
        return ResponseEntity.ok(chatService.getUsers(id));
    }

    @GetMapping("/message/{id}")
    public ResponseEntity<List<MessageDto>> getMessageFromChat(@PathVariable int id) {
        return ResponseEntity.ok(chatService.getMessages(id));
    }

    @PostMapping("/user/add")
    public ResponseEntity addUser(@RequestBody User user) {
        log.info("add user");
        chatService.addUser(user);
        return ResponseEntity.ok().build();
    }

    @PostMapping("{id}/{name}/message/add")
    public ResponseEntity addMessage(@RequestBody String text, @PathVariable int id, @PathVariable String name) {
        log.info("add user");
        chatService.addMessage(text, id, name);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/create")
    public ResponseEntity<Integer> addChat() {
        log.info("add chat");
        return ResponseEntity.ok(chatService.addChat(new Chat()));
    }

    @PostMapping("{id}/addtochat/{name}")
    public ResponseEntity addUserToChat(@PathVariable int id, @PathVariable String name) {
        log.info("add user " + name + " to chat " + id);
        if(chatService.addUserToChat(id, name)){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
