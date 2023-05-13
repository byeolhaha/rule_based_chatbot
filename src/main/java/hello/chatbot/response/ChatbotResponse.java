package hello.chatbot.response;

import hello.chatbot.post.Chat;
import hello.chatbot.post.ChatService;
import hello.chatbot.python.PythonFileReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class ChatbotResponse {

    private final ChatService postsaveService;


    public Map<String,String> makeResponse(String input) {

        Map<String,String> output = new HashMap<>();

        if (!input.contains("바보")) {

            String path = new File("").getAbsolutePath();// 서버


            //String path = "./src/main/java/hello/chatbot/python"; //로컬

            String pyFileName = "rule_based.py";

            //String methodeName = "return_similar_answer(\"" + sb + "\")";
            String methodeName = "chat(\'" + input + "\')";


            System.out.println("methodName :" + methodeName);

            PythonFileReader pythonFile_reader;
            try {
                pythonFile_reader = new PythonFileReader(path, pyFileName, methodeName);
                // pythonFile_reader = new PythonFile_Reader(file, pyFileName, methodeName);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            //file.deleteOnExit();

            output = pythonFile_reader.getOutput();
        } else {
            System.out.println(input);
            postsaveService.saveData(new Chat(input));
            output.put("Text", "더 열심히 공부할게요. 도와주셔서 감사합니다. 🕵️");
            output.put("Link", "");


        }

        return output;
    }

}
