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

- Есть 2 общие таблицы, на которых не fk
    - _Reference_ - справочник. Связь делаем по _code_ (по id нельзя, тк id привязано к окружению-конкретной базе)
    - _UserBelong_ - привязка юзеров с типом (owner, lead, ...) к объекту (таска, проект, спринт, ...). FK вручную будем
      проверять

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
| 4     | Переробити тести так, щоб під час тестів використовувалася in memory БД (H2), а не PostgreSQL. Для цього потрібно визначити 2 біна, і вибірка якої використовувати повинна визначатися активним профілем Spring. H2 не підтримує всі фічі, які є у PostgreSQL, тому тобі доведеться трохи спростити скрипти з тестовими даними. | Інше 3      |
| 5     | Написати тести для всіх публічних методів контролера ProfileRestController. Хоча методів лише 2, але тестових методів має бути більше, оскільки необхідно перевірити success and unsuccess path.| Інше 3      |
| 6     | Зробити рефакторинг методу com.javarush.jira.bugtracking.attachment.FileUtil#upload, щоб він використовував сучасний підхід для роботи з файловою системою.| :white_check_mark:          |
| 7     | Додати новий функціонал: додавання тегів до завдання (REST API + реалізація на сервісі). | :white_check_mark:          |
