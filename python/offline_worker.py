import os
import time

def work_offline():
    log = "offline.log"
    with open(log, "a") as f:
        f.write("Offline task running\n")

if __name__ == "__main__":
    for _ in range(3):
        work_offline()
        time.sleep(1)
