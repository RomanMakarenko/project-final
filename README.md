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
| 3     | Винести чутливу інформацію до окремого проперті файлу: логінб пароль БД, ідентифікатори для OAuth реєстрації/авторизації, налаштування пошти| Інше 3      |
