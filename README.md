## [REST API](http://localhost:8080/doc)

## Концепція:

- Spring Modulith
    - [Spring Modulith: достигли ли мы зрелости модульности](https://habr.com/ru/post/701984/)
    - [Introducing Spring Modulith](https://spring.io/blog/2022/10/21/introducing-spring-modulith)
    - [Spring Modulith - Reference documentation](https://docs.spring.io/spring-modulith/docs/current-SNAPSHOT/reference/html/)

```
  url: jdbc:postgresql://localhost:5432/jira
  username: jira
  password: JiraRush
```

## Аналоги

- https://java-source.net/open-source/issue-trackers

## Тестування

- https://habr.com/ru/articles/259055/

## Список виконаних задач:
| Задача      | Умова                                             | Статус      |
|-------------|---------------------------------------------------|-------------|
| 1           | Розібратися зі структурою проєкту (onboarding)    | :white_check_mark:     |
| 2          | Видалити соціальні мережі: vk, yandex.      | :white_check_mark:      |
| 3     | Винести чутливу інформацію до окремого проперті файлу: логінб пароль БД, ідентифікатори для OAuth реєстрації/авторизації, налаштування пошти| :white_check_mark:           |
| 4     | Переробити тести так, щоб під час тестів використовувалася in memory БД (H2), а не PostgreSQL. Для цього потрібно визначити 2 біна, і вибірка якої використовувати повинна визначатися активним профілем Spring. H2 не підтримує всі фічі, які є у PostgreSQL, тому тобі доведеться трохи спростити скрипти з тестовими даними. | :white_check_mark:      |
| 5     | Написати тести для всіх публічних методів контролера ProfileRestController. Хоча методів лише 2, але тестових методів має бути більше, оскільки необхідно перевірити success and unsuccess path.| :construction:      |
| 6     | Зробити рефакторинг методу com.javarush.jira.bugtracking.attachment.FileUtil#upload, щоб він використовував сучасний підхід для роботи з файловою системою.| :white_check_mark:          |
| 7     | Додати новий функціонал: додавання тегів до завдання (REST API + реалізація на сервісі). | :white_check_mark:          |
| 8     | Додати підрахунок часу: скільки завдання перебувало у роботі та тестуванні. | :white_check_mark:         |
| 9     | Написати Dockerfile для основного сервера | :white_check_mark:           |
| 10     | Написати docker-compose файл для запуску контейнера сервера разом з БД та nginx. Для nginx використовуй конфіг-файл config/nginx.conf. За потреби файл конфіга можна редагувати. | :white_check_mark:          |
| 11     | Додати локалізацію мінімум двома мовами для шаблонів листів (mails) та стартовою сторінки index.html.  | :white_check_mark:          |
| 12     | Переробити механізм розпізнавання «свій-чужий» між фронтом і беком з JSESSIONID на JWT. Extra-hard task  | :construction:         |
