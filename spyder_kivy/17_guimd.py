#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Aug 29 11:31:59 2023

@author: damir"""

from kivymd.app import MDApp
from kivymd.uix.textfield import MDTextField
from kivymd.uix.button import MDRectangleFlatButton,MDFlatButton
from kivymd.uix.screen import Screen
from kivy.lang import Builder
from helpers import username_helper
from kivymd.uix.dialog import MDDialog


class DemoApp(MDApp):
    def build(self):
        screen=Screen()
        self.theme_cls.primary_palette="Green"
        #username=MDTextField(text="Введите имя пользователя",pos_hint={'center_x':0.5,'center_y':0.5},
        #                     size_hint_x=None,width=300)
        button=MDRectangleFlatButton(text="Show",pos_hint={'center_x':0.5,'center_y':0.4},
                                     on_release=self.show_data)
        self.username=Builder.load_string(username_helper)
        screen.add_widget(self.username)
        screen.add_widget(button)
        return screen
    def show_data(self,obj):
        if self.username.text is "":
            check_string="Please enter a username"
        else:
            check_string=self.username.text+" does not exist"
        print(self.username.text)
        close_btn=MDFlatButton(text="Close",on_release=self.close_dialog)
        more_btn=MDFlatButton(text="More")
        self.dialog=MDDialog(title="Username Check",text=check_string,
                        size_hint=(0.5,1),
                        buttons=[close_btn,more_btn])
        self.dialog.open()
    def close_dialog(self,obg):
        self.dialog.dismiss()
        
DemoApp().run()