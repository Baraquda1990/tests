#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Aug 29 11:31:59 2023

@author: damir"""

from kivy.app import App
from kivy.uix.button import Button
from kivy.core.window import Window

Window.clearcolor=(0,0,0,1)

class MainApp(App):
    def build(self):
        button=Button(text="Я Бэтмен",size_hint=(0.2,0.3),font_size='20sp',
                      pos_hint={'center_x':0.5,'center_y':0.5},
                      on_press=self.printpress,on_release=self.printrelease)
        return button
    def printpress(self,obj):
        print("Бэтмен Рулит")
    def printrelease(self,obj):
        print("Супермен Сосёт")
    
MainApp().run()