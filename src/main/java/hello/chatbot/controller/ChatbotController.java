package hello.chatbot.controller;





import hello.chatbot.response.ChatbotResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;




@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ChatbotController {


    // ajax가 클라이언트로부터 받은 데이터를 여기 Controller끼리 데이터를 주고 받아야 하는 상황이다.
    //그래서 Data라는 클래스를 만들어서 주고 받도록 했다.
    // 어떤 데이터 하나를 어떤 Controller가 읽고 어떤 Controller가 쓰는 것은 좋은 코드가 아니지만
    // 이렇게 클래스를 만들어서 주고 받는 것, private로 선언하는 것이 좋은 코드일까? 다시 생각해보자
    static String input;

    private final ChatbotResponse chatbotResponse;

    @GetMapping
    public String home() {

    return "index";
    }

    @ResponseBody
    @PostMapping("get")
    public void get(
            @RequestParam("question") String question
     ) {
        input=question;

    }

    @ResponseBody
    @PostMapping("service")
    public Map<String,String> service() throws Exception{

        System.out.println("sevice inpt:"+input);
        Map<String, String> output = chatbotResponse.makeResponse(input);

        return output;


    }


}
