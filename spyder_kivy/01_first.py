#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Aug 22 12:26:04 2023
https://kivy.org/doc/stable/gettingstarted/intro.html
@author: damir
"""

import kivy
from kivy.app import App
from kivy.uix.label import Label

class MyApp(App):
    def build(self):
        return Label(text="Привет Мир")

if __name__=="__main__":
    MyApp().run()