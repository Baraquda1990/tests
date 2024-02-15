#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Aug 29 11:31:59 2023

@author: damir"""

from kivymd.app import MDApp
from kivymd.uix.button import MDFlatButton,MDRectangleFlatButton,MDIconButton,MDFloatingActionButton
from kivymd.uix.screen import Screen

class DemoApp(MDApp):
    def build(self):
        screen=Screen()
        btn_flat=MDFlatButton(text='MDFlatButton',pos_hint={'center_x':0.5,'center_y':0.5})
        btn_r_f=MDRectangleFlatButton(text='MDRectangleFlatButton',pos_hint={'center_x':0.5,'center_y':0.2})
        btn_icon=MDIconButton(icon="android",pos_hint={'center_x':0.5,'center_y':0.3})
        btn_fab=MDFloatingActionButton(icon="language-python",pos_hint={'center_x':0.5,'center_y':0.1})
        screen.add_widget(btn_flat)
        screen.add_widget(btn_r_f)
        screen.add_widget(btn_icon)
        screen.add_widget(btn_fab)
        return screen

DemoApp().run()