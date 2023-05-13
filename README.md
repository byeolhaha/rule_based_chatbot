# rule_based_chatbot

## 🤖 개인 프로젝트 소개 
실무자들을 위한 민원 상담 챗봇입니다.
민원처리법 해석, 서식민원 접수 방법 등을 설명해줍니다.

## 개발 기간
- 2023.01.01. ~ 2023.01.31.

## 설명

### 요구사항 및 해결 방법
- 사용자는 원하는 양식이 필요한 경우 다운로드 받을 수 있습니다. 
  - 사용자가 "취하원 양식이 뭐야?"라는 질문을 하면 "취하원 양식"을 다운로드 받을 수 있는 링크가 등장합니다.
- 답변이 빠르게 와야 합니다. 
  - 서버가 감당할 수 있는 모델의 무게를 결정해야 합니다.
- 정확한 답변이 와야 합니다.
  - DB를 연동해서 이상한 답변이 가는 데이터들을 모아 주기적으로 올바른 답변으로 업데이트 합니다.
  
### Chatbot
<img src="https://img.shields.io/badge/Language-python-green"/>
- 데이터가 부족한 경우, Bert 모델을 이용할 수도 있습니다.
- 내부 python파일을 필요에 따라 원하는 모델로 바꾸시면 됩니다.
- 규칙기반 챗봇의 경우 데이터가 많고 특정 분야가 정해진 경우에 이용합니다.
- 위 챗봇은 민원처리에 관한 특정 분야가 정해져 있기 때문에 규칙 기반으로 정했습니다.

### Web
 #### 백엔드 <img src="https://img.shields.io/badge/Language-Java-green"/> <img src="https://img.shields.io/badge/Framwork-Springboot-red"/> 
- 규칙 기반을 통해 답변을 찾는 python 외부 파일을 Java가 실행해야 합니다.
  - **ProcessBuilder**를 이용하여 외부에 있는 python 파일을 실행했습니다.
  - 프로젝트의 ```src\main\java\hello\chatbot\python``` 안에 놓았지만 실제는 외부에 있어야 합니다.
- 사용자는 원하는 양식이 필요한 경우 다운로드 받을 수 있습니다. 
  - excel에 저장된 답변 데이터에 <a>태그를 통해 파일의 링크를 넣었습니다.
  - 이 답변 데이터는 ```src\main\java\hello\chatbot\domain\question```에 있는 **"FileLinkMaker"**를 통해서 HTML태그를 분리합니다.
  - 분리된 HTML에 태그는 Javascript에서 HTML태그를 만드는 innerhtml를 통해서 HTML 태그로 리턴됩니다.  
 #### 프론트 <img src="https://img.shields.io/badge/Language-Javascript-green"/>  <img src="https://img.shields.io/badge/Language-HTML-green"/> <img src="https://img.shields.io/badge/Language-CSS-green"/>
- 비동기 통신으로 이루어지기 때문에 Javascript의 Ajax를 사용했습니다.

### DB 
<img src="https://img.shields.io/badge/DB-Cloud%20DB%20for%20MySQL%20-orange"/> 
- 규칙 기반 챗봇의 경우 대량의 데이터가 필요하기 때문에 사용자로부터 잘못된 답변이 오는 경우 DB에 쌓이도록 구현했습니다.</br>
  - 사용자가 잘못된 답변을 받은 경우 "바보: 잘못된 답변이 간 질문"을 챗팅창에 넣으면 이 데이터가 DB에 쌓입니다.</br>
  - 올바른 답변 데이터를 연결하는 작업을 주기적으로 진행합니다.</br>
    
## 결과물
![image](https://user-images.githubusercontent.com/108210958/227143931-9690e5d3-1242-4cc6-a921-00c29724d717.png)

- 도메인
http://www.minwonchatbot.site/

