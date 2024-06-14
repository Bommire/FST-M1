class Car:
    'This class represents a car'

    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(self.manufacturer + " " + self.model + " has started moving")

    def stop(self):
        print(self.manufacturer + " " + self.model + " has stopped moving")

car1 = Car("Innova", "Corolla", "2015", "Manual", "White")
car2 = Car("Benz", "800", "2013", "Manual", "Red")
car3 = Car("BMW", "Swift", "2017", "Automatic", "Black")

car1.accelerate()
car1.stop()