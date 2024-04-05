#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Aug 29 11:31:59 2023

@author: damir"""

from kivy.app import App
from kivy.uix.button import Button
from kivy.uix.image import Image
from kivy.uix.boxlayout import BoxLayout
from kivy.core.window import Window

Window.clearcolor=(1,1,1,1)
Window.size=(360,600)

class MainApp(App):
    def build(self):
        layout=BoxLayout(orientation='vertical',spacing=100,padding=80)
        '''btn=Button(text='Button1')
        btn2=Button(text='Button1')
        btn3=Button(text='Button1')
        layout.add_widget(btn)
        layout.add_widget(btn2)
        layout.add_widget(btn3)'''
        img=Image(source="./margo.png")
        btn=Button(text="Login",size_hint=(None,None),pos_hint={'center_x':0.5},
                   width=100,height=50)
        layout.add_widget(img)
        layout.add_widget(btn)
        return layout
    
MainApp().run()