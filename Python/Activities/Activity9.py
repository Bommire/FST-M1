
queueOne = [45, 65, 81, 11, 67]
queueTwo = [19, 34, 90, 24, 12]

print("First List ", queueOne)
print("Second List ", queueTwo)

thirdList = []

for num in queueOne:
    if (num % 2 != 0):
        thirdList.append(num)
        
for num in queueTwo:
    if (num % 2 == 0):
        thirdList.append(num)

print("result List is:")
print(thirdList)