extends CharacterBody2D

enum{
	MOVE,
	ATTACK,
	ATTACK2,
	ATTACK3,
	BLOCK,
	SLIDE,
	DAMAGE,
	DEATH
}

const SPEED = 150.0
const JUMP_VELOCITY = -400.0

# Get the gravity from the project settings to be synced with RigidBody nodes.
var gravity = ProjectSettings.get_setting("physics/2d/default_gravity")
#@onready var anim=get_node("AnimatedSprite2D")
@onready var anim=$AnimatedSprite2D
@onready var anim_player=$AnimationPlayer
@onready var stats=$stats
var gold=0
var state=MOVE
var run_speed=1
var combo=false
var attack_cooldown=false
var player_pos
var damage_basic=10
var damage_multiplie=1
var damage_current
var recovery=false
func _physics_process(delta):
	player_pos=self.position
	Global.emit_signal("player_position_update",player_pos)
	match state:
		MOVE:
			move_state()
		ATTACK:
			attack_state()
		ATTACK2:
			attack2_state()
		ATTACK3:
			attack3_state()
		BLOCK:
			block_state()
		SLIDE:
			slide_state()
		DAMAGE:
			damage_state()
		DEATH:
			death_state()
	
	damage_current=damage_basic*damage_multiplie
	
	# Add the gravity.
	if not is_on_floor():
		velocity.y += gravity * delta

	if velocity.y>0:
		anim_player.play("fall")
	move_and_slide()
func _ready():
	Global.connect("enemy_attack",Callable(self,"_on_damage"))
func move_state():
	var direction = Input.get_axis("left", "right")
	if direction:
		velocity.x = direction * SPEED*run_speed
		if velocity.y==0:
			if run_speed==1:
				anim_player.play("walk")
			else:
				anim_player.play("run")
	else:
		velocity.x = move_toward(velocity.x, 0, SPEED)
		if velocity.y==0:
			anim_player.play("idle")
	if direction==-1:
		anim.flip_h=true
		$attack_direction.rotation_degrees=180
	elif direction==1:
		anim.flip_h=false
		$attack_direction.rotation_degrees=0
	if Input.is_action_pressed("run") and not recovery:
		run_speed=2
		stats.stamina-=stats.run_cost
	else:
		run_speed=1
	if Input.is_action_pressed("block"):
		if velocity.x==0:
			if not recovery:
				if stats.stamina>1:
					state=BLOCK
		else:
			if not recovery:
				stats.stamina_cost=stats.slide_cost
				if stats.stamina>stats.stamina_cost:
					state=SLIDE
	if Input.is_action_just_pressed("attack"):
		if not recovery:
			stats.stamina_cost=stats.attack_cost
			if attack_cooldown==false and stats.stamina_cost<stats.stamina:
				state=ATTACK
func block_state():
	stats.stamina-=stats.block_cost
	velocity.x=0
	anim_player.play("block")
	if Input.is_action_just_released("block"):
		state=MOVE
func slide_state():
	anim_player.play("slide")
	await anim_player.animation_finished
	state=MOVE
func attack_state():
	stats.stamina_cost=stats.attack_cost
	damage_multiplie=1
	if Input.is_action_just_pressed("attack") and combo==true and stats.stamina_cost<stats.stamina:
		state=ATTACK2
	velocity.x=0
	anim_player.play("attack")
	await anim_player.animation_finished
	attack_freez()
	state=MOVE
func combo1():
	combo=true
	await anim_player.animation_finished
	combo=false
func attack2_state():
	stats.stamina_cost=stats.attack_cost
	damage_multiplie=2
	if Input.is_action_just_pressed("attack") and combo==true and stats.stamina_cost<stats.stamina:
		state=ATTACK3
	anim_player.play("attack2")
	await anim_player.animation_finished
	state=MOVE
func attack3_state():
	
	damage_multiplie=3
	anim_player.play("attack3")
	await anim_player.animation_finished
	state=MOVE
func attack_freez():
	attack_cooldown=true
	await get_tree().create_timer(0.5).timeout
	attack_cooldown=false
func damage_state():
	velocity.x=0
	anim.play("damage")
	await anim.animation_finished
	state=MOVE
func _on_damage(enemy_damage):
	if state==BLOCK:
		enemy_damage/=2
	elif state==SLIDE:
		enemy_damage=0
	else:
		state=DAMAGE
	stats.health-=enemy_damage
	if stats.health<=0:
		stats.health=0
		state=DEATH
func death_state():
	velocity.x=0
	anim.play("death")
	await anim.animation_finished
	queue_free()
	get_tree().change_scene_to_file("res://menu.tscn")


func _on_hitbox_area_entered(area):
	Global.emit_signal("player_attack",damage_current)


func _on_stats_no_stamina():
	recovery=true
	await get_tree().create_timer(2).timeout
	recovery=false
