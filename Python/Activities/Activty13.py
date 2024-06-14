
def calculate_sum(numbers):
	sum = 0
	for number in numbers:
		sum += number
	return sum
List = [78,24,17,18]
result = calculate_sum(List)
print("The sum of all the elements is: " + str(result))