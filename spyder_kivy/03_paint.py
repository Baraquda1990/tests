#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Aug 22 14:41:24 2023

@author: damir
"""

from kivy.app import App
from kivy.uix.widget import Widget
from kivy.graphics import Color,Ellipse,Line
from random import random
from kivy.uix.button import Button

class MyPaintWidget(Widget):
    def on_touch_down(self, touch):
        print(touch)
        #color=(random(),random(),random())
        color=(random(),1,1)
        with self.canvas:
            #Color(*color)
            Color(*color,mode='hsv')
            d=30.
            Ellipse(pos=(touch.x-d/2,touch.y-d/2),size=(d,d))
            touch.ud['line']=Line(points=(touch.x,touch.y))
    def on_touch_move(self, touch):
        touch.ud['line'].points+=[touch.x,touch.y]
    
class MyApp(App):
    def build(self):
        parent=Widget()
        self.painter=MyPaintWidget()
        clearbtn=Button(text='clear')
        clearbtn.bind(on_release=self.clear_canvas)
        parent.add_widget(self.painter)
        parent.add_widget(clearbtn)
        return parent
    def clear_canvas(self,obj):
        self.painter.canvas.clear()

if __name__=="__main__":
    MyApp().run()