package hello.chatbot.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    @Autowired
    private ChatRepository chatRepository;

    public void saveData(Chat chat) {
        chatRepository.save(chat);
    }


}
