"""
URL configuration for metanit project.

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/5.2/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path,re_path,include
from hello import views

product_patterns = [
    path("", views.products),
    path("comments", views.comments),
    path("questions", views.questions),
]

urlpatterns = [
    path('admin/', admin.site.urls),
    path('',views.index,name='home'),
    re_path(r'^about/contacts',views.contacts),
    re_path(r'^about',views.about),
    path('contacts',views.contacts),
    re_path('^spec',views.programmer,kwargs={"name":"Damir","spec":"Programmer"}),
    path('secret',views.secretCode),
    path('error',views.error),
    path('ContentType',views.contentType),

    path("user",views.paramViews),
    path("user/<str:name>",views.paramViews),
    path("user/<name>/<int:age>",views.paramViews),

    re_path("reuser/(?P<name>\D+)/(?P<age>\d+)",views.paramViews2),
    re_path("reuser/(?P<name>\D+)",views.paramViews2),
    re_path("reuser",views.paramViews2),

    path("products/<int:id>/", include(product_patterns)),

    path("paramget/", views.paramStrRequest),


    path("123", views.index2),
    path("about2/", views.about2),
    path("contact/", views.contact2),
    path("details/", views.details2),


    path("ind/<int:id>", views.ind),
    path("access/<int:age>", views.access),


    path("jsondata", views.jsonData),
    path("jsondata2", views.jsonData2),


    path("set", views.set),
    path("get", views.get),
]
