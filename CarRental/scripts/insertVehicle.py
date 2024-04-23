import requests
import json
import base64

def encode_image_to_base64(image_path):
    with open(image_path, "rb") as img_file:
        encoded_string = base64.b64encode(img_file.read()).decode('utf-8')
    return encoded_string


url = "http://localhost:8080/api/vehicle/insert"

# Define headers if needed
headers = {'Content-Type': 'application/json'}

# Read car data from JSON file
with open("car_data.json", "r") as file:
    cars_data = json.load(file)

# Loop through each car data
for car_data in cars_data:
    # Encode the image to base64
    base64_encoded_image_data = encode_image_to_base64(car_data["image_path"])

    # Update the data with base64 encoded image
    data = {
        "licenseNumber": car_data["licenseNumber"],
        "vehicleStatus": car_data["vehicleStatus"],
        "make": car_data["make"],
        "model": car_data["model"],
        "carType": car_data["carType"],
        "mileage": car_data["mileage"],
        "passengerCapacity": car_data["passengerCapacity"],
        "price": car_data["price"],
        "image": base64_encoded_image_data
    }

    # Convert data to JSON format
    json_data = json.dumps(data)

    # Send the data for the current car
    response = requests.post(url, data=json_data, headers=headers)

    # Check if the request was successful
    print(response.text)
    # print(data)
