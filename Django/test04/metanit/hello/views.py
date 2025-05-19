from django.shortcuts import render
from .models import Person

# Create your views here.

def start01(request):
    # получаем все объекты
    people=Person.objects.all()
    print(people.query)

    # получаем объекты с именем Tom
    people=people.filter(name="Tom")
    print(people.query)

    # получаем объекты с возрастом, равным 31
    people=people.filter(age=31)
    print(people.query)

    # здесь происходит выполнения запроса в БД
    for person in people:
        print(f"{person.id}.{person.name} - {person.age}")
    return render(request,"index.html")

def start02(request):
    tom=Person.objects.create(name="Tom",age=31)
    print(tom.id)
    return render(request,"index.html")

import asyncio

async def acreate_person():
    person=await Person.objects.acreate(name="Tim",age=25)
    print(person.name)

def start03(request):
    asyncio.run(acreate_person())
    return render(request,"index.html")

def start04(request):
    milla=Person(name="Milla",age=28)
    milla.save()
    return render(request,"index.html")

def start05(request):
    people=Person.objects.bulk_create([
        Person(name="Kate",age=24),
        Person(name="Ann",age=21),
    ])
    for person in people:
        print(f"{person.id}.{person.name}")
    return render(request,"index.html")

async def abulk_person():
    people=await Person.objects.abulk_create([
        Person(name="Alfred",age=54),
        Person(name="Mikky",age=38),
    ])
    for person in people:
        print(f"{person.id}.{person.name}")

def start06(request):
    asyncio.run(abulk_person())
    return render(request,"index.html")

from django.core.exceptions import ObjectDoesNotExist,MultipleObjectsReturned

def start07(request):
    try:
        #jack=Person.objects.get(name="Tom")
        #old=Person.objects.get(age=60)
        milla=Person.objects.get(name="Milla")
        print(f"{milla.name} {milla.age} {milla.id}")
    except ObjectDoesNotExist:
        print("ObjectDoesNotExist")
    except MultipleObjectsReturned:
        print("MultipleObjectsReturned")
    return render(request,"index.html")

async def aget_person():
    person=await Person.objects.aget(id=1)
    print(person.name)

def start08(request):
    asyncio.run(aget_person())
    return render(request,"index.html")

def start09(request):
    bob, created = Person.objects.get_or_create(name="Bob", age=24) #aget_or_create
    print(created)
    print(bob.name)
    print(bob.age)
    return render(request,"index.html")

def start10(request):
    people=Person.objects.all()
    print(people.query)
    print(people)
    for p in people:
        print(p.name,p.age)
    return render(request,"index.html")

def start11(request):
    people=Person.objects.filter(age=23)
    # использование нескольких критериев
    people2=Person.objects.filter(name="Tom",age=23)
    print(people)
    for p in people:
        print(p.name,p.age)
    print(people2)
    for p in people2:
        print(p.name,p.age)
    return render(request,"index.html")

def start12(request):
    # исключаем пользователей, у которых age=23
    people=Person.objects.exclude(age=23)
    for p in people:
        print(p.name,p.age)
    # выбираем всех пользователей, у которых name="Tom" кроме тех, у которых age=23
    people = Person.objects.filter(name="Tom").exclude(age=23)
    for p in people:
        print(p.name,p.age)
    return render(request,"index.html")

def start13(request):
    # получаем все объекты
    #является более эффективным способом для чтения большого количества записей
    people=Person.objects.in_bulk()   #ain_bulk
    print(people)
    for id in people:
        print(people[id].name)
        print(people[id].age)
    # получаем объекты с id=1 и id=3
    people2 = Person.objects.in_bulk([1,3])
    print(people2)
    for id in people2:
        print(people2[id].name)
        print(people2[id].age)
    return render(request,"index.html")

def start14(request):
    people = Person.objects.all()[:5]
    for person in people:
        print(f"{person.id}.{person.name} - {person.age}")
    people = Person.objects.all()[5:10]
    for person in people:
        print(f"{person.id}.{person.name} - {person.age}")
    return render(request,"index.html")

