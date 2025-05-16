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




