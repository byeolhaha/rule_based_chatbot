package hello.chatbot.domain.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostSave {
    @Autowired
    private PostRepository postRepository;

    public void saveData(Post post) {
        postRepository.save(post);
    }


}