def start15(request):
    bob=Person.objects.get(id=2)
    bob.name="Bob"
    bob.save()

    bob=Person.objects.get(id=1)
    bob.name="Robert"
    bob.save(update_fields=["name"])
    return render(request,"index.html")

from django.db.models import F

def start16(request):
    number = Person.objects.filter(id=1).update(name="Mike")   #aupdate
    print(number) # количество обновленных строк
    Person.objects.filter(id=2).update(name="Mike", age = 33)
    Person.objects.filter(id=3).update(age = F("age") + 1)
    #Person.objects.all().update(name="Mike")
    #Person.objects.all().update(age = F("age") + 1)
    return render(request,"index.html")

def start17(request):
    values_for_update={'name':'Rikky','age':29} #aupdate_or_create
    rikky,created=Person.objects.update_or_create(id=4,defaults=values_for_update)
    print(rikky,created)
    return render(request,"index.html")

def start18(request):
    first_person = Person.objects.get(id=1) 
    first_person.name = "Tomas"
    
    second_person = Person.objects.get(id=2)
    second_person.age = 29
    
    number = Person.objects.bulk_update([first_person, second_person], ["name", "age"]) #abulk_update
    print(number)   # 2
    return render(request,"index.html")

def start19(request):
    person=Person.objects.get(id=5)
    person.delete()
    print(person.name)
    Person.objects.filter(id=4).delete()
    #Person.objects.all().delete()
    return render(request,"index.html")

def func01(request):
    #получаем пользователя по имени
    tom=Person.objects.get(name="Tom")
    print(f"{tom.name} - {tom.age}")
    #получаем пользователей у которых возраст равен 32
    people_by_age1=Person.objects.filter(age=32)
    for person in people_by_age1:
        print(f"{person.name} * {person.age}")
    #получаем пользователей, у которых возраст НЕ равен 32
    people_by_age2=Person.objects.exclude(age=32)
    for person in people_by_age2:
        print(f"{person.name} = {person.age}")
    return render(request,"index.html")

def func02(request):
    #получаем пользователя по имени Tom
    tom=Person.objects.get(name__exact="Tom")
    print(tom.name)
    #получаем пользователей, у которых возраст равен 32
    people_by_age=Person.objects.filter(age__exact=38)
    for people in people_by_age:
        print(people.name)
    #получаем пользователя по имени Tom или tom или TOM
    tom=Person.objects.get(name__iexact="ToM")
    print(tom.name)
    # получаем пользователей, у которых имя равно NULL
    people_by_name = Person.objects.filter(name__exact=None)
    return render(request,"index.html")

def func03(request):
    #получаем пользователей, у которых имя содержит букву о
    people01=Person.objects.filter(name__contains="o")
    #получаем пользователей, у которых имя содержит букву T или t
    people02=Person.objects.filter(name__icontains="T")
    print(people01,people02)
    for p in people01:
        print(p.name)
    print()
    for p in people02:
        print(p.name)
    
    return render(request,"index.html")

def func04(request):
    #Получаем пользователей, у которых возраст равен или 32, или 35, или 38,
    people=Person.objects.filter(age__in=[32,35,38])
    for p in people:
        print(p.name)
    return render(request,"index.html")

