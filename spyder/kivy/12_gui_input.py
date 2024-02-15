#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Aug 29 11:31:59 2023

@author: damir"""

from kivy.app import App
from kivy.uix.textinput import TextInput
from kivy.uix.button import Button
from kivy.core.window import Window
from kivy.uix.gridlayout import GridLayout

Window.clearcolor=(1,1,1,1)
Window.size=(360,600)

class MainApp(App):
    def build(self):
        self.вес=TextInput(text="Введите ваш вес:")
        self.рост=TextInput(text="Введите ваш рост:")
        btn=Button(text="Отправить", on_press=self.submit)
        grdl=GridLayout(cols=1,row_force_default=True,row_default_height=40,
                        spacing=10,padding=15)
        grdl.add_widget(self.вес)
        grdl.add_widget(self.рост)
        grdl.add_widget(btn)
        return grdl
    def submit(self,obj):
        print("Вес= "+self.вес.text)
        print("Рост= "+self.рост.text)
    
MainApp().run()