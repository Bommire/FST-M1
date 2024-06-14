
import pandas
from pandas import ExcelWriter

data = {
	'FirstName':["Sucharitha", "Rohini", "Bhargavi"],
	'LastName':["Bommi", "Gotti", "Vyuu"],
	'Email':["suchi@example.com", "rohi@example.com", "Bhar@example.com"],
	'PhoneNumber':["93822134", "875309213", "874621837"]
}

dataframe = pandas.DataFrame(data)

print(dataframe)

writer = ExcelWriter('sample.xlsx')
dataframe.to_excel(writer, 'Sheet1', index = False)

writer.save()