def func05(request):
    print("получаем пользователей у которых возраст больше чем 29")
    people_gt=Person.objects.filter(age__gt=29)
    for p in people_gt:
        print(f"{p.name}-{p.age}")
    print("получаем пользователей у которых возраст больше или равно 29")
    people_gte=Person.objects.filter(age__gte=29)
    for p in people_gte:
        print(f"{p.name}-{p.age}")
    print("получаем пользователей у которых возраст меньше 35")
    people_lt=Person.objects.filter(age__lt=35)
    for p in people_lt:
        print(f"{p.name}-{p.age}")
    print("получаем пользователей у которых возраст меньше или равно 35")
    people_lte=Person.objects.filter(age__lte=35)
    for p in people_lte:
        print(f"{p.name}-{p.age}")
    print("получаем пользователей, у которых имя начинается с To")
    people = Person.objects.filter(name__startswith="To") 
    for p in people:
        print(f"{p.name}-{p.age}")
    print("получаем пользователей, у которых имя начинается с To или to")
    people = Person.objects.filter(name__istartswith="tO")
    for p in people:
        print(f"{p.name}-{p.age}")
    print("получаем пользователей, у которых имя заканчивается на m")
    people = Person.objects.filter(name__endswith="m")
    for p in people:
        print(f"{p.name}-{p.age}")
    print("получаем пользователей, у которых имя заканчивается на m или M")
    people = Person.objects.filter(name__iendswith="M")
    for p in people:
        print(f"{p.name}-{p.age}")
    print("получаем пользователей, у которых возраст в диапазоне от 28 до 38 включительно")
    people = Person.objects.filter(age__range=(28, 38))
    for p in people:
        print(f"{p.name}-{p.age}")
    # получаем пользователей, у которых имя не установлено
    people = Person.objects.filter(name__isnull=True)
    # получаем пользователей, у которых возраст установлен
    people = Person.objects.filter(age__isnull=False)
    return render(request,"index.html")    

def func06(request):
    # получаем пользователей, у которых имя заканчивается на am или om
    people = Person.objects.filter(name__regex=r"(am|om)$")  #iregex - не зависит от регистра
    for p in people:
        print(f"{p.name}-{p.age}")
    return render(request,"index.html")

from .models import Order
from datetime import datetime,date,time
def func08(request):
    """
    Целый ряд спецификаторов фильтрации предназначен для работы с датами:
    date: значение поля должно соответствовать определенной дате. Представляет объект datetime.date
    year: год даты должен соответствовать определенному значению.
    month: определяет месяц даты
    day: определяет день даты
    week: определяет номер недели даты (1-52 или 53)
    week_day: определяет день недели даты (от 1 (воскресенье) до 7 (суббота)
    iso_week_day: определяет день недели даты (от 1 (понедельник) до 7 (воскресенье)
    quarter: определяет номер квартала даты
    time: определяет время даты. Представляет объект datetime.time
    hour: определяет час даты (от 0 до 23)
    minute: определяет минуту даты (от 0 до 59)
    second: определяет секунду даты (от 0 до 59)
    """
    # добавление начальных данных
    if Order.objects.count() == 0:
        Order.objects.create(datatime = datetime(2021, 12, 26, 11, 25, 34))
        Order.objects.create(datatime = datetime(2022, 5, 12, 12, 25, 34))
        Order.objects.create(datatime = datetime(2022, 5, 22, 13, 25, 34))
        Order.objects.create(datatime = datetime(2022, 8, 19, 14, 25, 34))
    print("получаем заказы, сделанные в 5-м месяце")
    orders = Order.objects.filter(datatime__month=5)
    for order in orders:
        print(order.datatime)
    print("получаем заказы, сделанные после 5-го месяца")
    orders = Order.objects.filter(datatime__month__gt=5)
    for order in orders:
        print(order.datatime)
    print("получаем заказы, сделанные 22 мая")
    orders = Order.objects.filter(datatime__date=date(2022, 5, 22))
    for order in orders:
        print(order.datatime)
    print("получаем заказы, сделанные после 12 часов")
    orders = Order.objects.filter(datatime__time__gt=time(12, 20, 0))
    for order in orders:
        print(order.datatime)
    return render(request,"index.html")

def func09(request):
    print("вывести поле если name=Tom и age=22")
    people = Person.objects.filter(name="Tom") & Person.objects.filter(age=22)
    for p in people:
        print(p.name)
    print("вывести поле если name=Tom или age=22")
    people = Person.objects.filter(name="Tom") | Person.objects.filter(age=22)
    for p in people:
        print(p.name)
    print("вывести поле если name=Tom xor age=22")
    people = Person.objects.filter(name="Tom") ^ Person.objects.filter(age=22)
    for p in people:
        print(p.name)
    return render(request,"index.html")

