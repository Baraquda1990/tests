mass = [9, 3, 4, 8, 2, 5, 7, 1, 6, 10]

length = len(mass)
flag:bool
for i in range(length):
	flag=False
	for j in range(length-i-1):
		if mass[j] > mass[j+1]:
			flag=True  
			mass[j], mass[j+1] = mass[j+1], mass[j]
	print(mass)
	if flag==False:
		break        
	