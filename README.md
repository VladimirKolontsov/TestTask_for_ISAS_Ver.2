Инструкция по запуску приложения

1. Скачиваем проект:
https://github.com/VladimirKolontsov/TestTask-for-Java-Developer-position-in-ISAS

2. Открываем его в IDEA.

3. Необходимо создать базу данных с именем: technique_shop

Host: localhost
Port: 5432
URL: jdbc:postgresql://localhost:5432/technique_shop

User: postgres
Password: admin

4. После создания БД и успешного подключения к ней, заходим в файл sqlForDB.sql и выполняем скрипты по созданию
и заполнению таблиц БД.

5. Запускаем приложение.

6. Далее можно работать с приложением через web браузер по url:

http://localhost:8080/ - переход на стартовую страницу

http://localhost:8080/find - выдает весь реестр техники

http://localhost:8080/find/name/{имя типа техники} - выдает список всех типов и моделей, выбранного типа техники
(можно передать одновременно разные типы техники через запятую без пробела)

http://localhost:8080/find-color?color={выбранные цвета} - выдает список всей техники данного цвета (можно передать
одновременно разные цвета техники через запятую без пробела)

http://localhost:8080/find-price?min={цена от}&max={цена до} - выдает список всей техники в выбранном диапазоне цен

http://localhost:8080/find-stock?stock={true или false} - выдает список всех моделец, которые есть в наличии

http://localhost:8080/find-size?min={размер от}&max={размер до} - выдает список всех моделей по заданному диапазону
размеров

http://localhost:8080/sort-name?stock={true / false}&sorting={тип сортировки: по возрастанию - ASC, по убыванию - DESC} -
выводит список всех моделей из наличия в алфавитном порядке (ASC) или обратном порядке (DESC)

http://localhost:8080/sort-price?stock={true / false}&sorting={тип сортировки: по возрастанию - ASC, по убыванию - DESC} -
выводит список всех моделей по возрастанию цены (ASC) или по убыванию цены (DESC)

7. Для добавления новой модели лучше использовать Postman.

    - добавляем новый Request через +
    - выбираем тип запроса POST
    - отправляем тело запроса вот в таком формате (значения можно ставить любые) :

    Пример для добавления "телевизора"

    {
        "productTypeId": 1,
        "name": "testmodel222",
        "serialNumber": 5555,
        "color": "Blue",
        "size": 10,
        "price": 299000,
        "isInStock": true,
        "tvAttributeDto": {
            "categories": "laptop",
            "technology": "apple m2"
        }
    }

    Расшифровка названия полей в теле запроса:

        productTypeId = id типа модели, в которую будем добавлять
        name = имя модели
        serialNumber = серийный номер модели
        color = цвет модели
        size = размер модели
        price = цена модели
        isInStock = наличие на складе (true / false)
        tvAttributeDto = уникальные характеристики телевизора
            (categories - категория, technology - технология)

8. Также для проверки работоспособности прилоежния, после его запуска, можно перейти по ссылке:
http://localhost:8080/swag-run.html

Для добавления обищх параметров для списка моделей надо использовать шаблон запроса:
{
   "typesId": 1,
   "country": "Iloilo",
   "brand": "ggjjg",
   "isOnlineOrder": true,
   "isCredit": true
}

"typesId" - может быть от 1 до 5.

    Расшифровка названия полей в теле запроса:

        typesId = id типа техники
        country = страна изготовитель
        brand = марка моделей
        isOnlineOrder = возможность заказа онлайн
        isCredit = возможность покупки в кредит

Для добавления нового телевизора:

{
    "productTypeId": 1,
    "name": "testmodel222",
    "serialNumber": 5555,
    "color": "Blue",
    "size": 10,
    "price": 299000,
    "isInStock": true,
    "tvAttributeDto": {
        "categories": "laptop",
        "technology": "apple m2"
    }
}

"productTypeId" - может быть от 1 до 3

Для добавления нового пылесоса:

{
    "productTypeId": 5,
    "name": "testmodel222",
    "serialNumber": 5555,
    "color": "Blue",
    "size": 10,
    "price": 299000,
    "isInStock": true,
    "cleanerAttributeDto": {
        "dustContainerVolume": 3.0,
        "quantityOfModes": 2
    }
}

"productTypeId" - может быть от 4 до 6

Для добавления нового холодильника:

{
    "productTypeId": 9,
    "name": "testmodel222",
    "serialNumber": 5555,
    "color": "Blue",
    "size": 10,
    "price": 299000,
    "isInStock": true,
    "fridgeAttributeDto": {
        "quantityOfDoors": 3,
        "typeOfCompressor": "sdfsdf"
    }
}

"productTypeId" - может быть от 7 до 9

Для добавления нового телефона:
{
    "productTypeId": 11,
    "name": "testmodel222",
    "serialNumber": 5555,
    "color": "Blue",
    "size": 10,
    "price": 299000,
    "isInStock": true,
    "phoneAttributeDto": {
        "phoneMemory": 64,
        "quantityOfCameras": 2
    }
}

"productTypeId" - может быть от 10 до 12

Для добавления нового компьютера:

{
    "productTypeId": 15,
    "name": "testmodel222",
    "serialNumber": 5555,
    "color": "Blue",
    "size": 10,
    "price": 299000,
    "isInStock": true,
    "computerAttributeDto": {
        "categories": "laptop",
        "typeOfProcessor": "apple m2"
    }
}

"productTypeId" - может быть от 13 до 15


Во всех методах можно вводить значения для проверки, результат будет выводиться на экран после нажатия на Execute.

Для проверки возможности добавления новой модели или общих параметров для списка моделей, надо удалить весь предложенный
шаблон запроса и использовать шаблон из п.7 или те, что предложены в этом пункте. Надо его скопировать и вписать туда
любые валидные значения.
