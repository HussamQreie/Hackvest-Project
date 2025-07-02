```sh

university-hackfest/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── hackfest/
│   │   │           ├── api/
│   │   │           │   └── ExploitApiController.java
│   │   │           ├── controller/
│   │   │           │   ├── HomeController.java
│   │   │           │   ├── StudentController.java
│   │   │           │   └── AdminController.java
│   │   │           ├── entity/
│   │   │           │   ├── User.java
│   │   │           │   ├── Subject.java
│   │   │           │   └── Enrollment.java
│   │   │           ├── repository/
│   │   │           │   ├── UserRepository.java
│   │   │           │   ├── SubjectRepository.java
│   │   │           │   └── EnrollmentRepository.java
│   │   │           ├── exploit/
│   │   │           │   └── ChaosEngine.java
│   │   │           └── HackFestApplication.java
│   │   ├── resources/
│   │   │   ├── static/
│   │   │   │   ├── css/
│   │   │   │   │   └── bootstrap.min.css
│   │   │   │   └── js/
│   │   │   │       └── hack-ui.js
│   │   │   ├── templates/
│   │   │   │   ├── home.html
│   │   │   │   ├── login.html
│   │   │   │   ├── student/
│   │   │   │   │   └── profile.html
│   │   │   │   └── admin/
│   │   │   │       └── manage.html
│   │   │   ├── application.yml
│   │   │   └── data.sql
│   └── test/
│       └── java/
│           └── com/
│               └── hackfest/
│                   └── HackFestApplicationTests.java
├── .github/
│   └── workflows/
│       └── ci-cd.yml
├── Dockerfile
├── docker-compose.yml
├── pom.xml
├── exploit-guide.md

```
└── chaos-config.json
