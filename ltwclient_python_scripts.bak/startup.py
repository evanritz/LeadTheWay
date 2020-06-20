import os
import RPi.GPIO as GPIO
GPIO.setmode(GPIO.BCM)
GPIO.setwarnings(False)
GPIO.setup(24,GPIO.OUT)

GPIO.output(24,GPIO.HIGH)

filesexists = int(os.popen("ls -R | grep -E 'hostname' | wc -l").read())

if filesexists > 0:
    GPIO.output(24,GPIO.LOW)
    os.system("java -jar LTWClient.jar 1234 client_dir")
else:
    GPIO.output(24,GPIO.LOW)
    os.system("java -jar LTWClient.jar 1234 client_dir ykfgf4qakjeri7au.onion za747inb7bdruie3.onion")


