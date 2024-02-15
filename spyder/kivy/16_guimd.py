#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Aug 29 11:31:59 2023

@author: damir"""

from kivymd.app import MDApp
from kivymd.uix.textfield import MDTextField
from kivymd.uix.screen import Screen
from kivy.lang import Builder

username_helper="""
MDTextField:
    hint_text:"Введите имя пользователя"
    helper_text:"or click on forgot usename"
    helper_text_mode:'on_focus'
    icon_right:'android'
    icon_right_color:app.theme_cls.primary_color
    pos_hint:{'center_x':0.5,'center_y':0.5}
    size_hint_x:None
    width:300
"""

class DemoApp(MDApp):
    def build(self):
        screen=Screen()
        self.theme_cls.primary_palette="Green"
        #username=MDTextField(text="Введите имя пользователя",pos_hint={'center_x':0.5,'center_y':0.5},
        #                     size_hint_x=None,width=300)
        username=Builder.load_string(username_helper)
        screen.add_widget(username)
        return screen

DemoApp().run()