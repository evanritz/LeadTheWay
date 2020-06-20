import board
import time
import busio
import sys
import RPi.GPIO as GPIO
import adafruit_ads1x15.ads1115 as ADS
from adafruit_ads1x15.analog_in import AnalogIn

GPIO.setmode(GPIO.BCM)
GPIO.setwarnings(False)
GPIO.setup(15,GPIO.OUT)
GPIO.setup(18,GPIO.OUT)
GPIO.setup(23,GPIO.IN, pull_up_down = GPIO.PUD_DOWN)

i2c = busio.I2C(board.SCL, board.SDA)
ads = ADS.ADS1115(i2c)

hard_switch = GPIO.input(23)

ads.gain = 4
iterations = int(sys.argv[1])
max_avg = 32767
sum = 0

if not hard_switch:

    for i in range(iterations):
        chan = AnalogIn(ads, ADS.P0)	
        sum += chan.value
        print(chan.value, chan.voltage)
        time.sleep(1)

    avg = sum/iterations
    ratio = avg/max_avg
    print("Average=" + str(avg))
    print("Ratio=" + str(ratio))


    if ratio >= .8:
        GPIO.output(15,GPIO.HIGH)
        GPIO.output(18,GPIO.LOW)
        print("Smoke?=" + str(True))
    else:
        GPIO.output(15,GPIO.LOW)
        GPIO.output(18,GPIO.HIGH)
        print("Smoke?=" + str(False))

else:
    print('Hardware Switch flipped! Auto fire detect mode enabled')
    GPIO.output(15,GPIO.HIGH)
    GPIO.output(18,GPIO.LOW)
    print('Smoke?=' + str(True))




