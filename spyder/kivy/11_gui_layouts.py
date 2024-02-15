#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Aug 29 11:31:59 2023

@author: damir"""

from kivy.app import App
from kivy.uix.button import Button
from kivy.uix.gridlayout import GridLayout 
from kivy.core.window import Window

Window.clearcolor=(1,1,1,1)
Window.size=(360,600)

class MainApp(App):
    def build(self):
        grid_layout=GridLayout(cols=2,row_force_default=True,row_default_height=40)
        btn1=Button(text="Сладкая",size_hint=(None,None),width=100,height=40)
        btn2=Button(text="Китана")
        btn3=Button(text="Мулатка",size_hint=(None,None),width=100,height=40)
        btn4=Button(text="Джейд")
        grid_layout.add_widget(btn1)
        grid_layout.add_widget(btn2)
        grid_layout.add_widget(btn3)
        grid_layout.add_widget(btn4)
        return grid_layout
    
MainApp().run()