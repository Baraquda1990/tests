#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Aug 25 10:01:30 2023

@author: damir
"""

from kivy.app import App
from kivy.uix.widget import Widget
from kivy.uix.button import Button
from kivy.core.window import Window
from kivy.graphics import Color,Ellipse,Line
from random import randint

Window.clearcolor=(1,155.0/255.0,128/255.0,1)

class PaintWindow(Widget):
    def on_touch_down(self, touch):
        colorR=randint(0,255)/255
        colorG=randint(0,255)/255
        colorB=randint(0,255)/255
        self.canvas.add(Color(rgb=(colorR,colorG,colorB)))
        d=30
        self.canvas.add(Ellipse(pos=(touch.x-d/2,touch.y-d/2),size=(d,d)))
        touch.ud['line']=Line(points=(touch.x,touch.y))
        self.canvas.add(touch.ud['line'])
    def on_touch_move(self,touch):
        touch.ud['line'].points+=[touch.x,touch.y]

class PaintApp(App):
    def build(self):
        rootWindow=Widget()
        self.painter=PaintWindow()
        clearBtn=Button(text='Clear')
        clearBtn.bind(on_release=self.clear_canvas)
        rootWindow.add_widget(self.painter)
        rootWindow.add_widget(clearBtn)
        return rootWindow
    def clear_canvas(self,obj):
        self.painter.canvas.clear()
    
PaintApp().run()