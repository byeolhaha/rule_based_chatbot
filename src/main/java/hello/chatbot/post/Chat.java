package hello.chatbot.post;

import groovy.transform.builder.Builder;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동 생성
    private Long id;
    private String data;

    @Builder
    public Chat(String data){
        this.data= data;
    }
}
