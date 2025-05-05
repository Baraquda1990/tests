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
from django.urls import path
from hello import views
from django.views.generic import TemplateView


urlpatterns = [
    path('admin/', admin.site.urls),
    path("",views.index),
    path("about",views.about),
    path("contacts",views.contacts),
    path("insert_tags",views.insert_tags),
    path("date_time",views.date_time),
    path("date_time_format",views.date_time_format),
    path("index2",views.index2),
    path("tvabout/",TemplateView.as_view(template_name="tvabout.html",extra_context={"header":"О сайте"})),
    path("tvcontact/",TemplateView.as_view(template_name="tvcaontact.html")),
    path("parentindex", views.parentIndex),
    path("baseindex", views.baseindex),
    path("basecontacts/", views.basecontacts),
]
