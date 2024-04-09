extends Sprite


# Declare member variables here. Examples:
# var a = 2
# var b = "text"
var speed=400
var angular_speed=PI

# Called when the node enters the scene tree for the first time.
func _ready():
	print("Привет Мир")


# Called every frame. 'delta' is the elapsed time since the previous frame.
func _process(delta):
	var direction=0
	if Input.is_action_pressed("ui_left"):
		direction=-1
	if Input.is_action_pressed("ui_right"):
		direction=1
	
	rotation+=angular_speed*delta*direction
	var velocity=Vector2.ZERO
	if Input.is_action_pressed("ui_up"):
		velocity=Vector2.UP.rotated(rotation)*speed
	position+=velocity*delta
