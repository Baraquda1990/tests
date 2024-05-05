extends Area2D



func _on_body_exited(body):
	if body.name=="Player":
		var tween=get_tree().create_tween()
		var tween2=get_tree().create_tween()
		tween.tween_property(self,"position",position-Vector2(0,25),0.5)
		tween2.tween_property(self,"modulate:a",0,0.5)
		tween.tween_callback(queue_free)
		body.gold+=1
