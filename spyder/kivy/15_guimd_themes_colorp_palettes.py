#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Aug 29 11:31:59 2023

@author: damir"""

from kivymd.app import MDApp
from kivymd.uix.button import MDRectangleFlatButton
from kivymd.uix.screen import Screen

class DemoApp(MDApp):
    def build(self):
        self.theme_cls.primary_palette='Green'
        self.theme_cls.primary_hue='A700'
        self.theme_cls.theme_style='Dark'
        screen=Screen()
        btn_flat=MDRectangleFlatButton(text="Hello",
                                       pos_hint={'center_x':0.5,'center_y':0.5})
        screen.add_widget(btn_flat)
        return screen

DemoApp().run()