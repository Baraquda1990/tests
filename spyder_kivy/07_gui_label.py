#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Aug 29 11:31:59 2023

@author: damir"""

from kivy.app import App
from kivy.uix.label import Label
from kivy.core.window import Window

Window.clearcolor=(0,0,0,1)

class MainApp(App):
    def build(self):
        label=Label(text="Потому что я Бетмен.", font_size="20sp",bold=True,
                    color=(0,0,1,1),
                    italic=True)
        return label
    
MainApp().run()