def func10(request):
    print("упорядочиваем по имени по возрастанию")
    people=Person.objects.order_by("name")
    for person in people:
        print(person.name)
    print("Упорядочиваем поп имени и возрасту")
    people=Person.objects.order_by("name","age")
    for person in people:
        print(person.name)
    print("Реверсивная Сортировка по имени")
    people=Person.objects.order_by("-name")
    for person in people:
        print(person.name)
    """Методы values() и values_list() предназначены для оптимизации: 
    для извлечения поднабора данных без необходимости 
    создания полного объекта модели."""
    print("Метод values")
    people=Person.objects.values()
    print(people)
    print(people[1])
    print("Также можно передать в метод values названия полей, которые должны быть в словаре (по умолчанию выбираются все поля модели):")
    people=Person.objects.values("id","name")
    print(people)
    print("Метод values_list во многом аналогичен values(): он возвращает объект QuerySet, который состоит из кортежей. Каждый кортеж хранит данные одного объекта модели. Например:")
    people=Person.objects.values_list()
    print(people)
    print("Также можно выбрать отдельные поля, передав их названия в метод:")
    people=Person.objects.values_list("name","age")
    print(people)
    print("Если выбирается только одно поле, то в итоге получится набор кортежей, в каждом из которых будет по одному значению. Но передав параметру flat значение True можно упростить набор, вынеся значения на уровень выше:")
    people=Person.objects.values_list("name",flat=True)
    print(people)
    return render(request,"index.html")

def func11(request):
    print("distinct() выбирает уникальные значения")
    print("без distinct")
    people=Person.objects.values_list("name",flat=True)
    print(people)
    print("с distinct")
    people=Person.objects.values_list("name",flat=True).distinct()
    print(people)
    print("union() возвращает QuerySet, который является объединением двух QuerySet")
    tom=Person.objects.filter(name="Tom")
    milla=Person.objects.filter(name="Milla")
    people=tom.union(milla)
    print(people.values())
    """По умолчанию метод union() выбирает только уникальные значения из обоих выборок. Если такое поведение нежелательно, то в метод необходимо передать аргумент all=True"""
    # выбираем только уникальные (по умолчанию)
    people = tom.values("name").union(milla)
    print(people)
    # <QuerySet [{'name': 'Bob'}, {'name': 'Tom'}]>
    # выбираем все
    people = tom.values("name").union(milla, all=True)
    print(people)
    # <QuerySet [{'name': 'Tom'}, {'name': 'Tom'}, {'name': 'Bob'}]>
    print("Метод intersection() возвращает QuerySet в виде перечения других QuerySet (то есть находит объекты, которые есть во всех выборках).")
    toms = Person.objects.filter(name="Tom")
    print(toms.values())
    # <QuerySet [{'id': 2, 'name': 'Tom', 'age': 38}, {'id': 5, 'name': 'Tom', 'age': 22}]>
    
    less35 = Person.objects.filter(age__lt=35)
    print(less35.values())
    # <QuerySet [{'id': 3, 'name': 'Sam', 'age': 28}, {'id': 4, 'name': 'Alice', 'age': 32}, {'id': 5, 'name': 'Tom', 'age': 22}]>
    
    # находим пересечение двух QuerySet
    people = toms.intersection(less35)
    print(people.values())
    # <QuerySet [{'id': 5, 'name': 'Tom', 'age': 22}]>
    print("Метод difference() возвращает QuerySet в виде разности других QuerySet (то есть находит объекты, которые есть в первой выборке, но отсутствуют в других)")
    toms = Person.objects.filter(name="Tom")
    print(toms.values())
    # <QuerySet [{'id': 2, 'name': 'Tom', 'age': 38}, {'id': 5, 'name': 'Tom', 'age': 22}]>
    
    less35 = Person.objects.filter(age__lt=35)
    print(less35.values())
    # <QuerySet [{'id': 3, 'name': 'Sam', 'age': 28}, {'id': 4, 'name': 'Alice', 'age': 32}, {'id': 5, 'name': 'Tom', 'age': 22}]>
    
    # находим разность двух QuerySet
    people = toms.difference(less35)
    print(people.values())
    # <QuerySet [{'id': 2, 'name': 'Tom', 'age': 38}]>
    return render(request,"index.html")

