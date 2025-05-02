from django.shortcuts import render
from django.template.response import TemplateResponse
from datetime import datetime 

def index(request):
    data={"header":"Hello","message":"Metanit"}
    return render(request,"index.html",context=data)
def about(request):
    header = "Данные пользователя"              # обычная переменная
    langs = ["Python", "Java", "C#"]            # список
    user ={"name" : "Tom", "age" : 23}          # словарь
    address = ("Абрикосовая", 23, 45)           # кортеж
    data = {"header": header, "langs": langs, "user": user, "address": address}
    return render(request,"about.html",context=data)
    #return TemplateResponse(request,"about.html",data)
def contacts(request):
    return render(request, "contacts.html", context = {"person": Person("Tom")})
 
class Person:
    def __init__(self, name):
        self.name = name    # имя человека


def insert_tags(request):
    langs=["Python", "Java", "C#"]
    data = {"red": "красный", "green": "зеленый", "blue":"синий"}
    return render(request, "insert_tags.html", context = {"body": "<h1>Hello World!</h1>","n":5,"langs":langs,"data":data})

def date_time(request):
    return render(request,"date_time.html")

def date_time_format(request):
    return render(request,"date_time_format.html",context={"my_date":datetime.now()})