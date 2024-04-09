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
	rotation+=angular_speed*delta
	var velocity=Vector2.UP.rotated(rotation)*speed
	position+=velocity*delta
	print(rotation)
