import RPi.GPIO as GPIO
import sys
import time

GPIO.setmode(GPIO.BCM)
GPIO.setwarnings(False)
GPIO.setup(15,GPIO.OUT)
GPIO.setup(18,GPIO.OUT)

if sys.argv[1] == "green":
    print("Green LED on")
    GPIO.output(15,GPIO.LOW)
    print("Red LED off")
    GPIO.output(18,GPIO.HIGH)
elif sys.argv[1] == "red":
    print("Green LED off")
    GPIO.output(15,GPIO.HIGH)
    print("Red LED on")
    GPIO.output(18,GPIO.LOW)
elif sys.argv[1] == "off":
    print("LED off")
    GPIO.output(15, GPIO.HIGH)
    GPIO.output(18, GPIO.HIGH)

