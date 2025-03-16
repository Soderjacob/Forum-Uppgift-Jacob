package com.jacob.forum.repositories;

import com.jacob.forum.entities.Channel;
import com.jacob.forum.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByChannel(Channel channel);
}
