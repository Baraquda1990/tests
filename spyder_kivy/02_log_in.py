#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Aug 22 12:36:54 2023

@author: damir
"""

import kivy
import sys
from kivy.app import App
from kivy.uix.label import Label
from kivy.uix.textinput import TextInput
from kivy.uix.gridlayout import GridLayout

class LoginScreen(GridLayout):
    def __init__(self, **kwargs):
        super(LoginScreen, self).__init__(**kwargs)
        self.cols=2
        self.add_widget(Label(text="User Name"))
        self.username=TextInput(multiline=False)
        self.add_widget(self.username)
        self.password=TextInput(password=True,multiline=False)
        self.add_widget(self.password)

class MyApp(App):
    def build(self):
        return LoginScreen()

if __name__=='__main__':
    MyApp().run()
    sys.exit(0)