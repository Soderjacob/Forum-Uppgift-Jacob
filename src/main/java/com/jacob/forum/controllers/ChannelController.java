package com.jacob.forum.controllers;

import com.jacob.forum.entities.Channel;
import com.jacob.forum.entities.Message;
import com.jacob.forum.repositories.ChannelRepository;
import com.jacob.forum.repositories.MessageRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ChannelController {
    private final ChannelRepository channelRepository;
    private final MessageRepository messageRepository;

    public ChannelController(ChannelRepository channelRepository, MessageRepository messageRepository){
        this.channelRepository = channelRepository;
        this.messageRepository = messageRepository;
    }

    @GetMapping("/channels")
    public List<Channel> getAllChannels(){
        return channelRepository.findAll();
    }

    @PostMapping("/channels")
    public Channel createChannel(@RequestBody Channel channel){
        return channelRepository.save(channel);
    }

    @DeleteMapping("/channels/{id}")
    public void deleteChannel(@PathVariable Long id){
        channelRepository.deleteById(id);
    }

    @PutMapping("/channels/{id}")
    public Message createMessage(@PathVariable Long id, @RequestBody Message message) {
        Channel channel = channelRepository.findById(id).orElseThrow();
        message.setChannel(channel);
        return messageRepository.save(message);
    }

    @GetMapping("/channels/{id}")
    public List<Message> getAllMessages(@PathVariable Long id) {
        Channel channel = channelRepository.findById(id).orElseThrow();
        return messageRepository.findByChannel(channel);
    }
}
