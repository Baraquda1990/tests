from django.shortcuts import render
from django.http import HttpResponse

def index(request):
    return render(request,"index.html")

def postuser(request):
    name=request.POST.get("name","Undefined")
    age=request.POST.get("age",1)
    langs=request.POST.getlist("languages",["python"])
    langs2=request.POST.getlist("languages2",["C++"])
    return HttpResponse(f"""
                        <h2>Name: {name} Age: {age}</h2>
                        <div>Languages: {langs}</div>
                        <div>Languages2: {langs2}</div>
                    """)

from .forms import UserForm

def index2(request):
    if request.method=="POST":
        user=request.POST.get("name")
        age=request.POST.get("age")
        return HttpResponse(f"<h2>Привет, {user}, твой возраст :{age}</h2>")
    else:
        userform=UserForm(field_order=['age','comment'])
        return render(request,"index2.html",{"form":userform})

from .forms import UserForm2

def index3(request):
    if request.method=="POST":
        userform=UserForm2(request.POST)
        if userform.is_valid():
            user=userform.cleaned_data["name"]
            age=userform.cleaned_data["age"]
            email=userform.cleaned_data["email"]
            return HttpResponse(f"<h2>Привет, {user}, твой возраст :{age}, email: {email}</h2>")
        else:
            return HttpResponse("Invalid data")
    else:
        userform=UserForm2()
        return render(request,"index3.html",{"form":userform})