# 마일리지 서비스 개발(22.07.02 ~ 22.07.09)

### 1️⃣ 애플리케이션 실행 방법
#### 1) 레포지토리를 clone 받아주세요.

#### 2) clone 받은 프로젝트를 열고 build 해주세요.
```
$ ./gradlew build
```

(아래 경로에 jar 파일이 생깁니다.)

![image](https://user-images.githubusercontent.com/52378625/178095160-dd5ccc95-c442-439b-b2d5-13af2fd7ad32.png)


#### 3) build/libs/ 위치로 이동한 뒤, 만들어진 jar 파일을 실행해주세요.
```
$ cd build/libs/
```

```
$ java -jar backend-0.0.1-SNAPSHOT.jar
```

#### 4) 정상적으로 실행된다면 아래와 같은 문구가 보일 겁니다.☺

![image](https://user-images.githubusercontent.com/52378625/178095427-8f969b25-d465-45bc-89bf-61d5b0b8ee17.png)

---

### 2️⃣ API 명세 확인 방법
#### 애플리케이션 실행 후, http://localhost:8080/docs/api-docs.html 에 접속하시면 API 명세를 확인하실 수 있습니다(Spring Rest Docs 적용).
![image](https://user-images.githubusercontent.com/52378625/178095463-a9b426f6-3d6a-4e05-9c10-c45b4af8f2e4.png)

