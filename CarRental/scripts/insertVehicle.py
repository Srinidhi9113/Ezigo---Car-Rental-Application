import requests
import json

import base64

def encode_image_to_base64(image_path):
    with open(image_path, "rb") as img_file:
        encoded_string = base64.b64encode(img_file.read()).decode('utf-8')
    return encoded_string

image_path = r"E:\6TH_SEM\OOAD\Ezigo---Car-Rental-Application\CarRental\images\car_1.jpeg"
base64_encoded_image_data = encode_image_to_base64(image_path)


# Define the URL where you want to send the data
url = "http://localhost:8080/api/vehicle/insert"


# Define the data you want to send in JSON format
data = {
    "licenseNumber": "ABC123",
    "vehicleStatus": "AVAILABLE",
    "make": "Toyota",
    "model": "Corolla",
    "carType": "ECONOMY",
    "mileage": 5.0,
    "passengerCapacity": 5,
    "price": 500.0,
    "image": base64_encoded_image_data
}

# Convert data to JSON format
json_data = json.dumps(data)

# Define headers if needed
headers = {'Content-Type': 'application/json'}

response = requests.post(url, data=json_data,headers=headers)

# Check if the request was successful
print(response.text)