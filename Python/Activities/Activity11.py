fruit_shop = {
    "Guva": 30,
    "Mango": 50,
    "pinapple": 34,
    "watermelon" :20
}

key_to_check = input("What are you looking for? ").lower()

if(key_to_check in fruit_shop):
    print("Yes, this is available")
else:
    print("No, this is not available")