def func12(request):
    print("получаем объект с самыми последними изменениями в поле id")
    latest_person=Person.objects.latest("id")     #alatest
    print(f"{latest_person.name} - {latest_person.age}")
    print("получаем объект с самыми ранними изменениями в поле id")
    latest_person=Person.objects.earliest("id")   #aearliest
    print(f"{latest_person.name} - {latest_person.age}")
    print("получаем объект с самыми последними изменениями в поле age и с самыми ранними изменениями в поле name")
    latest_person=Person.objects.latest("age","-name")
    print(f"{latest_person.name} - {latest_person.age}")
    #Если ни одного объекта не найдено (например, в случае с пустым набором), оба метода генерируют исключение DoesNotExist
    print("получим первый объект")
    first_person = Person.objects.first()   #afirst
    print(f"{first_person.name} - {first_person.age}")
    print("получим последний объект")
    last_person = Person.objects.last()     #alast
    print(f"{last_person.name} - {last_person.age}")
    print("получим первый объект из набора, отсортированного по возрасту")
    first_person = Person.objects.order_by("age").first()
    print(f"{first_person.name} - {first_person.age}")
    #Если ни одного объекта не найдено (например, в случае с пустым набором), оба метода возвращают значение None
    print("метод exists")           #aexists
    is_present = Person.objects.filter(name = "Tom").exists()
    if is_present:
        print("в наборе есть объекты")
    else:
        print("объекты в наборе отсутствуют")
    #если набор QuerySet содержит определенный объект
    # получим последний объект
    last_person = Person.objects.last()
    # есть ли объект last_person среди тех, у которых age меньше 35
    is_present = Person.objects.filter(age__lt=35).contains(last_person)      #acontains
    if is_present:
        print("объект есть в наборе")
    else:
        print("объект отсутствует")
    return render(request,"index.html")

from django.db.models import Avg,Min,Max,Sum

def func13(request):
    print("Для вычисления количества объектов у QuerySet применяется метод count() и его асинхронная версия acount():")
    number=Person.objects.count()     #acount
    print(number)
    print("Также можно ипзовать len")
    people=Person.objects.all()
    number=len(people)
    print(number)
    
    avg_per=Person.objects.aggregate(Avg("age"))
    print(f"Среднее значение {avg_per}")
    
    max_per=Person.objects.aggregate(Max("age"))
    print(f"Максимальное значение {max_per}")
    
    min_per=Person.objects.aggregate(Min("age"))
    print(f"Минимальное значение {min_per}")

    sum_per=Person.objects.aggregate(Sum("age"))
    print(f"Сумма {sum_per}")
    return render(request,"index.html")

def func14(request):
    print("Выполнение метода raw")
    people=Person.objects.raw("SELECT id, name, age FROM hello_person")
    for pep in people:
        print(pep.name,pep.age)
    print(people[0].name,people[0].age)
    print(people)
    # здесь filter НЕ окажет никакого влияния
    people = Person.objects.filter(age__lt=35).raw("SELECT * FROM hello_person")

    print("Передача параметров в запрос")
    name="Milla"
    age=28
    milla=Person.objects.raw("SELECT * FROM hello_person WHERE name=%s OR age=%s",[name,age])
    print(milla)
    print(milla[0].name)

    return render(request,"index.html")

from django.db import connection

def func15(request):
    with connection.cursor() as cursor:
        cursor.execute("UPDATE hello_person SET name='Tomas' WHERE name='Tom' AND age=32")
        cursor.execute("SELECT * FROM hello_person WHERE name='Tomas'")
        row=cursor.fetchone()
        print(row)
    old_name='Tomas'
    new_name='Tom'
    with connection.cursor() as cursor:
        cursor.execute("UPDATE hello_person SET name=%s WHERE name=%s",[new_name,old_name])
        cursor.execute("SELECT * FROM hello_person WHERE name=%s",[new_name])
        rows=cursor.fetchall()
        for row in rows:
            print(row)
    return render(request,"index.html")




