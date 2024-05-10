extends CharacterBody2D

enum{
	IDLE,
	ATTACK,
	CHASE
}
var state:int=0:
	set(value):
		state=value
		match state:
			IDLE:
				idle_state()
			ATTACK:
				attack_state()
const SPEED = 300.0
const JUMP_VELOCITY = -400.0
@onready var anim_player=$AnimationPlayer
@onready var sprite=$AnimatedSprite2D
# Get the gravity from the project settings to be synced with RigidBody nodes.
var player
var direction
func _ready():
	Global.connect("player_position_update",Callable (self,"_on_player_position_update"))
func _on_player_position_update(player_pos):
	player=player_pos
var gravity = ProjectSettings.get_setting("physics/2d/default_gravity")
func _physics_process(delta):
	if state==CHASE:
		chase_state()
	# Add the gravity.
	if not is_on_floor():
		velocity.y += gravity * delta
	move_and_slide()
func _on_attack_range_body_entered(_body):
	state=ATTACK
func idle_state():
	anim_player.play("idle")
	await get_tree().create_timer(1).timeout
	$attack_direction/attack_range/CollisionShape2D.disabled=false
	state=CHASE
func attack_state():
	anim_player.play("attack")
	await anim_player.animation_finished
	$attack_direction/attack_range/CollisionShape2D.disabled=true
	state=IDLE
func chase_state():
	direction=(player-self.position).normalized()
	if direction.x<0:
		sprite.flip_h=true
		$attack_direction.rotation_degrees=180
	else:
		sprite.flip_h=false
		$attack_direction.rotation_degrees=0
