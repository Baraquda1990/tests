from django.shortcuts import render
from .models import Person

# Create your views here.

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