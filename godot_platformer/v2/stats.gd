extends CanvasLayer
signal no_stamina()
@onready var stats_bar=$TextureProgressBar
@onready var stamina_bar=$TextureProgressBar2
@onready var health_anim=$"../health_anim"
@onready var health_text=$"../health_text"
var max_health=120
var old_health=max_health
var health:
	set(value):
		health=clamp(value,0,max_health)
		stats_bar.value=health
		var difference=health-old_health
		old_health=health
		if difference>0:
			health_text.text=str(difference)
			health_anim.play("health")
		elif difference<0:
			health_text.text=str(difference)
			health_anim.play("damage")
var stamina=50:
	set(value):
		stamina=value
		if stamina<1:
			emit_signal("no_stamina")
var attack_cost=10
var block_cost=0.5
var slide_cost=20
var run_cost=0.3
var stamina_cost
func _ready():
	health=max_health
	stats_bar.max_value=health
	stats_bar.value=health
	health_text.modulate.a=0
func _process(delta):
	stamina_bar.value=stamina
	if stamina<100:
		stamina+=10*delta

func stamina_consumtion():
	stamina-=stamina_cost

func _on_health_regen_timeout():
	health+=1
