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
@onready var day_text=$CanvasLayer/day_text
@onready var anim_player=$CanvasLayer/AnimationPlayer
@onready var player=$player/Player
var day_count:int
func _ready():
	light.enabled=true
	day_count=1
	set_day_text()
	day_in_out()
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
	match state:
		MORNING:
			morning_state()
		EVENING:
			evening_state()
	
	if state<=3:
		state+=1
	else:
		state=0
		day_count+=1
		set_day_text()
		day_in_out()
func day_in_out():
	anim_player.play("day_in")
	await get_tree().create_timer(3).timeout
	anim_player.play("day_out")
func set_day_text():
	day_text.text="day: "+str(day_count)
