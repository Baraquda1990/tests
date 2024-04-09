extends Panel


# Declare member variables here. Examples:
# var a = 2
# var b = "text"
var summ=0

# Called when the node enters the scene tree for the first time.
func _ready():
	set_process(true)

func _process(delta):
	summ+=delta
	get_node("Label").set_text(str(summ))


# Called every frame. 'delta' is the elapsed time since the previous frame.
#func _process(delta):
#	pass
