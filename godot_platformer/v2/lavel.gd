extends Node2D
enum{
	MORNING,
	DAY,
	EVENING,
	NIGHT
}
var state=MORNING
@onready var light=$DirectionalLight2D
@onready var point_light1=$PointLight2D
@onready var point_light2=$PointLight2D2
func _ready():
	light.enabled=true
func _process(delta):
	match state:
		MORNING:
			morning_state()
		EVENING:
			evening_state()
func morning_state():
	var tween=get_tree().create_tween()
	tween.tween_property(light,"energy",0.2,20)
	var tween2=get_tree().create_tween()
	tween2.tween_property(point_light1,"energy",0,20)
	var tween3=get_tree().create_tween()
	tween3.tween_property(point_light2,"energy",0,20)
func evening_state():
	var tween=get_tree().create_tween()
	tween.tween_property(light,"energy",0.99,20)
	var tween2=get_tree().create_tween()
	tween2.tween_property(point_light1,"energy",2.01,20)
	var tween3=get_tree().create_tween()
	tween3.tween_property(point_light2,"energy",2.01,20)
func _on_day_night_timeout():
	state+=1
	if state>3:
		state=0
