#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Aug 29 11:31:59 2023

@author: damir"""

from kivy.app import App
from kivy.uix.image import Image,AsyncImage
from kivy.core.window import Window

Window.clearcolor=(0,0,0,1)

class MainApp(App):
    def build(self):
        #img=Image(source="./margo.png")
        img=AsyncImage(source="https://almode.ru/uploads/posts/2020-11/1604414958_48-p-margo-robbi-70.jpg")
        return img
    
MainApp().run()