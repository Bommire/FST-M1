import pytest

def test_addition():
	
	num1 = 40
	num2 = 10
    
	sum = num1 + num2
	assert sum == 50
def test_subtraction():
  
	num1 = 10
	num2 = 5
    
	diff = num1 - num2
	assert diff == 5
@pytest.mark.activity
def test_multiplication():
  
	num1 = 50
	num2 = 2
    
	prod = num1 * num2
	assert prod == 100
@pytest.mark.activity
def test_division():
  
	num1 = 100
	num2 = 5
    
	quot = num1 / num2

	assert quot == 30