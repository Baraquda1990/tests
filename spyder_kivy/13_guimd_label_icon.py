#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Aug 29 11:31:59 2023

@author: damir"""

from kivymd.app import MDApp
from kivymd.uix.label import MDLabel,MDIcon

class DemoApp(MDApp):
    def build(self):
        label=MDLabel(text="Hello",halign='center',theme_text_color='Custom',
                      text_color=(0,1,0,1),
                      font_style="H2")
        icon_label=MDIcon(icon="language-python",halign='center')
        return icon_label

DemoApp().run()