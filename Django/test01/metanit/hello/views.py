from django.shortcuts import render
from django.http import HttpResponse
from django.http import HttpResponseRedirect,HttpResponsePermanentRedirect
from django.http import HttpResponseNotFound, HttpResponseForbidden, HttpResponseBadRequest
from django.http import JsonResponse
from django.core.serializers.json import DjangoJSONEncoder

def index(request):
    print(f"request.scheme {request.scheme}")
    print(f"request.body {request.body}")
    print(f"request.path {request.path}")
    print(f"request.method {request.method}")
    print(f"request.encoding {request.encoding}")
    print(f"request.content_type {request.content_type}")
    print(f"request.GET {request.GET}")
    print(f"request.POST {request.POST}")
    print(f"request.COOKIES {request.COOKIES}")
    print(f"request.FILES {request.FILES}")
    print(f"request.META {request.META}")
    print(f"request.headers {request.headers}")
    print(f"request.get_full_path() {request.get_full_path()}")
    print(f"request.get_host() {request.get_host()}")
    print(f"request.get_port() {request.get_port()}")
    host = request.META["HTTP_HOST"] # получаем адрес сервера
    user_agent = request.META["HTTP_USER_AGENT"]    # получаем данные бразера
    path = request.path     # получаем запрошенный путь
    return HttpResponse(f"""
        <p>Host: {host}</p>
        <p>Path: {path}</p>
        <p>User-agent: {user_agent}</p>
        Hello-METANIT
    """)

def about(request):
    return HttpResponse("<h1>О сайте</h1>")

def contacts(request):
    return HttpResponse("<h1>Контакты</h1>")

def programmer(request,name,spec):
    return HttpResponse(f"""
        <h1>{name}</h1>
        <h1>Best of the Best {spec}</h1>
    """)

def secretCode(request):
    return HttpResponse(content="Hello Metanit", headers={"SecretCode":"2025"})

def error(request):
    return HttpResponse("Ошибочка вышла",status=400,reason="Incorrect data")

def contentType(request):
    return HttpResponse("<h1>Hello</h1>",content_type="text/plain",charset="utf-8")


def paramViews(request,name="Undefined",age=0):
    return HttpResponse(f"<h2>User: {name}, age: {age}</h2>")

def paramViews2(request,name="Undefined",age=0):
    return HttpResponse(f"<h2>User: {name}, age: {age}</h2>")


def products(request, id):
    return HttpResponse(f"Товар {id}")
 
def comments(request, id):
    return HttpResponse(f"Комментарии о товаре {id}")
 
def questions(request, id):
    return HttpResponse(f"Вопросы о товаре {id}")


def paramStrRequest(request):
    user=request.GET.get("user","Undefined")
    age=request.GET.get("age",0)
    return HttpResponse(f"<h2>Имя: {user},Возраст {age}</h2>")


def index2(request):
    return HttpResponse("Index")
 
def about2(request):
    return HttpResponse("About")
 
def contact2(request):
    return HttpResponseRedirect("/about2")
 
def details2(request):
    return HttpResponsePermanentRedirect("/123")


def ind(request, id):
    people = ["Tom", "Bob", "Sam"]
    # если пользователь найден, возвращаем его
    if id in range(0, len(people)):
        return HttpResponse(people[id])
    # если нет, то возвращаем ошибку 404
    else:
        return HttpResponseNotFound("Not Found")
 
def access(request, age):
    # если возраст НЕ входит в диапазон 1-110, посылаем ошибку 400
    if age not in range(1, 111):
        return HttpResponseBadRequest("Некорректные данные")
    # если возраст больше 17, то доступ разрешен
    if(age > 17):
        return HttpResponse("Доступ разрешен")
    # если нет, то возвращаем ошибку 403
    else:
        return HttpResponseForbidden("Доступ заблокирован: недостаточно лет")
    

def jsonData(request):
    return JsonResponse({"name":"Damir","spec":"Programmer"})


def jsonData2(request):
    bob = Person("Bob", 41)
    return JsonResponse(bob, safe=False, encoder=PersonEncoder)
 
class Person:
  
    def __init__(self, name, age):
        self.name = name    # имя человека
        self.age = age        # возраст человека
 
class PersonEncoder(DjangoJSONEncoder):
    def default(self, obj):
        if isinstance(obj, Person):
            return {"name": obj.name, "age": obj.age}
            # return obj.__dict__
        return super().default(obj)


# установка куки
def set(request):
    # получаем из строки запроса имя пользователя
    username = request.GET.get("username", "Undefined")
    response = HttpResponse(f"Hello {username}")
    # передаем его в куки
    response.set_cookie("username", username)
    return response
 
# получение куки
def get(request):
    # получаем куки с ключом username
    username = request.COOKIES["username"]
    return HttpResponse(f"Hello {username}")